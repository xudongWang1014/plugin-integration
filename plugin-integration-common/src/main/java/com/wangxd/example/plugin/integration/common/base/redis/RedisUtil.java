package com.wangxd.example.plugin.integration.common.base.redis;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtil {

    Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private StringRedisTemplate redisTemplate;


    public boolean isMemberSet(String redisKey, String data) {
        return redisTemplate.opsForSet().isMember(redisKey, data);
    }

    public String getRedisStrByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setRedisStr(String key, String value, long expireMinute) {
        try {
            redisTemplate.boundValueOps(key).set(value);
            if(expireMinute !=-1) {
                redisTemplate.expire(key, expireMinute, TimeUnit.MINUTES); //过期时间
            }
        } catch (Exception e) {
            logger.info("操作redis异常:{}",e);
        }
    }

    public void deleteKey(String key){
        redisTemplate.delete(key);
    }

    public long deleteMemberInRedisSet( String setKey, String value ) {
        long count =  redisTemplate.boundSetOps(setKey).remove(value);
        //logger.warn(MessageFormat.format("【{0}】 从set:【{1}】移除, 影响条数：【{2}】",value,setKey,count));
        return count;
    }

    public long incrementBy( String key, long step){
        ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
        return valueOper.increment(key, step);
    }

    public void putHashSet( String key, String field, String value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public void putHashSet( String key, String field, String value, long expireMinute) {
        this.putHashSet(key, field, value);
        if(expireMinute !=-1) {
            redisTemplate.expire(key, expireMinute, TimeUnit.MINUTES); //过期时间
        }
    }


    public void putHashSet( String key, Map<String, String> fieldMap) {
        redisTemplate.opsForHash().putAll(key, fieldMap);
    }


    public void putHashSet( String key, Map<String, String> fieldMap, long expireMinute) {
        this.putHashSet( key, fieldMap);
        if(expireMinute !=-1) {
            redisTemplate.expire(key, expireMinute, TimeUnit.MINUTES); //过期时间
        }
    }


    public String getHashSet( String key, String field) {
        HashOperations<String, String, String> hashOper = redisTemplate.opsForHash();
        return hashOper.get(key, field);
    }

    public List<String> getHashSetValues( String key) {
        HashOperations<String, String, String> hashOper = redisTemplate.opsForHash();
        return hashOper.values(key);
    }

    public List<String> getHashSet( String key, List<String> fields) {
        HashOperations<String, String, String> hashOper = redisTemplate.opsForHash();
        return hashOper.multiGet(key, fields);
    }

    public TreeMap<String, String> getHashSetTreeMap( String key, List<String> fields) {
        List<String> result = this.getHashSet(key, fields);
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        for(int i=0; i<fields.size(); i++ ) {
            treeMap.put(fields.get(i), result.get(i));
        }
        return treeMap;
    }

    public void deleteHashSet( String key, String field) {
        HashOperations<String, String, String> hashOper = redisTemplate.opsForHash();
        hashOper.delete(key,field);
    }

    public void putLPush( String key, String value, long expireMinute) {
        redisTemplate.opsForList().leftPush(key,value);
        if(expireMinute !=-1) {
            redisTemplate.expire(key, expireMinute, TimeUnit.MINUTES); //过期时间
        }
    }

    public void pushList( String key, List list, long expireMinute) {
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            putLPush(key, JSONObject.toJSONString(it.next()), expireMinute);
        }
    }

    public List getList( String key, Class clazz) {
        List list = redisTemplate.opsForList().range(key, 0, -1);
        List resultList = new ArrayList<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            resultList.add(JSONObject.parseObject((String) it.next(),clazz));
        }
        return resultList;
    }

    public long getLLEN( String key) {
        long len = redisTemplate.opsForList().size(key);
        return len;
    }
    public  void zSetAdd(String key, String value, double score) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key, value, score);
    }

    public Double zSetGetScore(String key, String value) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.score(key, value);
    }

    public long zSetRemove(String key, Object value) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Long result = zSetOperations.remove(key, value);
        return result != null ? result : -1;
    }

    public Set<String> zSetReverseRange( String key, long start, long end) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.reverseRange(key, start, end);
    }
    public Set<String> zSetRange(String key, long start, long end) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.range(key, start, end);
    }
    public Double zSetScore(String key, String object) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.score(key, object);
    }
    public boolean setIfAbsent(String key, String value, long expireTimestamp, TimeUnit timeUnit) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Boolean result = valueOperations.setIfAbsent(key, value);
        if (result != null && result && expireTimestamp != -1L) {
            expire(key, expireTimestamp, timeUnit);
        }
        return result;
    }
    public boolean expire(String key, long expireTimestamp, TimeUnit timeUnit) {
        return redisTemplate.expire(key, expireTimestamp, timeUnit);
    }
    public long getExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

}
