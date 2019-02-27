package com.cd.basic.pojo.domain;

import io.swagger.annotations.ApiModelProperty;

public class BasicSchoolInfor implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键", dataType = "Long", example = "1")
    private Long id;//主键
    @ApiModelProperty(value = "学校名", dataType = "String")
    private String schoolName;//学校名
    @ApiModelProperty(value = "是否自动提醒(1是，0否)最后一个月都提醒", dataType = "Integer", example = "1")
    private Integer remindAuto;//是否自动提醒(1是，0否)最后一个月都提醒
    @ApiModelProperty(value = "学校占地面积", dataType = "Long", example = "1")
    private Long schoolArea;//学校占地面积
    @ApiModelProperty(value = "学校所属省份编号", dataType = "Long", example = "1")
    private Long provinceCode;//学校所属省份编号
    @ApiModelProperty(value = "服务有效的开始时间", dataType = "Long")
    private java.util.Date validStartTime;//服务有效的开始时间
    @ApiModelProperty(value = "县区名", dataType = "String")
    private String districtName;//县区名
    @ApiModelProperty(value = "学校邮编", dataType = "Integer")
    private Integer schoolPostcode;//学校邮编
    @ApiModelProperty(value = "学校创建时间", dataType = "Date")
    private java.util.Date setupTime;//学校创建时间
    @ApiModelProperty(value = "教育局(Sys_Edu_Bureau)外键唯一标识", dataType = "Long")
    private Long eduBureauFkCode;//教育局(Sys_Edu_Bureau)外键唯一标识
    @ApiModelProperty(value = "删除状态", dataType = "Integer")
    private Integer delStatus;//删除状态
    @ApiModelProperty(value = "学校经纬度，格式(22，113)", dataType = "String")
    private String schoolLatlng;//学校经纬度，格式(22，113)
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private java.util.Date createTime;//创建时间
    @ApiModelProperty(value = "学校所属阶段(1幼儿园，2小学，3初中,4高中)如果多个用0隔开，如中幼儿园,小学,初中就是10203", dataType = "Long")
    private Long schoolStages;//学校所属阶段(1幼儿园，2小学，3初中,4高中)如果多个用0隔开，如中幼儿园,小学,初中就是10203
    @ApiModelProperty(value = "学校简介", dataType = "String")
    private String schoolProfile;//学校简介
    @ApiModelProperty(value = "学校办学性质(1公办，2私立)", dataType = "Integer")
    private Integer schoolNature;//学校办学性质(1公办，2私立)
    @ApiModelProperty(value = "学校所属城市代码", dataType = "Long")
    private Long cityCode;//学校所属城市代码
    @ApiModelProperty(value = "学校地址", dataType = "String")
    private String schoolAddress;//学校地址
    @ApiModelProperty(value = "学校的图片URL", dataType = "String")
    private String schoolImage;//学校的图片URL
    @ApiModelProperty(value = "学校编号", dataType = "String")
    private String schoolCode;//学校编号
    @ApiModelProperty(value = "更新时间", dataType = "Date")
    private java.util.Date updateTime;//更新时间
    @ApiModelProperty(value = "学校所属省份名", dataType = "String")
    private String provinceName;//学校所属省份名
    @ApiModelProperty(value = "学校校训", dataType = "String")
    private String schoolMotto;//学校校训
    @ApiModelProperty(value = "外键唯一标识", dataType = "Long")
    private Long fkCode;//外键唯一标识
    @ApiModelProperty(value = "服务有效的结束时间", dataType = "Date")
    private java.util.Date validEndTime;//服务有效的结束时间
    @ApiModelProperty(value = "学校传真", dataType = "String")
    private String schoolFax;//学校传真
    @ApiModelProperty(value = "学校电话", dataType = "String")
    private String schoolTel;//学校电话
    @ApiModelProperty(value = "学校所属城市名", dataType = "String")
    private String cityName;//学校所属城市名
    @ApiModelProperty(value = "县区代码", dataType = "Long")
    private Long districtCode;//县区代码
    @ApiModelProperty(value = "学校英文名", dataType = "String")
    private String schoolEnglishName;//学校英文名

    public BasicSchoolInfor() {
        super();
    }
    public BasicSchoolInfor(Long id,String schoolName,Integer remindAuto,Long schoolArea,Long provinceCode,java.util.Date validStartTime,String districtName,Integer schoolPostcode,java.util.Date setupTime,Long eduBureauFkCode,Integer delStatus,String schoolLatlng,java.util.Date createTime,Long schoolStages,String schoolProfile,Integer schoolNature,Long cityCode,String schoolAddress,String schoolImage,String schoolCode,java.util.Date updateTime,String provinceName,String schoolMotto,Long fkCode,java.util.Date validEndTime,String schoolFax,String schoolTel,String cityName,Long districtCode,String schoolEnglishName) {
        super();
        this.id = id;
        this.schoolName = schoolName;
        this.remindAuto = remindAuto;
        this.schoolArea = schoolArea;
        this.provinceCode = provinceCode;
        this.validStartTime = validStartTime;
        this.districtName = districtName;
        this.schoolPostcode = schoolPostcode;
        this.setupTime = setupTime;
        this.eduBureauFkCode = eduBureauFkCode;
        this.delStatus = delStatus;
        this.schoolLatlng = schoolLatlng;
        this.createTime = createTime;
        this.schoolStages = schoolStages;
        this.schoolProfile = schoolProfile;
        this.schoolNature = schoolNature;
        this.cityCode = cityCode;
        this.schoolAddress = schoolAddress;
        this.schoolImage = schoolImage;
        this.schoolCode = schoolCode;
        this.updateTime = updateTime;
        this.provinceName = provinceName;
        this.schoolMotto = schoolMotto;
        this.fkCode = fkCode;
        this.validEndTime = validEndTime;
        this.schoolFax = schoolFax;
        this.schoolTel = schoolTel;
        this.cityName = cityName;
        this.districtCode = districtCode;
        this.schoolEnglishName = schoolEnglishName;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getRemindAuto() {
        return this.remindAuto;
    }

    public void setRemindAuto(Integer remindAuto) {
        this.remindAuto = remindAuto;
    }

    public Long getSchoolArea() {
        return this.schoolArea;
    }

    public void setSchoolArea(Long schoolArea) {
        this.schoolArea = schoolArea;
    }

    public Long getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public java.util.Date getValidStartTime() {
        return this.validStartTime;
    }

    public void setValidStartTime(java.util.Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getSchoolPostcode() {
        return this.schoolPostcode;
    }

    public void setSchoolPostcode(Integer schoolPostcode) {
        this.schoolPostcode = schoolPostcode;
    }

    public java.util.Date getSetupTime() {
        return this.setupTime;
    }

    public void setSetupTime(java.util.Date setupTime) {
        this.setupTime = setupTime;
    }

    public Long getEduBureauFkCode() {
        return this.eduBureauFkCode;
    }

    public void setEduBureauFkCode(Long eduBureauFkCode) {
        this.eduBureauFkCode = eduBureauFkCode;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getSchoolLatlng() {
        return this.schoolLatlng;
    }

    public void setSchoolLatlng(String schoolLatlng) {
        this.schoolLatlng = schoolLatlng;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Long getSchoolStages() {
        return this.schoolStages;
    }

    public void setSchoolStages(Long schoolStages) {
        this.schoolStages = schoolStages;
    }

    public String getSchoolProfile() {
        return this.schoolProfile;
    }

    public void setSchoolProfile(String schoolProfile) {
        this.schoolProfile = schoolProfile;
    }

    public Integer getSchoolNature() {
        return this.schoolNature;
    }

    public void setSchoolNature(Integer schoolNature) {
        this.schoolNature = schoolNature;
    }

    public Long getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public String getSchoolAddress() {
        return this.schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolImage() {
        return this.schoolImage;
    }

    public void setSchoolImage(String schoolImage) {
        this.schoolImage = schoolImage;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getSchoolMotto() {
        return this.schoolMotto;
    }

    public void setSchoolMotto(String schoolMotto) {
        this.schoolMotto = schoolMotto;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public java.util.Date getValidEndTime() {
        return this.validEndTime;
    }

    public void setValidEndTime(java.util.Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    public String getSchoolFax() {
        return this.schoolFax;
    }

    public void setSchoolFax(String schoolFax) {
        this.schoolFax = schoolFax;
    }

    public String getSchoolTel() {
        return this.schoolTel;
    }

    public void setSchoolTel(String schoolTel) {
        this.schoolTel = schoolTel;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public String getSchoolEnglishName() {
        return this.schoolEnglishName;
    }

    public void setSchoolEnglishName(String schoolEnglishName) {
        this.schoolEnglishName = schoolEnglishName;
    }

}
