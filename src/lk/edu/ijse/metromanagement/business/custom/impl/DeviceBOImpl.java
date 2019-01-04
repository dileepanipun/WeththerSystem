package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.DeviceBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.DeviceDAO;
import lk.edu.ijse.metromanagement.dao.custom.QueryDAO;
import lk.edu.ijse.metromanagement.entity.CustomEntity;
import lk.edu.ijse.metromanagement.entity.Device;
import lk.edu.ijse.metromanagement.model.CompanyDTO;
import lk.edu.ijse.metromanagement.model.DeviceDTO;
import lk.edu.ijse.metromanagement.model.WetherCatogaryDTO;

import java.util.ArrayList;

public class DeviceBOImpl implements DeviceBO {

    private DeviceDAO deviceDAO;
    private QueryDAO queryDAOImpl;
    public DeviceBOImpl() {
        deviceDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.DEVICE);
        queryDAOImpl = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CUSTOM);
    }

    @Override
    public boolean addDevice(DeviceDTO device) throws Exception {
        return deviceDAO.save(new Device(
                device.getDeviceID(),
                device.getName(),
                device.getWarrentyPer(),
                device.getRepiredPer(),
                device.getRegisterDate(),
                device.getCatogaryID(),
                device.getCompanyID()
        ));
    }

    @Override
    public boolean deleteDevice(String deviceID) throws Exception {
        return deviceDAO.delete(deviceID);
    }

    @Override
    public boolean updateDevice(DeviceDTO device) throws Exception {
        return deviceDAO.update(new Device(
                device.getDeviceID(),
                device.getName(),
                device.getWarrentyPer(),
                device.getRepiredPer(),
                device.getRegisterDate(),
                device.getCatogaryID(),
                device.getCompanyID()
        ));
    }

    @Override
    public DeviceDTO searchDevice(String deviceID) throws Exception {
        Device device = deviceDAO.search(deviceID);
        return new DeviceDTO(
                device.getDeviceID(),
                device.getName(),
                device.getWarrentyPer(),
                device.getRepiredPer(),
                device.getRegisterDate(),
                device.getCatogaryID(),
                device.getCompanyID()
        );
    }

    @Override
    public ArrayList<DeviceDTO> getAllDevices() throws Exception {
        ArrayList<CustomEntity> devices = queryDAOImpl.getAllDeviceWithCompanyName();
        ArrayList<DeviceDTO> dtos = new ArrayList<>();
        for (CustomEntity device : devices){
            dtos.add(new DeviceDTO(
                    device.getDeviceID(),
                    device.getName(),
                    device.getWarrentyPer(),
                    device.getRepiredPer(),
                    device.getRegisterDate(),
                    device.getCatogaryID(),
                    device.getCatogaryID(),
                    new CompanyDTO(device.getCompanyID(), device.getCmpName(),device.getAddress(),device.getTelephoneNo()),
                    new WetherCatogaryDTO(device.getCatogaryID(),device.getcType())
            ));
        }
        return dtos;
    }
}
