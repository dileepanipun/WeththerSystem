package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.MetUserDAO;
import lk.edu.ijse.metromanagement.entity.MetUser;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MetUserDAOImpl implements MetUserDAO {
    @Override
    public boolean save(MetUser entity) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO metuser VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                entity.getUserID(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAddress(),
                entity.getDob(),
                entity.getNicNo(),
                entity.getTelephone(),
                entity.getUserName(),
                entity.getUserState(),
                entity.getEmail(),
                entity.getPassword()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate(
                "DELETE FROM metuser WHERE userID=?", s
        ) > 0;
    }


    @Override
    public boolean update(MetUser entity) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE metuser SET firstName=?,lastName=?,address=?,dob=?,nicNo=?,telephone=?,userName=?,userState=?,email=?,password=? WHERE userID=?",
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAddress(),
                entity.getDob(),
                entity.getNicNo(),
                entity.getTelephone(),
                entity.getUserName(),
                entity.getUserState(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getUserID()
        ) > 0;
    }

    @Override
    public MetUser search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT * FROM metuser where userID=?", s
        );
        if (rst.next()){
            return new MetUser(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)
            );
        }
        return null;
    }

    @Override
    public MetUser searchByUserName(String userName) throws Exception{
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM metuser WHERE userName=?", userName);
        return new MetUser(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                rst.getString(6),
                rst.getString(7),
                rst.getString(8),
                rst.getString(9),
                rst.getString(10),
                rst.getString(11)
        );
    }

    @Override
    public ArrayList<MetUser> getAll() throws Exception {
        ArrayList<MetUser> metUsers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM metuser");
        while (rst.next()){
            metUsers.add(new MetUser(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)
            ));
        }
        return metUsers;
    }
}
