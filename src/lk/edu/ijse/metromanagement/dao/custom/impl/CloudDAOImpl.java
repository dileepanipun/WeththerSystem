package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.CloudDAO;
import lk.edu.ijse.metromanagement.entity.Cloud;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CloudDAOImpl implements CloudDAO {
    @Override
    public boolean save(Cloud entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT into cloud values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                entity.getCloudID(),
                entity.getLcAmount(),
                entity.getLcFrom(),
                entity.getLcDirection(),
                entity.getMcAmount(),
                entity.getMcFrom(),
                entity.getMcDirection(),
                entity.getHcAmount(),
                entity.getHcFrom(),
                entity.getHcDirection(),
                entity.getSgAmount(),
                entity.getSgForm(),
                entity.getSgHeight(),
                entity.getTotalAmount(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate(
                "delete FROM cloud where cloudID=?",s
        )>0;
    }

    @Override
    public boolean update(Cloud entity) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE cloud SET cloudID=?,lcAmount=?,lcForm=?,lcDirection=?,mcAmount=?,mcForm=?,mcDirection=?,hcAmount=?,hcForm=?,hcDirection=?,sgAmount=?,sgForm=?,sgHeight=?, wetherID=?",
                entity.getCloudID(),
                entity.getLcAmount(),
                entity.getLcFrom(),
                entity.getLcDirection(),
                entity.getMcAmount(),
                entity.getMcFrom(),
                entity.getMcDirection(),
                entity.getHcAmount(),
                entity.getHcFrom(),
                entity.getHcDirection(),
                entity.getSgAmount(),
                entity.getSgForm(),
                entity.getSgHeight(),
                entity.getWetherID()
        ) > 0;
    }

    @Override
    public Cloud search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT * from cloud where cloudID=?", s
        );
        if (rst.next()){
            return new Cloud(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getInt(10),
                    rst.getInt(11),
                    rst.getInt(12),
                    rst.getInt(13),
                    rst.getInt(14),
                    rst.getString(15)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Cloud> getAll() throws Exception {
        return null;
    }
}
