package com.xdu.xducoder.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.xdu.xducoder.Dao.ChoosecourseMapper;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Dao.StepsMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.*;
import com.xdu.xducoder.service.Operator;
import com.xdu.xducoder.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.*;
/*
 *两个接口，
 *第一个是选择课程之后，前端调用后端
 *第二个是选择关卡之后，调用后端
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ToJupyterController {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StepsMapper stepMapper;
    @Autowired
    ChoosecourseMapper choosecourseMapper;
    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    Operator operator;

//    @GetMapping("/api/courses")
//    public String list() {
//        System.out.println("These are courses!");
//        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Course.class, "CourseName", "CourseID", "CourseDescription", "coverUrl");
//        return JSON.toJSONString(courseMapper.list(), filter1);
//    }

    @RequestMapping(value="/api/challenge",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String Challenge(@RequestBody Challenge challenge)
    {
        //获得学号和课程号
        String STUNum=challenge.getSTUNum();
        String CourseID=challenge.getCourseID();
        JSONObject choosecourseInfo=new JSONObject();
        choosecourseInfo.put("msg","success");
        String response=JSONObject.toJSONString(choosecourseInfo);
        //复杂查询
        ChoosecourseExample choosecourseExample = new ChoosecourseExample();
        choosecourseExample.createCriteria().andSTDNumEqualTo(STUNum).andCourseIDEqualTo(CourseID);
        List list = choosecourseMapper.selectByExample(choosecourseExample);

        if(list.size()!=0)
        {
            return response;
        }
        else{
            java.sql.Date regdate=new java.sql.Date(System.currentTimeMillis());
            Course course=courseMapper.selectByPrimaryKey(CourseID);        //也改了
            int CourseNum=course.getCourseNum();
            CourseNum++;
            byte[] score={0};
            course.setCourseNum(CourseNum);
            courseMapper.updateByPrimaryKey(course);//这里改了使用潘思言的众多函数中的一个
            Choosecourse newstart=new Choosecourse();
            newstart.setCourseID(CourseID);
            newstart.setCourseScore(score);
            newstart.setSTDNum(STUNum);
            newstart.setRegDate(regdate);
            newstart.setCompleteDate(regdate);
            newstart.setStepID(0);
            choosecourseMapper.insert(newstart);//插入一个
            return response;
        }
    }

    //react给studentid courseid stepid，返回给前端文件名（courseid，stepid）
    //jupyter调用后端,后端就要判断，并且调用接口，返回什么东西文件名和路径
    //模板文件，目录，
    @PostMapping("/yanzheng")
    public Object test2(@RequestBody Map<String, Object> para) throws JsonProcessingException, IOException {
        HashMap<String, Object> hs = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String STDNum = para.get("STDNum").toString();
        String courseId = para.get("courseId").toString();
        Integer stepId = Integer.parseInt(para.get("stepId").toString());
        //复杂查询对应的
        ChoosecourseExample choosecourseExample = new ChoosecourseExample();
        choosecourseExample.createCriteria().andSTDNumEqualTo(STDNum).andCourseIDEqualTo(courseId).andStepIDEqualTo(stepId);
        List list = null;
        try{
            list = choosecourseMapper.selectByExample(choosecourseExample);
        } catch (Exception e){
            e.printStackTrace();
        }

        if (list != null && list.size() == 0) {
//            类名.方法()，初始化列表
            Choosecourse choosecourse2 = new Choosecourse(STDNum, courseId, stepId, new Date(), null, null);
            choosecourseMapper.insert(choosecourse2);
            Userinfo userinfo= userinfoMapper.selectByPrimaryKey(STDNum);
            operator.copyNbToUser(courseId,stepId,userinfo.getUserID());
        }
        hs.put("courseId", courseId);
        hs.put("stepId", stepId);

        return objectMapper.writeValueAsString(hs);
    }
}