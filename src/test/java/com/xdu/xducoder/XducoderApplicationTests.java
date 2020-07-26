package com.xdu.xducoder;

import com.xdu.xducoder.Dao.*;
import com.xdu.xducoder.Entity.Challenge;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.controller.JupyterLoginController;
import com.xdu.xducoder.controller.ToJupyterController;
import com.xdu.xducoder.controller.notebookController;
import com.xdu.xducoder.service.Operator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
class XducoderApplicationTests {
    @Autowired
    ToJupyterController toJupyterController;
    @Autowired
    Operator operator;

    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put("STDNum","19030500113");
        map.put("courseId","1");
        map.put("stepId","3");

//        Challenge challenge = new Challenge();
//        challenge.setSTUNum("19030500113");
//        challenge.setCourseID("1");

        try {
            System.out.println(toJupyterController.test2(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        System.out.println(operator.copyNbToUser("1", 0, "19030500113"));
    }
}
