//package com.cd.activiti.common;
//
//import com.cd.common.Assist;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.delegate.DelegateExecution;
//import org.activiti.engine.task.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Param:描述:activiti工具类
// * @return：返回结果描述:
// * @Throws：返回异常结果:
// * @Author: chenshangxian
// * @Date: 2018-4-25 18:36
// */
//@Service
//public class ProcessUtil {
//    @Autowired
//    private RuntimeService runtimeService;
//    @Autowired
//    private TaskService taskService;
//    @Autowired
//    private SysUserService userService;
//
//    @Autowired
//    //LeaveInfoDao leaveInfoDao;
//
//    //${processUtil.findOneManager(execution)}
//    //查询一级节点的人
//    //DelegateExecution execution: 执行实例的代理对象
//    public List<String> one(DelegateExecution execution) {
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("LEVEL", 1));
//        List<SysUser> sysUsers = userService.selectSysUser(assist);
//        ArrayList<String> list = new ArrayList<>();
//        sysUsers.forEach(e -> {
//            String userFkCode = e.getUserName().toString();
//            list.add(userFkCode);
//        });
//        return list;
//    }
//
//    //查询二级节点的人
//    public List<String> two(DelegateExecution execution) {
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("LEVEL", 2));
//        List<SysUser> sysUsers = userService.selectSysUser(assist);
//        ArrayList<String> list = new ArrayList<>();
//        sysUsers.forEach(e -> {
//            String userFkCode = e.getUserName().toString();
//            list.add(userFkCode);
//        });
//        return list;
//    }
//
//    //查询三级节点的人
//    public List<String> three(DelegateExecution execution) {
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("LEVEL", 3));
//        List<SysUser> sysUsers = userService.selectSysUser(assist);
//        ArrayList<String> list = new ArrayList<>();
//        sysUsers.forEach(e -> {
//            String userFkCode = e.getUserName().toString();
//            list.add(userFkCode);
//        });
//        return list;
//    }
//
//    //查询四级节点的人
//    public List<String> four(DelegateExecution execution) {
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("LEVEL", 4));
//        List<SysUser> sysUsers = userService.selectSysUser(assist);
//        ArrayList<String> list = new ArrayList<>();
//        sysUsers.forEach(e -> {
//            String userFkCode = e.getUserName().toString();
//            list.add(userFkCode);
//        });
//        return list;
//    }
//
//    //查询五级节点的人
//    public List<String> five(DelegateExecution execution) {
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("LEVEL", 5));
//        List<SysUser> sysUsers = userService.selectSysUser(assist);
//        ArrayList<String> list = new ArrayList<>();
//        sysUsers.forEach(e -> {
//            String userFkCode = e.getUserName().toString();
//            list.add(userFkCode);
//        });
//        return list;
//    }
//
//    //启动流程
//    //LeaveProcess:这个流程的id,很重要,这里暂时写死
//    //taskFkCode:请假单的fkcode
//    public void startProcess(String taskFkCode) {
//        runtimeService.startProcessInstanceByKey("LeaveProcess", taskFkCode);
//    }
//
//    //查询相关审批人
//    public List<Task> findTaskByUserId(String userFkCode) {
//        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(userFkCode).list();
//        return list;
//    }
//
//    //审批
//    //taskFkCode:审批哪个任务(业务单据外键(不是请假单外键))
//    //userFkCode:谁审批的
//    //audit:通过(pass),不通过(reject)
//    public void completeTaskByUser(TaskOverVo taskOverVo) {
//        //认领任务
//        taskService.claim(taskOverVo.getTaskFkCode(), taskOverVo.getUserFkCode());
//        HashMap<String, Object> map = new HashMap<>();
//        //audit必须和流程图里的值一样 如下:
//        //CDATA[${audit=='pass'}]]
//        map.put("audit", taskOverVo.getAduit());
//        if (taskOverVo.getDay() != null) {
//            map.put("day", taskOverVo.getDay());
//        }
//        //使流程往下走一步
//        taskService.complete(taskOverVo.getTaskFkCode(), map);
//    }
//
//    //${leaveService.changeStatus(execution,'img')}
//    //修改业务单据
//    public void changeStatus(DelegateExecution execution, String status) {
//        System.out.println("修改业务单据状态:->" + status);
//        //获取请假单的id
//        String processBusinessKey = execution.getProcessBusinessKey();
//        LeaveInfo leaveInfo = new LeaveInfo();
//        leaveInfo.setFkCode(Long.parseLong(processBusinessKey));
//        LeaveInfo leaveInfo1 = leaveInfoDao.selectLeaveInfoByObj(leaveInfo);
//        leaveInfo1.setStatus(status);
//
//        Assist assist = new Assist();
//        assist.setRequires(Assist.andEq("FK_CODE", processBusinessKey));
//        leaveInfoDao.updateNonEmptyLeaveInfo(leaveInfo1, assist);
//    }
//}
