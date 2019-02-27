package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.BasicBuildingDao;
import com.cd.basic.pojo.domain.BasicBuilding;
import com.cd.common.Assist;
import com.cd.basic.service.BasicBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BasicBuildingServiceImpl implements BasicBuildingService{
    @Autowired
    private BasicBuildingDao basicBuildingDao;
    @Override
    public long getBasicBuildingRowCount(Assist assist){
        return basicBuildingDao.getBasicBuildingRowCount(assist);
    }
    @Override
    public List<BasicBuilding> selectBasicBuilding(Assist assist){
        return basicBuildingDao.selectBasicBuilding(assist);
    }
    @Override
    public BasicBuilding selectBasicBuildingByObj(BasicBuilding obj){
        return basicBuildingDao.selectBasicBuildingByObj(obj);
    }
    @Override
    public BasicBuilding selectBasicBuildingById(Long id){
        return basicBuildingDao.selectBasicBuildingById(id);
    }
    @Override
    public int insertBasicBuilding(BasicBuilding value){
        return basicBuildingDao.insertBasicBuilding(value);
    }
    @Override
    public int insertNonEmptyBasicBuilding(BasicBuilding value){
        return basicBuildingDao.insertNonEmptyBasicBuilding(value);
    }
    @Override
    public int insertBasicBuildingByBatch(List<BasicBuilding> value){
        return basicBuildingDao.insertBasicBuildingByBatch(value);
    }
    @Override
    public int deleteBasicBuildingById(Long id){
        return basicBuildingDao.deleteBasicBuildingById(id);
    }
    @Override
    public int deleteBasicBuilding(Assist assist){
        return basicBuildingDao.deleteBasicBuilding(assist);
    }
    @Override
    public int updateBasicBuildingById(BasicBuilding enti){
        return basicBuildingDao.updateBasicBuildingById(enti);
    }
    @Override
    public int updateBasicBuilding(BasicBuilding value, Assist assist){
        return basicBuildingDao.updateBasicBuilding(value,assist);
    }
    @Override
    public int updateNonEmptyBasicBuildingById(BasicBuilding enti){
        return basicBuildingDao.updateNonEmptyBasicBuildingById(enti);
    }
    @Override
    public int updateNonEmptyBasicBuilding(BasicBuilding value, Assist assist){
        return basicBuildingDao.updateNonEmptyBasicBuilding(value,assist);
    }

    public BasicBuildingDao getBasicBuildingDao() {
        return this.basicBuildingDao;
    }

    public void setBasicBuildingDao(BasicBuildingDao basicBuildingDao) {
        this.basicBuildingDao = basicBuildingDao;
    }

}