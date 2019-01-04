package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.SeaStateDAO;
import lk.edu.ijse.metromanagement.entity.SeaState;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SeaStateDAOImpl implements SeaStateDAO {
    @Override
    public boolean save(SeaState entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO seastate VALUES (?,?,?,?,?,?,?)",
                entity.getSeaStateID(),
                entity.getSeaCodeFigure(),
                entity.getSwellCodeFigure(),
                entity.getwValue(),
                entity.getW1Value(),
                entity.getWwValue(),
                entity.getWetherID()

        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(SeaState entity) throws Exception {
        return false;
    }

    @Override
    public SeaState search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM seastate WHERE wetherID=?", s);
        if (rst.next()){
            return new SeaState(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getString(7)
            );
        }
        return null;
    }

    @Override
    public ArrayList<SeaState> getAll() throws Exception {
        return null;
    }
}
