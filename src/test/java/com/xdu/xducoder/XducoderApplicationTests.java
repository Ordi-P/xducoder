package com.xdu.xducoder;

import com.xdu.xducoder.Dao.*;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.controller.JupyterLoginController;
import com.xdu.xducoder.controller.notebookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;

@SpringBootTest
class XducoderApplicationTests {
    @Autowired
    notebookController notebookController;

    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put("UserID","userID");
        System.out.println(notebookController.selectNbIDByUserID(map));
    }
}
