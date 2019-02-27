package com.cd.common.vo;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Param:描述:
 * @return：返回结果描述:
 * @Throws：返回异常结果:
 * @Description: 导出Excel方法参数
 * @Author: chenshangxian
 * @Date: 2018-11-14 15:37
 */
public class ExportExcelParam {
    /**
     * isMoreSheet:是否为多sheet导出(默认为false为单sheet)
     */
    private boolean isMoreSheet = false;
    /**
     * list:导出数据
     */
    private List list;
    /**
     * className:类的路径
     */
    private String className;
    /**
     * fileName:导出Excel的名称
     */
    private String fileName;
    /**
     * exportParams:此属性只在单sheet的时候传入(即isMoreSheet为false时)
     */
    private ExportParams exportParams;
    /**
     * listMap:!!!!此属性只有在多sheet的时候传入(即isMoreSheet为true时)
     * 当isMoreSheet为true时,只需要传入此参数即可
     * 其中每个Map中 :key title 对应表格Title key entity 对应表格对应实体 key data Collection 数据
     * map.put("title",ExportParams);ExportParams中需要setType为XSSF否则和导出方法有冲突
     * map.put("entity",Entity.class);
     * map.put("data",Collection);
     */
    private List<Map<String, Object>> listMap;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ExportParams getExportParams() {
        return exportParams;
    }

    public void setExportParams(ExportParams exportParams) {
        this.exportParams = exportParams;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isMoreSheet() {
        return isMoreSheet;
    }

    public void setMoreSheet(boolean moreSheet) {
        isMoreSheet = moreSheet;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Map<String, Object>> getListMap() {
        return listMap;
    }

    public void setListMap(List<Map<String, Object>> listMap) {
        this.listMap = listMap;
    }
}
