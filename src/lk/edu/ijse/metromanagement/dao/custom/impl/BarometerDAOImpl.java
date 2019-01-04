package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.BarometerDAO;
import lk.edu.ijse.metromanagement.entity.Barometer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BarometerDAOImpl implements BarometerDAO {
    @Override
    public boolean save(Barometer barometer) throws Exception {
        return CrudUtil.executeUpdate(
                "Insert into barometer values(?,?,?,?,?,?,?)",
                barometer.getBarometerID(),
                barometer.getAttdThermo(),
                barometer.getAsReadInch(),
                barometer.getMbsLevel(),
                barometer.getNearstMbsLevel(),
                barometer.getBaroTendancy(),
                barometer.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE from barometer where barometerID=?", s) > 0;
    }

    @Override
    public boolean update(Barometer barometer) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE barometer SET barometerID=?,attdThermo=?,asReadInch=?,mbsLevel=?,nearstMbsLevel=?,baroTendancy=?, wetherID=?",
                barometer.getBarometerID(),
                barometer.getAttdThermo(),
                barometer.getAsReadInch(),
                barometer.getMbsLevel(),
                barometer.getNearstMbsLevel(),
                barometer.getBaroTendancy(),
                barometer.getWetherID()
        ) > 0;
    }

    @Override
    public Barometer search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from barometer where barometerID=?", s);
        if (rst.next()){
            return new Barometer(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getInt(6),
                    rst.getString(8)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Barometer> getAll() throws Exception {
        ArrayList<Barometer> barometers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from barometer");
        while (rst.next()){
            barometers.add(new Barometer(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getInt(6),
                    rst.getString(8)
            ));
        }
        return barometers;
    }
}
