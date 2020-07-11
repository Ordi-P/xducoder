package com.xdu.xducoder.Dao;

import com.xdu.xducoder.Entity.Choosecourse;
import com.xdu.xducoder.Entity.ChoosecourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChoosecourseMapper {
    int deleteByExample(ChoosecourseExample example);

    int deleteByPrimaryKey(@Param("STDNum") String STDNum, @Param("courseID") String courseID, @Param("stepID") Integer stepID);

    int insert(Choosecourse record);

    int insertSelective(Choosecourse record);

    List<Choosecourse> selectByExampleWithBLOBs(ChoosecourseExample example);

    List<Choosecourse> selectByExample(ChoosecourseExample example);

    Choosecourse selectByPrimaryKey(@Param("STDNum") String STDNum, @Param("courseID") String courseID, @Param("stepID") Integer stepID);

    int updateByExampleSelective(@Param("record") Choosecourse record, @Param("example") ChoosecourseExample example);

    int updateByExampleWithBLOBs(@Param("record") Choosecourse record, @Param("example") ChoosecourseExample example);

    int updateByExample(@Param("record") Choosecourse record, @Param("example") ChoosecourseExample example);

    int updateByPrimaryKeySelective(Choosecourse record);

    int updateByPrimaryKeyWithBLOBs(Choosecourse record);

    int updateByPrimaryKey(Choosecourse record);
}