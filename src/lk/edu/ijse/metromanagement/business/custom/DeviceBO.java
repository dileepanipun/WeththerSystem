package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.DeviceDTO;

import java.util.ArrayList;

public interface DeviceBO extends SuperBO {
    public boolean addDevice(DeviceDTO device)throws Exception;

    public boolean deleteDevice(String deviceID)throws Exception;

    public boolean updateDevice(DeviceDTO device)throws Exception;

    public DeviceDTO searchDevice(String deviceID)throws Exception;

    public ArrayList<DeviceDTO> getAllDevices()throws Exception;
}
