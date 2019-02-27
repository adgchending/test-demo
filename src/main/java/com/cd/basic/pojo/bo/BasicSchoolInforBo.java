package com.cd.basic.pojo.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class BasicSchoolInforBo {
    private Long id;//主键
    @Excel(name = "学校名", orderNum = "1", isImportField = "true")
    private String schoolName;//学校名
    @Excel(name = "是否自动提醒(1是，0否)最后一个月都提醒", orderNum = "2", isImportField = "true")
    private Integer remindAuto;//是否自动提醒(1是，0否)最后一个月都提醒
    @Excel(name = "学校占地面积", orderNum = "3", isImportField = "true")
    private Long schoolArea;//学校占地面积
    @Excel(name = "学校所属省份编号", orderNum = "4", isImportField = "true")
    private Long provinceCode;//学校所属省份编号
    @Excel(name = "服务有效的开始时间", orderNum = "5", isImportField = "true")
    private java.util.Date validStartTime;//服务有效的开始时间
    @Excel(name = "县区名", orderNum = "6", isImportField = "true")
    private String districtName;//县区名
    @Excel(name = "学校邮编", orderNum = "7", isImportField = "true")
    private Integer schoolPostcode;//学校邮编

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getRemindAuto() {
        return remindAuto;
    }

    public void setRemindAuto(Integer remindAuto) {
        this.remindAuto = remindAuto;
    }

    public Long getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(Long schoolArea) {
        this.schoolArea = schoolArea;
    }

    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getSchoolPostcode() {
        return schoolPostcode;
    }

    public void setSchoolPostcode(Integer schoolPostcode) {
        this.schoolPostcode = schoolPostcode;
    }
}
