package com.cd.basic.service;

import com.cd.basic.pojo.bo.BasicGetDicListBo;

import java.util.List;

public interface BuildingServiceCustom {
    List<BasicGetDicListBo> getDicList(long l, String buildingtype);
}
