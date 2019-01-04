package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.RainBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.RainDAO;
import lk.edu.ijse.metromanagement.entity.Rain;
import lk.edu.ijse.metromanagement.model.RainDTO;

public class RainBOImpl implements RainBO {

    private static RainDAO rainDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.RAIN);

    @Override
    public RainDTO searchRain(String rainID) throws Exception {
        Rain rainDTO = rainDAO.search(rainID);
        return null;
    }
}
