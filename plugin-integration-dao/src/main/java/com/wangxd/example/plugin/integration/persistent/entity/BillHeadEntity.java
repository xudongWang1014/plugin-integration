package com.wangxd.example.plugin.integration.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "acc_bill_head")
public class BillHeadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 列编号 */
    @Id
    @Column(name = "HEAD_KEY")
    private String headKey;

    /** 列名称 */
    @Column(name = "HEAD_NAME")
    private String headName;

    /** 账单类型 */
    @Column(name = "BILL_TYPE")
    private Integer billType;

    /** 列头排序 */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /** 数据格式 */
    @Column(name = "DATA_FORMAT")
    private Integer dataFormat;

    /** 是否属于标准版 */
    @Column(name = "STANDARD_FLAG")
    private Integer standardFlag;

    /** 任务创建时间 */
    @Column(name = "CREATE_TIME")
    private java.util.Date createTime;

    /** 是否失效 */
    @Column(name = "PHYSICS_FLAG")
    private Integer physicsFlag;

    /**修改时间 */
    @Column(name = "UPDATE_TIME")
    private java.util.Date updateTime;

    // 备注
    @Column(name = "HEAD_DESC")
    private String headDesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHeadKey() {
        return headKey;
    }

    public void setHeadKey(String headKey) {
        this.headKey = headKey;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(Integer dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Integer getStandardFlag() {
        return standardFlag;
    }

    public void setStandardFlag(Integer standardFlag) {
        this.standardFlag = standardFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPhysicsFlag() {
        return physicsFlag;
    }

    public void setPhysicsFlag(Integer physicsFlag) {
        this.physicsFlag = physicsFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getHeadDesc() {
        return headDesc;
    }

    public void setHeadDesc(String headDesc) {
        this.headDesc = headDesc;
    }
}
