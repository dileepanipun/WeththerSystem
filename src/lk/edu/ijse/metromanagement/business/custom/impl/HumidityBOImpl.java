package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.HumidityBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.HumidityDAO;
import lk.edu.ijse.metromanagement.entity.Humidity;
import lk.edu.ijse.metromanagement.model.HumidityDTO;

public class HumidityBOImpl implements HumidityBO {

    private static HumidityDAO humidityDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.HUMIDITY);

    @Override
    public HumidityDTO searchHumidity(String humidityID) throws Exception {
        Humidity search = humidityDAO.search(humidityID);
        return new HumidityDTO(
                search.getHumidityID(),
                search.getVpCurrent(),
                search.getVpMaxTemps(),
                search.getVpMinTemps(),
                search.getRhCurrent(),
                search.getRhMaxTemps(),
                search.getRhMinTemps(),
                search.getVisibility(),
                search.getWetherID()
        );
    }
}
