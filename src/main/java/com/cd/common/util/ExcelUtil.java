//package com.cd.common.util;
//
//import cn.afterturn.easypoi.excel.ExcelExportUtil;
//import cn.afterturn.easypoi.excel.ExcelImportUtil;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import cn.afterturn.easypoi.excel.entity.ImportParams;
//import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
//import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
//import com.cd.common.vo.ExportExcelParam;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//
//public class ExcelUtil {
//
//    /**
//     * @Param:描述:easyPoi工具类
//     * @return：返回结果描述:
//     * @Throws：返回异常结果:
//     * @Description: ExcelUtil:导出Excel方法
//     * @Author: chenshangxian
//     * @Date: 2018-11-14 15:51
//     */
//    public static boolean ExportExcel(ExportExcelParam param) {
//        boolean flag = true;
//        String className = param.getClassName();
//        String fileName = param.getFileName();
//        HttpServletResponse response = param.getResponse();
//        HttpServletRequest request = param.getRequest();
//        Workbook workbook;
//        if (param.isMoreSheet()) {
//            //多sheet导出
//            workbook = ExcelExportUtil.exportExcel(param.getListMap(), ExcelType.XSSF);
//        } else {
//            //单sheet导出
//            //反射获取类
//            Class<?> aClass = null;
//            try {
//                aClass = Class.forName(className);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//                flag = false;
//                return flag;
//            }
//            workbook = ExcelExportUtil.exportExcel(param.getExportParams(), aClass, param.getList());
//        }
//
//        //多sheet页面设置样式
//        if (param.getListMap() != null){
//            for (Map<String, Object>  map :param.getListMap()) {
//                ExportParams exportParams = (ExportParams) map.get("title");
//                Sheet sheet = workbook.getSheet(exportParams.getSheetName());
//                XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
//                XSSFFont font = (XSSFFont) workbook.createFont();
//                //字体加粗
//                font.setBold(true);
//                style.setFont(font);
//                //左右居中
//                style.setAlignment(HorizontalAlignment.CENTER);
//                //垂直居中
//                style.setVerticalAlignment(VerticalAlignment.CENTER);
//                //设置第一行
//                Row row0 = sheet.getRow(0);
//
//                //给第一行加粗
//                for (int i = 0 ;i<50; i++){
//                    Cell cell = row0.getCell(i);
//                    if (cell == null){
//                    }else {
//                        cell.setCellStyle(style);
//                    }
//
//                }
//
//                //如果有标题则给第二行加粗
//                if (exportParams.getTitle() != null){
//                    Row row1 = sheet.getRow(1);
//                    for (int i = 0 ;i<50; i++){
//                        Cell cell = row1.getCell(i);
//                        if (cell == null){
//                        }else {
//                            cell.setCellStyle(style);
//                        }
//                    }
//                }
//            }
//        }else {
//            //单sheet页面设置样式
//
//            //生成Sheet和提示信息
//            Sheet sheet = workbook.getSheet(param.getExportParams().getSheetName());
//            XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
//            XSSFFont font = (XSSFFont) workbook.createFont();
//            //字体加粗
//            font.setBold(true);
//            style.setFont(font);
//            //左右居中
//            style.setAlignment(HorizontalAlignment.CENTER);
//            //垂直居中
//            style.setVerticalAlignment(VerticalAlignment.CENTER);
//            //设置第一行
//            Row row0 = sheet.getRow(0);
//
//            //给第一行加粗
//            for (int i = 0 ;i<50; i++){
//                Cell cell = row0.getCell(i);
//                if (cell == null){
//                    break;
//                }else {
//                    cell.setCellStyle(style);
//                }
//
//            }
//
//            //如果有标题则给第二行加粗
//            if (param.getExportParams().getTitle() != null){
//                Row row1 = sheet.getRow(1);
//                for (int i = 0 ;i<50; i++){
//                    Cell cell = row1.getCell(i);
//                    if (cell == null){
//                        break;
//                    }else {
//                        cell.setCellStyle(style);
//                    }
//                }
//            }
//
//
//        }
//
//
//
//
//
//        //导出区分浏览器
//        String userAgent = request.getHeader("USER-AGENT");
//        fileName = fileName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
//        //通过浏览器类型定义编码集
//        fileName = setUrlEncode(userAgent,fileName);
//        response.reset();
//        //vnd.ms-excel:Excel类型
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            workbook.write(outputStream);
//            outputStream.close();
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            flag = false;
//            return flag;
//        }
//        return flag;
//    }
//
//    /**
//     * 导入Excel
//     *
//     * @param file
//     * @param className 类的路径
//     * @return
//     */
//    public static ExcelImportResult ImportExcel(MultipartFile file, String className) {
//        Class<?> aClass = null;
//        try {
//            aClass = Class.forName(className);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        InputStream fileInputStream = null;
//        try {
//            fileInputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ImportParams params = new ImportParams();
//        params.setKeyIndex(1);
//        params.setReadRows(6000);
//        ExcelImportResult result = null;
//        try {
//            result = ExcelImportUtil.importExcelMore(fileInputStream, aClass, params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    public static String setUrlEncode(String userAgent,String fileName) {
//        try {
//            if (StringUtils.contains(userAgent, "MSIE")) {//IE浏览器
//                fileName = URLEncoder.encode(fileName, "UTF8");
//            } else if (StringUtils.contains(userAgent, "Mozilla")) {//google,火狐浏览器
//                fileName = new String(fileName.getBytes(), "ISO8859-1");
//            } else {
//                fileName = URLEncoder.encode(fileName, "UTF8");//其他浏览器
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return fileName;
//    }
//
//    /**
//     * 去除用户可能多输入空格
//     * @param str
//     * @return
//     * @throws ArrayIndexOutOfBoundsException
//     */
//    public static String splitStr(String str)  throws ArrayIndexOutOfBoundsException{
//        String[] split = str.split(":");
//        //去空格
//        String s = split[1].replaceAll("\\s*", "");
//        return s;
//    }
//
//}
