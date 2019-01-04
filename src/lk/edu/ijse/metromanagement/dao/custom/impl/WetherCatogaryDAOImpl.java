package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.WetherCatogaryDAO;
import lk.edu.ijse.metromanagement.entity.WetherCatogary;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WetherCatogaryDAOImpl implements WetherCatogaryDAO {
    @Override
    public boolean save(WetherCatogary catogary) throws Exception {
        return CrudUtil.executeUpdate("Insert into wethercatogary values(?,?)",
                catogary.getCatogaryID(),
                catogary.getcTypes()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(WetherCatogary entity) throws Exception {
        return false;
    }

    @Override
    public WetherCatogary search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from wethercatogary where catogaryID=?", s);
        if (rst.next()){
            return new WetherCatogary(
                    rst.getString(1),
                    rst.getString(2)
            );
        }
        return null;
    }

    @Override
    public ArrayList<WetherCatogary> getAll() throws Exception {
        ArrayList<WetherCatogary> catId = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from wethercatogary");
        while (rst.next()){
            catId.add(new WetherCatogary(
                    rst.getString(1),
                    rst.getString(2)
            ));
        }
        return catId;
    }
}
