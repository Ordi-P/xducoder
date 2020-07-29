package com.xdu.xducoder.controller;
import com.xdu.xducoder.Dao.CourseMapper;
import com.xdu.xducoder.Entity.Course;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourseController {
    private CourseMapper courseMapper;
    @Autowired
    public CourseController(CourseMapper courseMapper){
        this.courseMapper=courseMapper;
    }

    @RequestMapping(value = "/api/courses",method = RequestMethod.GET)
    public String list()
    {
        System.out.println("These are courses!");
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Course.class, "CourseName","CourseID","CourseDescription","coverUrl");
        return JSON.toJSONString(courseMapper.list(),filter1) ;
    }

}
