package com.xdu.xducoder.controller;

import com.raincur.exception.UserNotFoundException;
import com.xdu.xducoder.Dao.NotebookMapper;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import com.xdu.xducoder.service.Operator;
import com.xdu.xducoder.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class notebookController {
    @Autowired
    public Operator notebook;

    @Autowired
    public UserManager userManager;

    @Autowired
    public NotebookMapper notebookMapper;

    @PostMapping("/copyNbToUserBySrc")
    public boolean copyNbToUserByNbId(@RequestBody HashMap map){
        notebook.copyNbToUser(map.get("nbID").toString(),map.get("tarUserID").toString());
        return true;
    }

    @PostMapping("/copyNbToUserByM")
    public boolean copyNbToUserByM(@RequestBody HashMap map){
        notebook.copyNbToUser(
                map.get("UserID").toString(),
                map.get("path").toString(),
                map.get("name").toString(),
                map.get("tarUserId").toString()
                );
        return true;
    }

    @PostMapping("/deleteNbBynbID")
    public boolean deleteNb(@RequestBody HashMap map){
        notebook.deleteNb(
                map.get("nbId").toString()
        );
        return true;
    }

    @PostMapping("/selectNbIDByUserID")
    public List<Notebook> selectNbIDByUserID(@RequestBody HashMap map){
        NotebookExample example = new NotebookExample();
        example.createCriteria().andUserIDEqualTo(map.get("UserID").toString());
        return notebookMapper.selectByExample(example);
    }

    @PostMapping("/createUserDirectory")
    public boolean createUserDirectory(@RequestBody HashMap map){
        return userManager.createUser(map.get("UserId").toString(),map.get("name").toString());
    }

    @PostMapping("/deleteUserDirectory")
    public boolean deleteUserDirectory(@RequestBody HashMap map){
        try {
            return userManager.deleteUser(map.get("UserID").toString());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
