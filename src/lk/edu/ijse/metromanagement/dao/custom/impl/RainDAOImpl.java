package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.RainDAO;
import lk.edu.ijse.metromanagement.entity.Rain;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RainDAOImpl implements RainDAO {
    @Override
    public boolean save(Rain entity) throws Exception {
        return CrudUtil.executeUpdate(
             "INSERT INTO rain VALUES (?,?,?,?,?,?)",
                entity.getRainID(),
                entity.getLastObs(),
                entity.getLastRoute(),
                entity.getPer8Hrs(),
                entity.getJanFirst(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Rain entity) throws Exception {
        return false;
    }

    @Override
    public Rain search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM rain where wetherID=?", s);
        if (rst.next()){
            return new Rain(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Rain> getAll() throws Exception {
        return null;
    }
}
