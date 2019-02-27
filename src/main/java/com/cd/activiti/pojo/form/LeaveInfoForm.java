package com.cd.activiti.pojo.form;

import io.swagger.annotations.ApiModelProperty;

public class LeaveInfoForm {
    @ApiModelProperty(value = "请假人名字", dataType = "String", required = true)
    private String leaveName;//请假人名字
    @ApiModelProperty(value = "请假类型(1事假,2病假.)", dataType = "Integer", required = true)
    private Integer leaveType;//请假类型(1事假,2病假.)
    @ApiModelProperty(value = "请假内容", dataType = "String", required = true)
    private String leaveMsg;//请假内容
    @ApiModelProperty(value = "请假人外键", dataType = "String", required = true)
    private String leaveUserFkCode;//请假人外键

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveMsg() {
        return leaveMsg;
    }

    public void setLeaveMsg(String leaveMsg) {
        this.leaveMsg = leaveMsg;
    }

    public String getLeaveUserFkCode() {
        return leaveUserFkCode;
    }

    public void setLeaveUserFkCode(String leaveUserFkCode) {
        this.leaveUserFkCode = leaveUserFkCode;
    }
}
