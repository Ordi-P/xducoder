package com.xdu.xducoder.Dao;

import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NotebookMapper {
    int deleteByExample(NotebookExample example);

    int deleteByPrimaryKey(String nbID);

    int insert(Notebook record);

    int insertSelective(Notebook record);

    List<Notebook> selectByExample(NotebookExample example);

    Notebook selectByPrimaryKey(String nbID);

    int updateByExampleSelective(@Param("record") Notebook record, @Param("example") NotebookExample example);

    int updateByExample(@Param("record") Notebook record, @Param("example") NotebookExample example);

    int updateByPrimaryKeySelective(Notebook record);

    int updateByPrimaryKey(Notebook record);
}