package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.entity.Barometer;
import lk.edu.ijse.metromanagement.model.BarometerDTO;

import java.util.ArrayList;

public interface BarometerBO extends SuperBO {
    public boolean addBarometer(BarometerDTO barometer)throws Exception;

    public boolean deleteBarometer(String barometerID)throws Exception;

    public boolean updateBarometer(BarometerDTO barometer)throws Exception;

    public BarometerDTO searchBarometer(String barometerID)throws Exception;

    public ArrayList<BarometerDTO> getAllBarometer()throws Exception;

}
