package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.WetherDAO;
import lk.edu.ijse.metromanagement.entity.Wether;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WetherDAOImpl implements WetherDAO {
    @Override
    public boolean save(Wether entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO wether values (?,?,?,?)",
                entity.getWetherID(),
                entity.getwTime(),
                entity.getwDate(),
                entity.getRegID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Wether entity) throws Exception {
        return false;
    }

    @Override
    public Wether search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM wether");
        return new Wether(
                rst.getString(0),
                rst.getString(1),
                rst.getString(2),
                rst.getString(3)
        );
    }

    @Override
    public ArrayList<Wether> getAll() throws Exception {
        ArrayList<Wether> dtos = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM wether");
        while (rst.next()){
            dtos.add(new Wether(
                    rst.getString(0),
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return dtos;
    }
}
