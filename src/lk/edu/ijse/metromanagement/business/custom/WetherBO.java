package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.WetherDTO;

import java.util.ArrayList;

public interface WetherBO extends SuperBO {
    public boolean addWether(WetherDTO wether)throws Exception;

    public boolean deleteDevice(String wetherID)throws Exception;

    public boolean updateWether(WetherDTO wether)throws Exception;

    public WetherDTO searchWether(String wetherID)throws Exception;

    public WetherDTO searchLastWether()throws Exception;

    public ArrayList<WetherDTO> getAllWether()throws Exception;
}
