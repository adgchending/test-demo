//package com.cd.common.util;
//
//import com.cd.common.vo.FileVo;
//import com.cd.common.vo.ResultVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.apache.commons.io.FileUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//@Controller
//@Api(tags = "文件上传通过Nginx回显(:81端口)", description = "统一文件上传和下载API")
//public class FileUploadUtil {
//    private final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
//
//    @ApiOperation(value = "上传单个图片(created by chenshangxian)", httpMethod = "POST", notes = "上传图片")
//    @PostMapping(value = "/img/upload", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResultVo imgUpload(
//            @ApiParam(value = "待上传的图片") @RequestBody MultipartFile file)
//            throws IOException {
//        byte[] fileByte = file.getBytes();
//        if (fileByte.length != 0) {
//            String path = upload(fileByte, file.getOriginalFilename(), true);
//            Map<String, String> map = new HashMap<>();
//            map.put("imgUrl", path);
//            return ResultVo.getInstance(Boolean.TRUE, "上传成功").settingObjectData(map);
//        }
//        Map<String, String> map = new HashMap<>();
//        map.put("imgUrl", "");
//        return ResultVo.getInstance(Boolean.FALSE, "上传失败").settingObjectData(map);
//    }
//
//    @ApiOperation(value = "上传多个图片(created by chenshangxian)", httpMethod = "POST", notes = "上传图片")
//    @PostMapping(value = "/imgs/upload", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResultVo imgsUpload(@ApiParam(value = "待上传的图片") @RequestBody MultipartFile[] imgs) throws IOException {
//        List<FileVo> paths = new ArrayList<>();
//        for (MultipartFile img : imgs) {
//            FileVo file = new FileVo();
//            byte[] fileByte = img.getBytes();
//            String path = upload(fileByte, img.getOriginalFilename(), true);
//
//            file.setFileUrl(path);
//            file.setFileName(img.getOriginalFilename());
//            paths.add(file);
//            System.out.println("imgsUrl" + path);
//        }
//        Map<String, List<FileVo>> map = new HashMap<>();
//        map.put("imgsUrl", paths);
//
//        return ResultVo.getInstance(Boolean.TRUE, "上传成功").settingObjectData(map);
//    }
//
//    @ApiOperation(value = "上传单个文件(created by mars_LV)", httpMethod = "POST", notes = "上传文件")
//    @PostMapping(value = "/file/upload")
//    @ResponseBody
//    public ResultVo fileUpload(@ApiParam(value = "待上传的文件") @RequestBody MultipartFile file) throws IOException {
//        byte[] fileByte = file.getBytes();
//        //保存文件，返回存的文件url地址
//        String path = upload(fileByte, file.getOriginalFilename(), false);
//
//        //获取文件的后缀
//        String fileName = file.getOriginalFilename();
//        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//        //获取文件大小
//        long fileSize = file.getSize();
//
//        Map<String, String> map = new HashMap<>();
//        map.put("fileName", file.getOriginalFilename());
//        map.put("fileUrl", path);
//        map.put("fileType", fileSuffix);
//        map.put("fileSize", Long.toString(fileSize));
//
//        return ResultVo.getInstance(Boolean.TRUE, "上传成功").settingObjectData(map);
//    }
//
//    @ApiOperation(value = "上传多个文件(created by mars_LV)", httpMethod = "POST", notes = "上传文件")
//    @PostMapping(value = "/files/upload")
//    @ResponseBody
//    public ResultVo filesUpload(@ApiParam(value = "待上传的文件") @RequestBody List<MultipartFile> files) throws IOException {
//
//        List<FileVo> fileVos = new ArrayList<>();
//        for (MultipartFile file : files) {
//            //每个文件上传
//            byte[] fileByte = file.getBytes();
//            String path = upload(fileByte, file.getOriginalFilename(), false);
//
//            FileVo filev = new FileVo();
//            filev.setFileName(file.getOriginalFilename());
//            filev.setFileUrl(path);
//
//            //打印日志
//            logger.info("上传文件日志文件：" + filev.toString());
//            fileVos.add(filev);
//        }
//
//        Map<String, List<FileVo>> map = new HashMap<>(1);
//        map.put("filesUrl", fileVos);
//        //打下多文件上传的日志
//        logger.info("批量完成日志：" + map.toString());
//
//        return ResultVo.getInstance(Boolean.TRUE, "上传成功").settingObjectData(map);
//    }
//
//
//    /**
//     * @Param:功能说明:在服务器里建立对应的文件夹,通过nginx映射回显图片
//     * @parameter:参数说明:文件的byte字节,文件名,图片为true文件为false
//     * @return：返回结果描述:
//     * @Throws：返回异常结果:
//     * @Author: chenshangxian
//     * @Date: 2018-12-5 11:32
//     */
//    public String upload(byte[] fileByte, String fileName, Boolean isImg) {
//
//        // 文件存储目标文件夹
//        String targetFoldre = "/Users/chenshangxian/Downloads/tmp/";
//
//        // System.out.println("path="+targetFoldre);
//        // 我们用当前时间的来分割三个文件夹yyyy/MM/dd格式的
//        Calendar now = Calendar.getInstance();
//        String datePath = now.get(Calendar.YEAR) + "/"
//                + (now.get(Calendar.MONTH) + 1) + "/"
//                + now.get(Calendar.DAY_OF_MONTH);
//        // 组装成一个全路径
//        String fillPath = targetFoldre + datePath;
//
//        // 如果这个路径不存在就新建立一个
//        File dir = new File(fillPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        /*
//        mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹， 如下：
//		new File("/tmp/one/two/three").mkdirs();
//		执行后， 会建立tmp/one/two/three四级目录
//		new File("/tmp/one/two/three").mkdir();
//		则不会建立任何目录， 因为找不到/tmp/one/two目录， 结果返回false
//		*/
//        // 截取文件后缀
//        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//        // 组装一个完整的文件路径
//        String path = UUID.randomUUID().toString() + "." + ext;
//        File des = new File(dir, path);
//
//        try {
//            FileUtils.copyInputStreamToFile(new ByteArrayInputStream(fileByte),
//                    des);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        if (isImg) {
//            return "/img/" + datePath + "/" + path;
//        } else {
//            return "/file/" + datePath + "/" + path;
//        }
//    }
//}
