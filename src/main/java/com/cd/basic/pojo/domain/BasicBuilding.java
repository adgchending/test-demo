package com.cd.basic.pojo.domain;
public class BasicBuilding implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//主键
    private Long buildingLayer;//楼层数
    private Long campusFkCode;//学校校区表(Basic_Campus)外键的唯一标识
    private Integer delStatus;//删除状态(2为禁用,3为启用)
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private Long fkCode;//外键的唯一标识
    private String buildingName;
    private Long buildingType;//大楼类型code，在系统数据字典中加载
    public BasicBuilding() {
        super();
    }
    public BasicBuilding(Long id,Long buildingLayer,Long campusFkCode,Integer delStatus,java.util.Date createTime,java.util.Date updateTime,Long fkCode,String buildingName,Long buildingType) {
        super();
        this.id = id;
        this.buildingLayer = buildingLayer;
        this.campusFkCode = campusFkCode;
        this.delStatus = delStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fkCode = fkCode;
        this.buildingName = buildingName;
        this.buildingType = buildingType;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuildingLayer() {
        return this.buildingLayer;
    }

    public void setBuildingLayer(Long buildingLayer) {
        this.buildingLayer = buildingLayer;
    }

    public Long getCampusFkCode() {
        return this.campusFkCode;
    }

    public void setCampusFkCode(Long campusFkCode) {
        this.campusFkCode = campusFkCode;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Long getBuildingType() {
        return this.buildingType;
    }

    public void setBuildingType(Long buildingType) {
        this.buildingType = buildingType;
    }

}
