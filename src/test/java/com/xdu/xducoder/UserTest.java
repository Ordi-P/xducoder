package com.xdu.xducoder;

import com.xdu.xducoder.controller.notebookController;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class UserTest {

    @Test
    private void testCreateUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("UserId", "190305");
        map.put("name", "陈德创");
        System.out.println("测试中!!!");
        boolean flag = new notebookController().createUserDirectory(map);
        assert flag;
    }

    public static void main(String[] args) {
        new UserTest().testCreateUser();
    }

}
