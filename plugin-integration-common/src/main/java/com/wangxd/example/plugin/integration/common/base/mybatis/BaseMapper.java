package com.wangxd.example.plugin.integration.common.base.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseMapper
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>  {
}
