package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.ThermometerDTO;

import java.util.ArrayList;

public interface ThermometerBO extends SuperBO {
    public boolean addThermometer(ThermometerDTO thermometerDTO)throws Exception;

    public boolean deleteThermometer(String thermometerID)throws Exception;

    public boolean updateThermometer(ThermometerDTO thermometer)throws Exception;

    public ThermometerDTO searchThermometer(String thermometerID)throws Exception;

    public ArrayList<ThermometerDTO> getAllThermometer()throws Exception;
}
