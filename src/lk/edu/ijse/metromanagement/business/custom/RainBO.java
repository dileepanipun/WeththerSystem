package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.RainDTO;

public interface RainBO extends SuperBO {

    public RainDTO searchRain(String rainID)throws Exception;
}
