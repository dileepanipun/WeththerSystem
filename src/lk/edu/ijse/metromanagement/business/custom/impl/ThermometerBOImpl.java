package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.ThermometerBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.ThermometerDAO;
import lk.edu.ijse.metromanagement.entity.Thermometer;
import lk.edu.ijse.metromanagement.model.ThermometerDTO;

import java.util.ArrayList;

public class ThermometerBOImpl implements ThermometerBO {

    private static ThermometerDAO thermometerDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.THERMOMETER);

    @Override
    public boolean addThermometer(ThermometerDTO thermometerDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteThermometer(String thermometerID) throws Exception {
        return false;
    }

    @Override
    public boolean updateThermometer(ThermometerDTO thermometer) throws Exception {
        return false;
    }

    @Override
    public ThermometerDTO searchThermometer(String thermometerID) throws Exception {
        Thermometer search = thermometerDAO.search(thermometerID);
        return new ThermometerDTO(
                search.getThermometerID(),
                search.getArCurrent(),
                search.getArMaxDry(),
                search.getArMaxWet(),
                search.getArMinDry(),
                search.getArMinWet(),
                search.getArMinOnGrass(),
                search.getSftRestMaxDry(),
                search.getSftRestMaxWet(),
                search.getIcCurDry(),
                search.getIcCurWet(),
                search.getIcMaxDry(),
                search.getIcMaxWet(),
                search.getIcMinDry(),
                search.getIcMinWet(),
                search.getIcMinOnGrass(),
                search.getDpCurTemp(),
                search.getDpMaxTemps(),
                search.getDpMinTemps(),
                search.getWetherID()
        );
    }

    @Override
    public ArrayList<ThermometerDTO> getAllThermometer() throws Exception {
        return null;
    }
}
