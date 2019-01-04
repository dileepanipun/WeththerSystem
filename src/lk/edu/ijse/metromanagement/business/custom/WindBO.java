package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.WindDTO;

public interface WindBO extends SuperBO {

    public WindDTO searchWind(String wetherID)throws Exception;
}
