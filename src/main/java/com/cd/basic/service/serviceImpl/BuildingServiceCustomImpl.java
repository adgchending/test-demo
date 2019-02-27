package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.BuildingDaoCustom;
import com.cd.basic.pojo.bo.BasicGetDicListBo;
import com.cd.basic.service.BuildingServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceCustomImpl implements BuildingServiceCustom{
    @Autowired
    BuildingDaoCustom buildingDaoCustom;


    @Override
    public List<BasicGetDicListBo> getDicList(long l, String buildingtype) {
        return buildingDaoCustom.getDicList(l,buildingtype);
    }
}
