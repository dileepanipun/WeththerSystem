package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.ThermometerDAO;
import lk.edu.ijse.metromanagement.entity.Thermometer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ThermometerDAOImpl implements ThermometerDAO {
    @Override
    public boolean save(Thermometer entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO thermometer VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                entity.getThermometerID(),
                entity.getArCurrent(),
                entity.getArMaxDry(),
                entity.getArMaxWet(),
                entity.getArMinDry(),
                entity.getArMinWet(),
                entity.getArMinOnGrass(),
                entity.getSftRestMaxDry(),
                entity.getSftRestMaxWet(),
                entity.getIcCurDry(),
                entity.getIcCurWet(),
                entity.getIcMaxDry(),
                entity.getIcMaxWet(),
                entity.getIcMinDry(),
                entity.getIcMinWet(),
                entity.getIcMinOnGrass(),
                entity.getDpCurTemp(),
                entity.getDpMaxTemps(),
                entity.getDpMinTemps(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Thermometer entity) throws Exception {
        return false;
    }

    @Override
    public Thermometer search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM thermometer WHERE wetherID=?", s);
        if (rst.next()){
            return new Thermometer(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getInt(7),
                    rst.getInt(8),
                    rst.getInt(9),
                    rst.getInt(10),
                    rst.getInt(11),
                    rst.getInt(12),
                    rst.getInt(13),
                    rst.getInt(14),
                    rst.getInt(15),
                    rst.getInt(16),
                    rst.getInt(17),
                    rst.getInt(18),
                    rst.getInt(19),
                    rst.getString(20)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Thermometer> getAll() throws Exception {
        return null;
    }
}
