package com.cd.basic.pojo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("buildingEntity")
public class BuildingEntity implements java.io.Serializable {
    @Excel(name = "大楼名称", orderNum = "1", isImportField = "true")
    private String name;
    @Excel(name = "大楼类型", orderNum = "2", isImportField = "true")
    private String type;
    @Excel(name = "楼层", orderNum = "3", isImportField = "true")
    private String layer;

    public BuildingEntity() {
    }

    public BuildingEntity(String name, String type, String layer) {
        this.name = name;
        this.type = type;
        this.layer = layer;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }
}

