package com.cd.basic.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class UserVo implements Serializable{
    @ApiModelProperty(value = "名字", dataType = "String", required = true)
    private String name;
    @ApiModelProperty(value = "id",dataType = "String",required = true)
    private String id;//当前页
    @ApiModelProperty(value = "年龄", dataType = "String", required = true)
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
