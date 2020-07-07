package com.xdu.xducoder.Dao.noteBook.Dao;

import com.xdu.xducoder.Entity.noteBook.NbVO;

import java.sql.SQLException;
import java.util.List;

public interface NbDao {

    // 插入一个笔记本
    boolean insert(NbVO notebook);

    // 删除一个笔记本
    boolean deleteByPrimaryKey(String nbId);

    // 更新一个笔记本
    boolean updateByPrimaryKeySelective(NbVO notebook);

    // 得到一个笔记本
    NbVO queryById(String nbId) throws SQLException;

    // 获得一个用户指定目录下的指定名字的笔记本
    NbVO queryByOwnerIdAndName(String ownerId, String name, String path) throws SQLException;

    // 获得一个用户所有的笔记本
    List<NbVO> queryAllNbByUserId(String userId) throws SQLException;
}
