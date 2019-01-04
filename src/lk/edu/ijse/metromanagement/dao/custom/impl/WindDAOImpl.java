package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.WindDAO;
import lk.edu.ijse.metromanagement.entity.Wind;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WindDAOImpl implements WindDAO {
    @Override
    public boolean save(Wind entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO wind VALUES (?,?,?,?,?,?,?,?)",
                entity.getWindID(),
                entity.getWindDirection(),
                entity.getFirstRead(),
                entity.getSecondRead(),
                entity.getFrceInKmh(),
                entity.getFrceInKnots(),
                entity.getMileagePer(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Wind entity) throws Exception {
        return false;
    }

    @Override
    public Wind search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM wind WHERE wetherID=?", s);
        if (rst.next()){
            return new Wind(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getString(7),
                    rst.getString(8)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Wind> getAll() throws Exception {
        return null;
    }
}
