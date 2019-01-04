package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.DeviceDAO;
import lk.edu.ijse.metromanagement.entity.Device;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DeviceDAOImpl implements DeviceDAO {
    @Override
    public boolean save(Device device) throws Exception {

        return CrudUtil.executeUpdate("Insert into device values(?,?,?,?,?,?,?) ",
                device.getDeviceID(),
                device.getName(),
                device.getWarrentyPer(),
                device.getRepiredPer(),
                device.getRegisterDate(),
                device.getCatogaryID(),
                device.getCompanyID()
        ) > 0;

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM device where deviceID=?", s) > 0;
    }

    @Override
    public boolean update(Device entity) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE device SET name=?,warrentyPer=?,repiredPer=?,registerDate=?,catogaryID=?,companyID=? WHERE deviceID=?",
                entity.getName(),
                entity.getWarrentyPer(),
                entity.getRepiredPer(),
                entity.getRegisterDate(),
                entity.getCatogaryID(),
                entity.getCompanyID(),
                entity.getDeviceID()
        ) > 0;
    }

    @Override
    public Device search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT * FROM device where name LIKE ?", s
        );
        return new Device(
                rst.getString(1),
                rst.getString(2),
                rst.getInt(3),
                rst.getInt(4),
                rst.getString(5),
                rst.getString(6),
                rst.getString(7)
        );
    }

    @Override
    public ArrayList<Device> getAll() throws Exception {
        ArrayList<Device> devices = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from device");
        while (rst.next()){
            devices.add(new Device(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            ));
        }
        return devices;
    }
}
