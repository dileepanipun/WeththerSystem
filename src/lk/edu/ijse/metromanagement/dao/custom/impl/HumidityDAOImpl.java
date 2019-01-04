package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.HumidityDAO;
import lk.edu.ijse.metromanagement.entity.Humidity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HumidityDAOImpl implements HumidityDAO {
    @Override
    public boolean save(Humidity entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO humidity values (?,?,?,?,?,?,?,?,?)",
                entity.getHumidityID(),
                entity.getVpCurrent(),
                entity.getVpMaxTemps(),
                entity.getVpMinTemps(),
                entity.getRhCurrent(),
                entity.getRhMaxTemps(),
                entity.getRhMinTemps(),
                entity.getVisibility(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Humidity entity) throws Exception {
        return false;
    }

    @Override
    public Humidity search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM humidity where wetherID", s);
        if (rst.next()){
            return new Humidity(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getInt(7),
                    rst.getString(8),
                    rst.getString(9)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Humidity> getAll() throws Exception {
        return null;
    }
}
