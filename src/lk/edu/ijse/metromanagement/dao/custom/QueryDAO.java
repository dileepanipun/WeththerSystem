package lk.edu.ijse.metromanagement.dao.custom;


import lk.edu.ijse.metromanagement.dao.SuperDAO;
import lk.edu.ijse.metromanagement.entity.CustomEntity;
import lk.edu.ijse.metromanagement.entity.MetUser;
import lk.edu.ijse.metromanagement.entity.Wether;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<CustomEntity> getAllDeviceWithCompanyName() throws Exception;

    public Wether searchWetherByDate() throws Exception;

    public MetUser searchUserByName(String name) throws Exception;
}
