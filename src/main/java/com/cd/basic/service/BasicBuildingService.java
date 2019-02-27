package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.BasicBuilding;
import com.cd.common.Assist;
public interface BasicBuildingService{
	/**
	 * 获得BasicBuilding数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getBasicBuildingRowCount(Assist assist);
	/**
	 * 获得BasicBuilding数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<BasicBuilding> selectBasicBuilding(Assist assist);
	/**
	 * 获得一个BasicBuilding对象,以参数BasicBuilding对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    BasicBuilding selectBasicBuildingByObj(BasicBuilding obj);
	/**
	 * 通过BasicBuilding的id获得BasicBuilding对象
	 * @param id
	 * @return
	 */
    BasicBuilding selectBasicBuildingById(Long id);
	/**
	 * 插入BasicBuilding到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBasicBuilding(BasicBuilding value);
	/**
	 * 插入BasicBuilding中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyBasicBuilding(BasicBuilding value);
	/**
	 * 批量插入BasicBuilding到数据库
	 * @param value
	 * @return
	 */
    int insertBasicBuildingByBatch(List<BasicBuilding> value);
	/**
	 * 通过BasicBuilding的id删除BasicBuilding
	 * @param id
	 * @return
	 */
    int deleteBasicBuildingById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除BasicBuilding
	 * @param assist
	 * @return
	 */
    int deleteBasicBuilding(Assist assist);
	/**
	 * 通过BasicBuilding的id更新BasicBuilding中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateBasicBuildingById(BasicBuilding enti);
 	/**
	 * 通过辅助工具Assist的条件更新BasicBuilding中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateBasicBuilding(BasicBuilding value,  Assist assist);
	/**
	 * 通过BasicBuilding的id更新BasicBuilding中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyBasicBuildingById(BasicBuilding enti);
 	/**
	 * 通过辅助工具Assist的条件更新BasicBuilding中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyBasicBuilding(BasicBuilding value, Assist assist);
}