package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.RegistrationDAO;
import lk.edu.ijse.metromanagement.entity.Registration;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RegistraionDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration entity) throws Exception {
        return CrudUtil.executeUpdate(
             "INSERT INTO registration VALUES (?,?,?)",
             entity.getRegisterID(),
             entity.getUserID(),
             entity.getRegDate()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM registration WHERE userID=?", s) > 0;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE registration SET userID=?,regDate=? WHERE registerID=?",
                entity.getUserID(),
                entity.getRegDate(),
                entity.getRegisterID()
        ) > 0;
    }

    @Override
    public Registration search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM registration where userID=?", s);
        if (rst.next()){
            return new Registration(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        ArrayList<Registration> list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM registration");
        while (rst.next()){
            list.add(new Registration(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return null;
    }
}
