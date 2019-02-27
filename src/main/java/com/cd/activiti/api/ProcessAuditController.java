//package com.cd.activiti.api;
//
//import com.es.app_common.po.Result;
//import com.es.app_common.pojo.bo.PushBo;
//import com.es.app_common.service.PushService;
//import com.es.app_common.util.Page;
//import com.es.app_common.util.ResultUtil;
//import com.es.coop_office.common.ProcessUtil;
//import com.es.coop_office.pojo.bo.SelectAllMyProcessBo;
//import com.es.coop_office.pojo.bo.SelectMyProcessHistoryBo;
//import com.es.coop_office.pojo.bo.TaskBo;
//import com.es.coop_office.pojo.dto.FlowPathDataDto;
//import com.es.coop_office.pojo.dto.NotificationDto;
//import com.es.coop_office.pojo.vo.*;
//import com.es.coop_office.service.CoAuditUserAppService;
//import com.es.coop_office.service.ProcessAuditService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.activiti.bpmn.model.BpmnModel;
//import org.activiti.engine.*;
//import org.activiti.engine.history.HistoricActivityInstance;
//import org.activiti.engine.history.HistoricProcessInstance;
//import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
//import org.activiti.engine.impl.context.Context;
//import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
//import org.activiti.engine.impl.pvm.PvmTransition;
//import org.activiti.engine.impl.pvm.process.ActivityImpl;
//import org.activiti.image.ProcessDiagramGenerator;
//import org.activiti.spring.ProcessEngineFactoryBean;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Api(tags = "协同办公-流程管理-流程审批", description = "流程审批V1.2")
//@RestController
//@RequestMapping("/coof")
//public class ProcessAuditController {
//    @Autowired
//    ProcessAuditService service;
//    @Autowired
//    ProcessUtil processUtil;
//    @Autowired
//    TaskService taskService;
//    @Autowired
//    HistoryService historyService;
//    @Autowired
//    RepositoryService repositoryService;
//    @Autowired
//    ManagementService managementService;
//    @Autowired
//    public RuntimeService runtimeService;
//    @Autowired
//    ProcessEngineConfiguration processEngineConfiguration;
//    @Autowired
//    ProcessEngineFactoryBean processEngine;
//    @Autowired
//    CoAuditUserAppService coAuditUserAppService;
//    @Autowired
//    PushService pushService;
//    @Resource
//    ResourceLoader resourceLoader;
//
//
//    @PostMapping("/Audit/SelectAllMyProcess")
//    @ApiOperation(value = "点击待我处理,分页查询所有流程单(created by chenshangxian)")
//    public Result selectAllMyProcess(@RequestBody SelectAllMyProcessPage page) {
//        if (page.getAuditUserFkCode() == null || page.getSchoolFkCode() == null) {
//            return ResultUtil.error("数据异常");
//        }
//        List<SelectAllMyProcessBo> list = service.selectAllMyProcess(page);
//        return ResultUtil.success(list);
//    }
//
//    @PostMapping("/Audit/StartProcess")
//    @ApiOperation(value = "启动流程(created by chenshangxian)")
//    public Result startProcess(@RequestBody StartProcessVo vo) {
//        //先查表,看里面有没有这个单的外键,如果有则不重复启动
//        List<String> list = service.selectHiFkCode();
//        for (String s : list) {
//            if(s!=null){
//                if (s.equals(vo.getTaskFkCode())) {
//                    return ResultUtil.success("该单已启动过");
//                }
//            }
//        }
//
//        processUtil.startProcess(vo.getProcessId(), vo.getTaskFkCode());
//
//        return ResultUtil.success("启动成功");
//    }
//
//    @PostMapping("/Audit/CompleteTaskByUser")
//    @ApiOperation(value = "点击提交,处理自己的待办任务(created by chenshangxian)")
//    public Result completeTaskByUser(@RequestBody TaskOverVo vo) {
//        //使流程节点往前走一步
//        service.completeTaskByUser(vo);
//
//        //下面三个方法用于区分审核人的审核意见
//        //先查出该单的最大值id值作为标识
//        String id = service.selectNum(vo.getProcessFkCode());
//        //用单据外键查询最新一条意见表里的对应的fkcode
//        String fkcode = service.sekectFkCode(vo.getProcessFkCode());
//        //通过意见表的fkcode把id值新增到最新一条的流程意见表里
//        service.updateNum(id,fkcode);
//
//        return ResultUtil.success("执行成功");
//    }
//
//    @PostMapping("/Audit/SelectAllMyProcessOver")
//    @ApiOperation(value = "点击我已处理,分页查询所有流程单(created by chenshangxian)")
//    public Result selectAllMyProcessOver(@RequestBody SelectAllMyProcessOverPage page) {
//        if (page.getAuditUserFkCode() == null || page.getSchoolFkCode() == null) {
//            return ResultUtil.error("数据异常");
//        }
//        Page list = service.selectAllMyProcessOver(page);
//        return ResultUtil.success(list);
//    }
//
//    /*@GetMapping("/Audit/SelectMyProcessHistory")
//    @ApiOperation(value = "点击审批历史,查询该单的审批历史流程(created by chenshangxian)")
//    public Result selectMyProcessHistory(@RequestParam String processFkCode) {
//        List<SelectMyProcessHistoryBo> list = service.selectMyProcessHistory(processFkCode);
//
//        return ResultUtil.success(list);
//    }*/
//
//   /* @ApiIgnore
//    @GetMapping("/Audit/insertNum")
//    @ApiOperation(value = "新增标识id到审批意见表(用于区分审核人的审核意见,调取完审核后调一次该接口 该接口已被整合,此接口作废)(created by chenshangxian)")
//    public Result insertNum(@RequestParam String processFkCode) {
//        //先查出该单的最大值id值作为标识
//        String id = service.selectNum(processFkCode);
//
//        //用单据外键查询最新一条意见表里的对应的fkcode
//        String fkcode = service.sekectFkCode(processFkCode);
//
//        //通过意见表的fkcode把id值新增到最新一条的流程意见表里
//        int i = service.updateNum(id,fkcode);
//
//        if (i > 0) {
//            return ResultUtil.success("新增成功");
//        } else {
//            return ResultUtil.error("新增失败");
//        }
//    }*/
//
//
//    @GetMapping("/Audit/SelectProcessFigure")
//    @ApiOperation(value = "根据该单的外键,获得实时流程跟踪图(created by chenshangxian)")
//    public void selectProcessFigure(HttpServletResponse response, @Param(value ="请假单外键" )@RequestParam String processFkCode) throws Exception {
//        //这个方法在最后一级节点审批后看不了流程图
//        //List<Task> task = taskService.createTaskQuery().list();
//
//        //查询流程图历史信息的PROC_INST_ID_和PROC_DEF_ID_;
//        List<TaskBo> taskBos = service.select(processFkCode);
//
//        TaskBo task1 = null;
//        //查询该单对应流程图的ProcessDefinitionId
//        String FkCode = service.selectProcessFigure(processFkCode);
//        //通过id对比,获得相对应的task
//        for (TaskBo t : taskBos) {
//            String a = t.getPROC_DEF_ID_();
//            if (FkCode.equals(a)) {
//                task1 = t;
//            }
//        }
//
//        //processInstanceId
//        String processInstanceId = task1.getPROC_INST_ID_();
//        //获取历史流程实例
//        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
//        //获取流程图
//        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
//        processEngineConfiguration = processEngine.getProcessEngineConfiguration();
//        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
//
//        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
//        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());
//
//        List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
//        //高亮环节id集合
//        List<String> highLightedActivitis = new ArrayList<String>();
//        //高亮线路id集合
//        List<String> highLightedFlows = getHighLightedFlows(definitionEntity, highLightedActivitList);
//
//        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
//            String activityId = tempActivity.getActivityId();
//            highLightedActivitis.add(activityId);
//        }
//
//        // 单独返回流程图，不高亮显示
//        //InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
//        // 输出资源内容到相应对象
//        //中文显示的是口口口，设置字体就好了
//        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis, highLightedFlows, "宋体", "宋体", "宋体", null, 1.0);
//        //InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,highLightedFlows,"UTF-8","UTF-8","UTF-8",null,1.0);
//        byte[] b1 = new byte[1024];
//        int len;
//        while ((len = imageStream.read(b1, 0, 1024)) != -1) {
//            response.getOutputStream().write(b1, 0, len);
//        }
//
//    }
//
//
//    /**
//     * @Param:描述:获取需要高亮的线(工具方法)
//     * @return：返回结果描述:
//     * @Throws：返回异常结果:
//     * @Author: chenshangxian
//     * @Date: 2018-5-16 17:09
//     */
//    private List<String> getHighLightedFlows(
//            ProcessDefinitionEntity processDefinitionEntity,
//            List<HistoricActivityInstance> historicActivityInstances) {
//        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
//        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
//            ActivityImpl activityImpl = processDefinitionEntity
//                    .findActivity(historicActivityInstances.get(i)
//                            .getActivityId());// 得到节点定义的详细信息
//            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
//            ActivityImpl sameActivityImpl1 = processDefinitionEntity
//                    .findActivity(historicActivityInstances.get(i + 1)
//                            .getActivityId());
//            // 将后面第一个节点放在时间相同节点的集合里
//            sameStartTimeNodes.add(sameActivityImpl1);
//            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
//                HistoricActivityInstance activityImpl1 = historicActivityInstances
//                        .get(j);// 后续第一个节点
//                HistoricActivityInstance activityImpl2 = historicActivityInstances
//                        .get(j + 1);// 后续第二个节点
//                if (activityImpl1.getStartTime().equals(
//                        activityImpl2.getStartTime())) {
//                    // 如果第一个节点和第二个节点开始时间相同保存
//                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
//                            .findActivity(activityImpl2.getActivityId());
//                    sameStartTimeNodes.add(sameActivityImpl2);
//                } else {
//                    // 有不相同跳出循环
//                    break;
//                }
//            }
//            List<PvmTransition> pvmTransitions = activityImpl
//                    .getOutgoingTransitions();// 取出节点的所有出去的线
//            for (PvmTransition pvmTransition : pvmTransitions) {
//                // 对所有的线进行遍历
//                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
//                        .getDestination();
//                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
//                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
//                    highFlows.add(pvmTransition.getId());
//                }
//            }
//        }
//        return highFlows;
//    }
//
//    @ApiOperation(value = "获取数据库的.bpmn文件中的userTask对象(created by chenshangxian)")
//    @GetMapping("/Audit/selectBPMN")
//    public Result selectBPMN(@Param(value ="画图的模型Id" )@RequestParam String id) throws Exception {
//
//
//        //通过创建的模型id查询到对应的.bpmn文件
//        String bpmn = service.selectBPMN(id);
//        //转成utf-8编码格式
//        bpmn = new String(bpmn.getBytes("ISO-8859-1"), "utf-8");
//        //System.out.println(bpmn);
//
//        String rgex = "<userTask(.*?)</userTask>";
//        //调用工具方法,截取userTask中间的字符,获得字符串数组
//        List<String> subUtil = getSubUtil(bpmn, rgex);
//
//        //把字符串数组拼接成字符串
//        StringBuilder result = new StringBuilder();
//        for (String string : subUtil) {
//            result.append(string);
//        }
//        String str1 = result.toString();
//
//        String rgex1 = "name=\"(.*?)\"";
//        //再调用工具方法,截取到userTask中的name对象数组
//        List<String> subUtil1 = getSubUtil(str1, rgex1);
//
//
//        return ResultUtil.success(subUtil1);
//    }
//
//    /**
//     * @Param:描述:正则工具方法
//     * @return：返回结果描述:
//     * @Throws：返回异常结果:
//     * @Author: chenshangxian
//     * @Date: 2018-5-24 14:55
//     */
//    public static List<String> getSubUtil(String soap, String rgex) {
//        List<String> list = new ArrayList<String>();
//        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
//        Matcher m = pattern.matcher(soap);
//        while (m.find()) {
//            int i = 1;
//            list.add(m.group(i));
//            i++;
//        }
//        return list;
//    }
//
//
//    @ApiOperation(value = "获取静态流程图(created by chenshangxian)")
//    @GetMapping("/Audit/Img")
//    public void img(HttpServletResponse response, @Param(value ="画图的模型Id" )@RequestParam String id) throws IOException {
//        //根具画图的模型id查询流程部署的id
//        String modelerId = service.selectImg(id);
//
//        BpmnModel bpmnModel = repositoryService.getBpmnModel(modelerId);
//        processEngineConfiguration = processEngine.getProcessEngineConfiguration();
//        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
//        //凑数用的
//        List<String> list = new ArrayList<String>();
//        //凑数用的
//        List<String> list1 = new ArrayList<>();
//        //图片为口口口,设置字符就好了
//        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", list, list1, "宋体", "宋体", "宋体", null, 1.0);
//        byte[] b1 = new byte[1024];
//        int len;
//        while ((len = imageStream.read(b1, 0, 1024)) != -1) {
//            response.getOutputStream().write(b1, 0, len);
//        }
//    }
//
//    @ApiOperation(value = "通过学校外键查询学校编码(created by chenshangxian)")
//    @GetMapping("/Audit/selectSchoolFkCode")
//    public Result selectSchoolFkCode(@ApiParam(value = "学校外键")@RequestParam String schoolFkCode){
//        String schoolCode = service.selectSchoolFkCode(schoolFkCode);
//        return ResultUtil.success(schoolCode);
//    }
//
//    @ApiOperation(value = "点击提交按钮,消息推送到审核人(created by chenshangxian)")
//    @PostMapping("/Audit/Notification")
//    public Result notification(@RequestBody NotificationDto dto) {
//        String taskId = null;
//        List<String> userFkCodes = null;
//        String userFkCode = null;
//        NotificationVo notificationVo = new NotificationVo();
//        FlowPathDataDto flowPathDataDto = new FlowPathDataDto();
//        if (dto.getNum() != null) switch (dto.getNum()) {
//            //1为申请时提交,2为审核时提交
//            case "1":
//                //申请时提交,直接用学校外键和类型查第一节点审核人获取用户外键集合
//                userFkCodes = service.selectUserFkCode(dto);
//                //使用流程单外键查询到taskId
//                taskId = service.selectTaskId(dto.getProcessFkCode());
//
//                //消息推送需要的对象信息,申请时间,流程单的外键,流程单类型,taskId
//                notificationVo.setTitle(dto.getTitle());
//                notificationVo.setCreateTime(dto.getCreateTime());
//                notificationVo.setType("LCSP");
//                notificationVo.setFlow_path_data(flowPathDataDto);
//                notificationVo.setDesc("");
//
//                flowPathDataDto.setProcessFkCode(dto.getProcessFkCode());
//                flowPathDataDto.setTaskId(taskId);
//                flowPathDataDto.setTypeName(dto.getType());
//
//                PushBo push = pushService.createPush(dto.getTitle(), "", "LCSP", flowPathDataDto);
//                //调用消息推送方法
//                pushService.send(userFkCodes, push, flowPathDataDto);
//
//                return ResultUtil.success(flowPathDataDto);
//            case "2":
//                //使用流程单外键查询到taskId
//                taskId = service.selectTaskId(dto.getProcessFkCode());
//                //用taskId查ACT表获取用户外键集合
//                userFkCodes = service.selectUserFkCodeTo(taskId);
//
//                //消息推送需要的对象信息,申请时间,流程单的外键,流程单类型,taskId
//                notificationVo.setTitle(dto.getTitle());
//                notificationVo.setCreateTime(dto.getCreateTime());
//                notificationVo.setType("LCSP");
//                notificationVo.setDesc("");
//                notificationVo.setFlow_path_data(flowPathDataDto);
//
//                flowPathDataDto.setProcessFkCode(dto.getProcessFkCode());
//                flowPathDataDto.setTaskId(taskId);
//                flowPathDataDto.setTypeName(dto.getType());
//
//                PushBo push1 = pushService.createPush(dto.getTitle(), "", "LCSP", flowPathDataDto);
//                //调用消息推送方法
//                if (userFkCodes.size()>0) {
//                    pushService.send(userFkCodes, push1, flowPathDataDto);
//                }else {
//                    return ResultUtil.error("该审批节点为最后一级,无下级审核人,不用消息推送");
//                }
//                return ResultUtil.success(flowPathDataDto);
//        }
//        else {
//            ResultUtil.error("数据错误");
//        }
//        return null;
//    }
//
//    @ApiOperation(value = "下载流程图模板(created by chenshangxian)")
//    @GetMapping("/evaTab/downloadTemplate")
//    public Result downloadTemplate(HttpServletRequest request, HttpServletResponse response) {
//
//        InputStream inputStream = null;
//        ServletOutputStream servletOutputStream = null;
//        String userAgent = request.getHeader("USER-AGENT");
//        try {
//            String fileName = setUrlEncode(userAgent, "流程图操作说明.xlsx");
//            String filePath = "excelfile/流程图操作说明.xlsx";
//
//            org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + filePath);
//            response.setContentType("application/vnd.ms-excel");
//            response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
//            response.setHeader("Access-Control-Allow-Origin", "*");
//
//            inputStream = resource.getInputStream();
//            servletOutputStream = response.getOutputStream();
//            IOUtils.copy(inputStream, servletOutputStream);
//            response.flushBuffer();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (servletOutputStream != null) {
//                    servletOutputStream.close();
//                    servletOutputStream = null;
//                }
//                if (inputStream != null) {
//                    inputStream.close();
//                    inputStream = null;
//                }
//                //jvm垃圾回收器
//                System.gc();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        return ResultUtil.success();
//    }
//
//    public static String setUrlEncode(String userAgent, String fileName) {
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
//}
//
