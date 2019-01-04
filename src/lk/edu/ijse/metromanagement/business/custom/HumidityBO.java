package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.HumidityDTO;

public interface HumidityBO extends SuperBO {

    public HumidityDTO searchHumidity(String humidityID)throws Exception;
}
