package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.WindBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.WindDAO;
import lk.edu.ijse.metromanagement.entity.Wind;
import lk.edu.ijse.metromanagement.model.WindDTO;

public class WindBOImpl implements WindBO {

    private static WindDAO windDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.WIND);

    @Override
    public WindDTO searchWind(String wetherID) throws Exception {
        Wind search = windDAO.search(wetherID);
        return new WindDTO(
                search.getWindID(),
                search.getWindDirection(),
                search.getFirstRead(),
                search.getSecondRead(),
                search.getFrceInKmh(),
                search.getFrceInKnots(),
                search.getMileagePer(),
                search.getWetherID()
        );
    }
}
