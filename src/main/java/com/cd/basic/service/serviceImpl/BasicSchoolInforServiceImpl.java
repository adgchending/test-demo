package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.BasicSchoolInforDao;
import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.common.Assist;
import com.cd.basic.service.BasicSchoolInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BasicSchoolInforServiceImpl implements BasicSchoolInforService{
    @Autowired
    private BasicSchoolInforDao basicSchoolInforDao;
    @Override
    public long getBasicSchoolInforRowCount(Assist assist){
        return basicSchoolInforDao.getBasicSchoolInforRowCount(assist);
    }
    @Override
    public List<BasicSchoolInfor> selectBasicSchoolInfor(Assist assist){
        return basicSchoolInforDao.selectBasicSchoolInfor(assist);
    }
    @Override
    public BasicSchoolInfor selectBasicSchoolInforByObj(BasicSchoolInfor obj){
        return basicSchoolInforDao.selectBasicSchoolInforByObj(obj);
    }
    @Override
    public BasicSchoolInfor selectBasicSchoolInforById(Long id){
        return basicSchoolInforDao.selectBasicSchoolInforById(id);
    }
    @Override
    public int insertBasicSchoolInfor(BasicSchoolInfor value){
        return basicSchoolInforDao.insertBasicSchoolInfor(value);
    }
    @Override
    public int insertNonEmptyBasicSchoolInfor(BasicSchoolInfor value){
        return basicSchoolInforDao.insertNonEmptyBasicSchoolInfor(value);
    }
    @Override
    public int insertBasicSchoolInforByBatch(List<BasicSchoolInfor> value){
        return basicSchoolInforDao.insertBasicSchoolInforByBatch(value);
    }
    @Override
    public int deleteBasicSchoolInforById(Long id){
        return basicSchoolInforDao.deleteBasicSchoolInforById(id);
    }
    @Override
    public int deleteBasicSchoolInfor(Assist assist){
        return basicSchoolInforDao.deleteBasicSchoolInfor(assist);
    }
    @Override
    public int updateBasicSchoolInforById(BasicSchoolInfor enti){
        return basicSchoolInforDao.updateBasicSchoolInforById(enti);
    }
    @Override
    public int updateBasicSchoolInfor(BasicSchoolInfor value, Assist assist){
        return basicSchoolInforDao.updateBasicSchoolInfor(value,assist);
    }
    @Override
    public int updateNonEmptyBasicSchoolInforById(BasicSchoolInfor enti){
        return basicSchoolInforDao.updateNonEmptyBasicSchoolInforById(enti);
    }
    @Override
    public int updateNonEmptyBasicSchoolInfor(BasicSchoolInfor value, Assist assist){
        return basicSchoolInforDao.updateNonEmptyBasicSchoolInfor(value,assist);
    }

    public BasicSchoolInforDao getBasicSchoolInforDao() {
        return this.basicSchoolInforDao;
    }

    public void setBasicSchoolInforDao(BasicSchoolInforDao basicSchoolInforDao) {
        this.basicSchoolInforDao = basicSchoolInforDao;
    }

}