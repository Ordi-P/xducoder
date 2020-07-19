package com.xdu.xducoder.controller;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.xdu.xducoder.Dao.ChoosecourseMapper;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Dao.StepsMapper;
import com.xdu.xducoder.Entity.Choosecourse;
import com.xdu.xducoder.Entity.Course;
import com.xdu.xducoder.service.Operator;
import com.xdu.xducoder.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class testController {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StepsMapper stepMapper;

    @Autowired
    public testController(CourseMapper courseMapper, StepsMapper stepMapper) {
        this.courseMapper = courseMapper;
        this.stepMapper = stepMapper;
    }

    @RequestMapping(value = "/api/courses", method = RequestMethod.GET)
    public String list() {
        System.out.println("These are courses!");
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Course.class, "CourseName", "CourseID", "CourseDescription", "coverUrl");
        return JSON.toJSONString(courseMapper.list(), filter1);
    }
    /*RequestMapping(value="/api/course?id=",method = RequestMethod.GET)
    @ResponseBody
    public Course findByPriamryKey(@RequestParam(value="id") String courseID)
    {
        return iCourseService.findByPrimaryKey(courseID);
    }*/

    //进入到课程
    @Autowired
    private ChoosecourseMapper choosecourseMapper;

    //    @RequestMapping(value="/challenge",method = RequestMethod.POST)
//    public int test(@RequestBody Map<String, Object> para)throws JsonProcessingException, IOException {
////返回的
//        HashMap<String, Object> hs = new HashMap<>();
////接收学号，id
//        String STDNum = (String)para.get("STDNum");
//        String courseId = (String)para.get("courseId");
////通过学号查找数据库
//        Choosecourse choosecourse = ChoosecourseMapper.findByPrimaryKey(STDNum,courseId);
//
//        Date date = new Date();
//        if(choosecourse == null){
//            Choosecourse choosecourse1 = new Choosecourse(STDNum,courseId, date,null,0);
//            iChooseCourseService.Save(choosecourse1);
//            return 0;
//        }
//        return choosecourse.gets;
//    }
    //react给studentid courseid stepid，返回给前端文件名（courseid，stepid）
//jupyter调用后端,后端就要判断，并且调用接口，返回什么东西文件名和路径
    //模板文件，目录，
    @RequestMapping(value = "/yanzheng", method = RequestMethod.POST)
    @ResponseBody
    public Object test2(@RequestBody Map<String, Object> para) throws JsonProcessingException, IOException {
        HashMap<String, Object> hs = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String STDNum = (String) para.get("STDNum");
        String courseId = (String) para.get("courseId");
        Integer stepId = (Integer) para.get("stepId");
        //查找啥
        Choosecourse choosecourse = choosecourseMapper.selectByPrimaryKey(STDNum, courseId, stepId);
        if (choosecourse == null) {
//            类名.方法()，初始化列表
            Choosecourse choosecourse2 = new Choosecourse(STDNum, courseId, 0, new Date(), null, null);
            choosecourseMapper.insert(choosecourse2);
            UserManager userManager = new UserManager();
            userManager.createUser(STDNum,"");
            //还少一个复制笔记本到用户目录
            Operator operator = new Operator();
     //operator.copyNbToUser();
        }
        hs.put("courseId", courseId);
        hs.put("stepId", stepId);

        return objectMapper.writeValueAsString(hs);

    }

}