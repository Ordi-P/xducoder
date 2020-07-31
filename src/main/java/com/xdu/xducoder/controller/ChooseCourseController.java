package com.xdu.xducoder.controller;

import com.xdu.xducoder.Dao.ChoosecourseMapper;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Entity.Challenge;
import com.xdu.xducoder.Entity.Choosecourse;
import com.xdu.xducoder.Entity.Course;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
public class ChooseCourseController {
    @Autowired
    private ChoosecourseMapper choosecourseMapper;
    @Autowired
    private CourseMapper courseMapper;

    @PostMapping(value="/api/challenge")
    public String Challenge(@RequestBody Challenge challenge)
    {
        System.out.println(new Date() + ":接口/api/challenge调用一次");

        String STUNum=challenge.getSTUNum();
        String CourseID=challenge.getCourseID();
//        JSONObject choosecourseInfo=new JSONObject();
//        choosecourseInfo.put("msg","success");
//        String response=JSONObject.toJSONString(choosecourseInfo);
        Integer stepID=1;

        Choosecourse select = choosecourseMapper.selectByPrimaryKey(STUNum, CourseID, stepID);
//        if(select!=null)
//        {
//            return response;
//        }
//        else{
//            java.sql.Date regdate=new java.sql.Date(System.currentTimeMillis());
//            Course course=courseMapper.selectByPrimaryKey(CourseID);
//            int CourseNum=course.getCourseNum();
//            CourseNum++;
//            byte[] score=new byte[1];
//            score[0]=0;
//            course.setCourseNum(CourseNum);
//            courseMapper.updateByPrimaryKey(course);
//            Choosecourse newstart=new Choosecourse();
//            newstart.setCourseID(CourseID);
//            newstart.setCourseScore(score);
//            newstart.setSTDNum(STUNum);
//            newstart.setRegDate(regdate);
//            newstart.setCompleteDate(regdate);
//            newstart.setStepID(1);
//            choosecourseMapper.insert(newstart);
//            return response;
//        }

        if (select != null){
            return "记录已存在";
        } else {
            // 查找与更新选课人数
            Course course = courseMapper.selectByPrimaryKey(CourseID);
            int CourseNum=course.getCourseNum();
            CourseNum++;
            byte[] score=new byte[1];
            score[0]=0;
            course.setCourseNum(CourseNum);
            courseMapper.updateByPrimaryKey(course);

            // 插入新课程选择记录
            Choosecourse newstart=new Choosecourse();
            newstart.setCourseID(CourseID);
            newstart.setCourseScore(score);
            newstart.setSTDNum(STUNum);
            newstart.setRegDate(new Date());
            newstart.setCompleteDate(new Date());
            newstart.setStepID(0);
            choosecourseMapper.insert(newstart);

            return "插入新记录成功:"+newstart.toString();
        }
    }
}
