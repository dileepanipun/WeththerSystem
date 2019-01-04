package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.BarometerBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.BarometerDAO;
import lk.edu.ijse.metromanagement.entity.Barometer;
import lk.edu.ijse.metromanagement.model.BarometerDTO;

import java.util.ArrayList;

public class BarometerBOImpl implements BarometerBO {

    private BarometerDAO barometerDAO;

    public BarometerBOImpl() {
        barometerDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.BAROMETER);
    }

    public boolean addBarometer(BarometerDTO barometer) throws Exception {
        return barometerDAO.save(new Barometer(
                barometer.getBarometerID(),
                barometer.getAttdThermo(),
                barometer.getAsReadInch(),
                barometer.getMbsLevel(),
                barometer.getNearstMbsLevel(),
                barometer.getBaroTendancy(),
                barometer.getWetherID()
        ));
    }

    @Override
    public boolean deleteBarometer(String barometerID) throws Exception {
        return barometerDAO.delete(barometerID);
    }

    @Override
    public boolean updateBarometer(BarometerDTO barometer) throws Exception {
        return barometerDAO.update(new Barometer(
                barometer.getBarometerID(),
                barometer.getAttdThermo(),
                barometer.getAsReadInch(),
                barometer.getMbsLevel(),
                barometer.getNearstMbsLevel(),
                barometer.getBaroTendancy(),
                barometer.getWetherID()
        ));
    }

    @Override
    public BarometerDTO searchBarometer(String barometerID) throws Exception {
        Barometer barometer = barometerDAO.search(barometerID);
        return new BarometerDTO(
                barometer.getBarometerID(),
                barometer.getAttdThermo(),
                barometer.getAsReadInch(),
                barometer.getMbsLevel(),
                barometer.getNearstMbsLevel(),
                barometer.getBaroTendancy(),
                barometer.getWetherID()
        );
    }

    @Override
    public ArrayList<BarometerDTO> getAllBarometer() throws Exception {
        ArrayList<Barometer> allBarometers = barometerDAO.getAll();
        ArrayList<BarometerDTO> dtos = new ArrayList<>();
        for (Barometer barometer : allBarometers ) {
            dtos.add(new BarometerDTO(
                    barometer.getBarometerID(),
                    barometer.getAttdThermo(),
                    barometer.getAsReadInch(),
                    barometer.getMbsLevel(),
                    barometer.getNearstMbsLevel(),
                    barometer.getBaroTendancy(),
                    barometer.getWetherID()
            ));
        }
        return dtos;
    }

}
