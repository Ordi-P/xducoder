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

    //react给studentid courseid stepid，返回给前端文件名（courseid，stepid）
    //jupyter调用后端,后端就要判断，并且调用接口，返回什么东西文件名和路径
    //模板文件，目录，
    @PostMapping("/yanzheng")
    public Map test2(@RequestBody Map<String, Object> para) {
        System.out.println(new Date() + ":接口/yanzheng调用一次");

        HashMap<String, Object> hs = new HashMap<>();

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
        Userinfo userinfo= userinfoMapper.selectByPrimaryKey(STDNum);
        if (list != null && list.size() == 0) {
//            类名.方法()，初始化列表
            Choosecourse choosecourse2 = new Choosecourse(STDNum, courseId, stepId, new Date(), null, null);
            choosecourseMapper.insert(choosecourse2);
//            Userinfo userinfo= userinfoMapper.selectByPrimaryKey(STDNum);
//            operator.copyNbToUser(courseId,stepId,userinfo.getUserID());
        }
        operator.copyNbToUser(courseId,stepId,userinfo.getUserID());
        hs.put("courseId", courseId);
        hs.put("stepId", stepId);

        return hs;
    }
}