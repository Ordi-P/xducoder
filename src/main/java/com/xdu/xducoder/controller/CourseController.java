package com.xdu.xducoder.controller;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Dao.StepsMapper;
import com.xdu.xducoder.Entity.Course;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.xdu.xducoder.Entity.Steps;
import com.xdu.xducoder.Entity.StepsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private CourseMapper courseMapper;
    private StepsMapper stepsMapper;
    @Autowired
    public CourseController(CourseMapper courseMapper,StepsMapper stepsMapper)
    {
        this.courseMapper=courseMapper;
        this.stepsMapper=stepsMapper;
    }
//    @RequestMapping(value = "/api/courses",method = RequestMethod.GET)
    @GetMapping(value = "/api/courses")
    public List list()
    {
        System.out.println(new Date() + ":接口/api/courses调用一次");

//        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Course.class, "CourseName","CourseID","CourseDescription","coverUrl");
//        return JSON.toJSONString(courseMapper.list(),filter1) ;
        return courseMapper.list();
    }

//    @RequestMapping(value="/api/course",method = RequestMethod.GET)
    @GetMapping(value="/api/course")
    public List findByPrimaryKey(@RequestParam(value="id",required=true) String courseID)
    {
        System.out.println(new Date() + ":接口/api/course调用一次");

        StepsExample stepsExample=new StepsExample();
        stepsExample.createCriteria().andCourseIDEqualTo(courseID);
        List<Steps> steps= stepsMapper.selectByExample(stepsExample);
//        System.out.println("我在这里");
//        SimplePropertyPreFilter filter2 = new SimplePropertyPreFilter("CourseID","CourseName","CourseNum","CompleteNum","CourseDIF","CourseDescription","chapters","stepID");
//        filter2.getExcludes().add("CoverURL");
//        JSONObject courseInfo=(JSONObject)JSONObject.toJSON(courseMapper.selectByPrimaryKey(courseID));
//        String response=JSONObject.toJSONString(courseInfo,filter2);
//        JSONObject raw= JSON.parseObject(response);
//        raw.put("stepID",0);
//        raw.put("chapters",steps);
//        response=JSONObject.toJSONString(raw);
//        return response;
        return steps;
    }

//    @RequestMapping(value ="/api/search",method = RequestMethod.GET)
    @GetMapping(value ="/api/search")
    public Course searchCourse(@RequestParam(value = "q",required = true)String KeyWord)
    {
        System.out.println(new Date() + ":接口/api/search调用一次");

        return courseMapper.selectByPrimaryKey(KeyWord);
    }
}
