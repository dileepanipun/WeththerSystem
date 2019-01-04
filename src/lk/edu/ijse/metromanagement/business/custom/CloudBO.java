package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.CloudDTO;

public interface CloudBO extends SuperBO {

    public CloudDTO searchCloud(String cloudID)throws Exception;
}
