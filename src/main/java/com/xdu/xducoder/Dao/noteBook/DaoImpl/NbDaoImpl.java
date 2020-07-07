package com.xdu.xducoder.Dao.noteBook.DaoImpl;


import com.xdu.xducoder.Dao.noteBook.Dao.DataBaseConnection;
import com.xdu.xducoder.Dao.noteBook.Dao.NbDao;
import com.xdu.xducoder.Entity.noteBook.NbVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NbDaoImpl extends BaseDaoImpl implements NbDao {

    @Override
    public boolean insert(NbVO nb) {
        if (nb == null) return false;
        if (nb.getNbId() == null || nb.getName() == null || nb.getPath() == null) return false;
        String sql = String.format(
                "INSERT INTO noteBook(nbID, name, UserID, srcID, path) VALUES('%s','%s','%s','%s', '%s')",
                nb.getNbId(),
                nb.getName(),
                nb.getUserId(),
                nb.getSrcId(),
                nb.getPath()
        );
        return execute(sql);
    }

    @Override
    public boolean deleteByPrimaryKey(String nbId) {
        if (nbId == null) return false;
        String sql = String.format(
                "DELETE FROM noteBook WHERE nbId = '%s'",
                nbId
        );
        return execute(sql);
    }

    @Override
    public boolean updateByPrimaryKeySelective(NbVO nb) {
        if (nb == null || nb.getNbId() == null) return false;
        NbVO old = null;
        try {
            old = queryById(nb.getNbId());
            if (old == null) return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        if (nb.getName() != null) old.setName(nb.getName());
        if (nb.getPath() != null) old.setPath(nb.getPath());
        String sql = String.format(
                "UPDATE noteBook SET name='%s', path='%s' WHERE nbId='%s';",
                old.getName(),
                old.getPath(),
                old.getNbId()
        );
        return execute(sql);
    }

    @Override
    public NbVO queryById(String nbId) throws SQLException {
        DataBaseConnection dbConnection = new DataBaseConnection();
        Connection collection = dbConnection.getConnection();
        if (collection == null) return null;
        Statement statement = collection.createStatement();
        String sql = String.format(
                "SELECT * FROM noteBook WHERE nbId = '%s'",
                nbId
        );
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()){
            return new NbVO(
                    nbId,
                    rs.getString("name"),
                    rs.getString("ownerId"),
                    rs.getString("path"),
                    rs.getString("srcId")
            );
        }
        return null;
    }

    @Override
    public NbVO queryByOwnerIdAndName(String ownerId, String name, String path) throws SQLException {
        DataBaseConnection dbConnection = new DataBaseConnection();
        Connection collection = dbConnection.getConnection();
        if (collection == null) return null;
        Statement statement = collection.createStatement();
        String sql = String.format(
                "SELECT * FROM noteBook WHERE ownerId = '%s' AND name = '%s' AND path = '%s'",
                ownerId,
                name,
                path
        );
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()){
            return new NbVO(
                    rs.getString("nbId"),
                    name,
                    ownerId,
                    rs.getString("path"),
                    rs.getString("srcId")
            );
        }
        return null;
    }

    @Override
    public List<NbVO> queryAllNbByUserId(String userId) throws SQLException {
        DataBaseConnection dbConnection = new DataBaseConnection();
        Connection collection = dbConnection.getConnection();
        if (collection == null) return null;
        Statement statement = collection.createStatement();
        String sql = String.format(
                "SELECT * FROM noteBook WHERE ownerId = '%s'",
                userId
        );

        ResultSet rs = statement.executeQuery(sql);
        List<NbVO> res = new ArrayList<>();
        while (rs.next()){
            NbVO nb = new NbVO(
                    rs.getString("nbId"),
                    rs.getString("name"),
                    rs.getString("ownerId"),
                    rs.getString("path"),
                    rs.getString("srcId")
            );
            res.add(nb);
        }
        return res;
    }
}
