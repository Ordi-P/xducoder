package com.xdu.xducoder.controller;

// dtrsreser

import com.xdu.xducoder.Dao.ChoosecourseMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Choosecourse;
import com.xdu.xducoder.Entity.ChoosecourseExample;
import com.xdu.xducoder.Entity.Userinfo;
import com.xdu.xducoder.Entity.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials="true",origins = "*",maxAge = 3600)
public class JupyterLoginController {
    @Autowired
    ChoosecourseMapper choosecourseMapper;
    @Autowired
    UserinfoMapper userinfoMapper;

    @GetMapping("/isWorking")
    public boolean isWorking(){
        return true;
    }

    @PostMapping("/getSTDNum")
    public String getSTDNum(@RequestBody HashMap resMap){
        UserinfoExample example = new UserinfoExample();
        example.createCriteria().andUserIDEqualTo(resMap.get("userID").toString());
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(example);
        if (userinfoList.size() != 1){
            return "错误 查询结果数量:"+userinfoList.size();
        } else {
            return userinfoList.get(0).getSTDNum();
        }
    }

    @PostMapping("/saveScore")
    public boolean saveScore(@RequestBody Choosecourse choosecourse){
        Choosecourse selectOrigin = choosecourseMapper.selectByPrimaryKey(
                choosecourse.getSTDNum(),
                choosecourse.getCourseID(),
                0
        );

        if (selectOrigin == null){
            return false;
        } else {
            choosecourse.setRegDate(selectOrigin.getRegDate());
            choosecourse.setCompleteDate(new Date());

            if (choosecourseMapper.selectByPrimaryKey(
                    choosecourse.getSTDNum(),
                    choosecourse.getCourseID(),
                    choosecourse.getStepID()
            ) != null){
                choosecourseMapper.deleteByPrimaryKey(
                        choosecourse.getSTDNum(),
                        choosecourse.getCourseID(),
                        choosecourse.getStepID()
                );
            }
            choosecourseMapper.insert(choosecourse);
            return true;
        }
    }
}
