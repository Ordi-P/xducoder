package com.xdu.xducoder;

import com.xdu.xducoder.Dao.*;
import com.xdu.xducoder.Entity.Userinfo;
import com.xdu.xducoder.controller.JupyterLoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class XducoderApplicationTests {
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    ChoosecourseMapper choosecourseMapper;
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StepsMapper stepsMapper;

    @Autowired
    JupyterLoginController jupyterLoginController;

    Userinfo user = new Userinfo();

    @Test
    void test3(){
        HashMap<String,String> map = new HashMap();
        map.put("userID","1234567");
        String username = jupyterLoginController.getSTDNum(map);
        System.out.println(username);
    }
}
