package com.xdu.xducoder.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Userinfo;

import com.xdu.xducoder.Entity.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@RestController
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@CrossOrigin
public class LoginController {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestHeader Map<String, Object> he, @RequestBody Map<String, Object> para,HttpServletRequest request,HttpServletResponse response
    ) throws JsonProcessingException,IOException {
        request.setCharacterEncoding("utf-8");
        HashMap<String, Object> hs = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String accessToken = (String) para.get("accessToken");
        System.out.println("accessToken------------"+accessToken);
        //accessToken空的话，是第一次
        //不是第一次登录
        if (!accessToken.isEmpty()) {
//          如果这两边的token一样
            Cookie[] cookies = request.getCookies();
            String cookieToken = "";
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")) {
                    cookieToken = cookie.getValue();
                }
            }

            System.out.println("cookieToken-----"+cookieToken);
            if (accessToken.equals(cookieToken)) {
                System.out.println("Checked Successfully---------第二次");
                String[] s =  accessToken.split(":");
                String STDNum = s[s.length-1];
                Userinfo userinfo = userinfoMapper.selectByPrimaryKey(STDNum);
                hs.put("account",userinfo.getUserName());
                hs.put("token",accessToken);
                hs.put("msg", "success");
                hs.put("userID",userinfo.getUserID());
                hs.put("STDNum",userinfo.getSTDNum());
            }else{

                hs.put("token",accessToken);
                hs.put("msg", "Failed to check token");
            }

        }else{
            //accessToken是空的，第一次登录
//            String account = (String)para.get("account");
            String password = (String)para.get("password");
            String STDNum = (String)para.get("account");//ACCOUNT是学号

//            UserinfoExample userinfoExample = new UserinfoExample();
//            userinfoExample.createCriteria().andUserNameEqualTo(account);
//            List<Userinfo> list = null;
//            try{
//                list = userinfoMapper.selectByExample(userinfoExample);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            //考虑到可能会有重名的情况
//            boolean flag=false;
//            Userinfo userinfo=null;
//            for(int i=0;i<list.size();i++){
//                if(list.get(i).getPassword().equals(password)){
//                    flag=true;
//                    userinfo = list.get(i);
//                }
//            }
            Userinfo userinfo =userinfoMapper.selectByPrimaryKey(STDNum);
            if(userinfo != null && userinfo.getPassword().equals(password)){
                String token = UUID.randomUUID().toString().replace("-", "") +"STDNum:"+userinfo.getSTDNum();
                System.out.println("Login Successfully--------第一次");
                hs.put("account", userinfo.getUserName());
                hs.put("msg", "success");
                System.out.println(userinfo.getUserName());
                hs.put("token", token);
                hs.put("userID",userinfo.getUserID());
                hs.put("STDNum",userinfo.getSTDNum());

            }else{      //如果数据库没有找到这个用户
                hs.put("token","");
                hs.put("msg","failed");
                System.out.println("wrong");
            }
        }

        return objectMapper.writeValueAsString(hs);
    }

}
