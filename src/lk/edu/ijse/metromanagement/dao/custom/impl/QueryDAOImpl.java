package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.QueryDAO;
import lk.edu.ijse.metromanagement.dao.custom.WetherDAO;
import lk.edu.ijse.metromanagement.entity.CustomEntity;
import lk.edu.ijse.metromanagement.entity.Device;
import lk.edu.ijse.metromanagement.entity.MetUser;
import lk.edu.ijse.metromanagement.entity.Wether;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomEntity> getAllDeviceWithCompanyName() throws Exception {
        ArrayList<CustomEntity> devices = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(
                "Select\n" +
                        "  deviceID,\n" +
                        "  d.name,\n" +
                        "  warrentyPer,\n" +
                        "  repiredPer,\n" +
                        "  registerDate,\n" +
                        "  w.catogaryID,\n" +
                        "  c.companyID,\n" +
                        "  c.cmpName,\n" +
                        "  c.address,\n" +
                        "  c.telephoneNo,\n" +
                        "  w.cTypes\n" +
                        "from device d, company c, wethercatogary w\n" +
                        "where (c.companyID = d.companyID and w.catogaryID = d.catogaryID)");
        while (rst.next()){
            devices.add(new CustomEntity(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)
            ));
        }
        return devices;
    }

    @Override
    public Wether searchWetherByDate() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT * FROM wether where wDate=CURRENT_DATE ORDER BY wetherID DESC LIMIT 1"
        );
        if (rst.next()){
            return new Wether(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    @Override
    public MetUser searchUserByName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT userID,userName,password from metuser where userName=?", name);
        if (rst.next()){
            return new MetUser(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }


}
