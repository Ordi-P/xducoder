package com.xdu.xducoder.controller;

import com.xdu.xducoder.Dao.ChoosecourseMapper;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Entity.Challenge;
import com.xdu.xducoder.Entity.Choosecourse;
import com.xdu.xducoder.Entity.Course;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ChooseCourseController {
    private ChoosecourseMapper choosecourseMapper;
    private CourseMapper courseMapper;
    @Autowired
    public ChooseCourseController(ChoosecourseMapper choosecourseMapper, CourseMapper courseMapper)
    {
        this.choosecourseMapper=choosecourseMapper;
        this.courseMapper=courseMapper;
    }
//    @RequestMapping(value="/api/challenge",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    @PostMapping(value="/api/challenge")
    public String Challenge(@RequestBody Challenge challenge)
    {
        String STUNum=challenge.getSTUNum();
        String CourseID=challenge.getCourseID();
        JSONObject choosecourseInfo=new JSONObject();
        choosecourseInfo.put("msg","success");
        String response=JSONObject.toJSONString(choosecourseInfo);
        Integer stepID=1;

        Choosecourse select = choosecourseMapper.selectByPrimaryKey(STUNum, CourseID, stepID);
        if(select!=null)
        {
            return response;
        }
        else{
            java.sql.Date regdate=new java.sql.Date(System.currentTimeMillis());
            Course course=courseMapper.selectByPrimaryKey(CourseID);
            int CourseNum=course.getCourseNum();
            CourseNum++;
            byte[] score=new byte[1];
            score[0]=0;
            course.setCourseNum(CourseNum);
            courseMapper.updateByPrimaryKey(course);
            Choosecourse newstart=new Choosecourse();
            newstart.setCourseID(CourseID);
            newstart.setCourseScore(score);
            newstart.setSTDNum(STUNum);
            newstart.setRegDate(regdate);
            newstart.setCompleteDate(regdate);
            newstart.setStepID(1);
            choosecourseMapper.insert(newstart);
            return response;
        }
    }
}
