package com.cd.basic.dao;

import com.cd.basic.pojo.bo.BasicGetDicListBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuildingDaoCustom {
    public List<BasicGetDicListBo> getDicList(@Param("schoolFkCode")Long schoolFkCode, @Param("dicCode")String dicCode);
}
