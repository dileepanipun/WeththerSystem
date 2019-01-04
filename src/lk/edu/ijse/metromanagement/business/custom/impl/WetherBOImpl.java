package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.WetherBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.*;
import lk.edu.ijse.metromanagement.dao.custom.impl.WetherDAOImpl;
import lk.edu.ijse.metromanagement.db.DBConnection;
import lk.edu.ijse.metromanagement.entity.*;
import lk.edu.ijse.metromanagement.model.*;

import java.sql.Connection;
import java.util.ArrayList;

public class WetherBOImpl implements WetherBO {

    private static WetherDAO wetherDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.WETHER);

    private static BarometerDAO barometerDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.BAROMETER);

    private static ThermometerDAO thermometerDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.THERMOMETER);

    private static HumidityDAO humidityDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.HUMIDITY);

    private static RainDAO rainDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.RAIN);

    private static WindDAO windDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.WIND);

    private static CloudDAO cloudDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CLOUD);

    private static SeaStateDAO seaStateDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.SEASTATE);

    private static QueryDAO queryDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CUSTOM);



    @Override
    public boolean addWether(WetherDTO wether) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        Wether wetherEntity = new Wether(
                wether.getWetherID(),
                wether.getwTime(),
                wether.getwDate(),
                wether.getRegID()
        );

        BarometerDTO barometerDTO = wether.getBarometerDTO();
        Barometer barometer = new Barometer(
                barometerDTO.getBarometerID(),
                barometerDTO.getAttdThermo(),
                barometerDTO.getAsReadInch(),
                barometerDTO.getMbsLevel(),
                barometerDTO.getNearstMbsLevel(),
                barometerDTO.getBaroTendancy(),
                barometerDTO.getWetherID()
        );

        ThermometerDTO thermometerDTO = wether.getThermometerDTO();
        Thermometer thermometer = new Thermometer(
                thermometerDTO.getThermometerID(),
                thermometerDTO.getArCurrent(),
                thermometerDTO.getArMaxDry(),
                thermometerDTO.getArMaxWet(),
                thermometerDTO.getArMinDry(),
                thermometerDTO.getArMinWet(),
                thermometerDTO.getArMinOnGrass(),
                thermometerDTO.getSftRestMaxDry(),
                thermometerDTO.getSftRestMaxWet(),
                thermometerDTO.getIcCurDry(),
                thermometerDTO.getIcCurWet(),
                thermometerDTO.getIcMaxDry(),
                thermometerDTO.getIcMaxWet(),
                thermometerDTO.getIcMinDry(),
                thermometerDTO.getIcMinWet(),
                thermometerDTO.getIcMinOnGrass(),
                thermometerDTO.getDpCurTemp(),
                thermometerDTO.getDpMaxTemps(),
                thermometerDTO.getDpMinTemps(),
                thermometerDTO.getWetherID()
        );

        HumidityDTO humidityDTO = wether.getHumidityDTO();
        Humidity humidity = new Humidity(
                humidityDTO.getHumidityID(),
                humidityDTO.getVpCurrent(),
                humidityDTO.getVpMaxTemps(),
                humidityDTO.getVpMinTemps(),
                humidityDTO.getRhCurrent(),
                humidityDTO.getRhMaxTemps(),
                humidityDTO.getRhMinTemps(),
                humidityDTO.getVisibility(),
                humidityDTO.getWetherID()
        );

        RainDTO rainDTO = wether.getRainDTO();
        Rain rain = new Rain(
                rainDTO.getRainID(),
                rainDTO.getLastObs(),
                rainDTO.getLastRoute(),
                rainDTO.getPer8Hrs(),
                rainDTO.getJanFirst(),
                rainDTO.getWetherID()
        );

        WindDTO windDTO = wether.getWindDTO();
        Wind wind = new Wind(
                windDTO.getWindID(),
                windDTO.getWindDirection(),
                windDTO.getFirstRead(),
                windDTO.getSecondRead(),
                windDTO.getFrceInKmh(),
                windDTO.getFrceInKnots(),
                windDTO.getMileagePer(),
                windDTO.getWetherID()
        );

        CloudDTO cloudDTO = wether.getCloudDTO();
        Cloud cloud = new Cloud(
                cloudDTO.getCloudID(),
                cloudDTO.getLcAmount(),
                cloudDTO.getLcFrom(),
                cloudDTO.getLcDirection(),
                cloudDTO.getMcAmount(),
                cloudDTO.getMcFrom(),
                cloudDTO.getMcDirection(),
                cloudDTO.getHcAmount(),
                cloudDTO.getHcFrom(),
                cloudDTO.getHcDirection(),
                cloudDTO.getSgAmount(),
                cloudDTO.getSgForm(),
                cloudDTO.getSgHeight(),
                cloudDTO.getTotalAmount(),
                cloudDTO.getWetherID()
        );

        SeaStateDTO seaStateDTO = wether.getSeaStateDTO();
        SeaState seaState = new SeaState(
                seaStateDTO.getSeaStateID(),
                seaStateDTO.getSeaCodeFigure(),
                seaStateDTO.getSwellCodeFigure(),
                seaStateDTO.getwValue(),
                seaStateDTO.getW1Value(),
                seaStateDTO.getWwValue(),
                seaStateDTO.getWetherID()
        );
        connection.setAutoCommit(false);
        try {
            if (wetherDAO.save(wetherEntity)) {
                if (barometerDAO.save(barometer) && thermometerDAO.save(thermometer) && humidityDAO.save(humidity) && rainDAO.save(rain) && windDAO.save(wind) && cloudDAO.save(cloud) && seaStateDAO.save(seaState)) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                return false;
            }
        }finally {
            connection.rollback();
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteDevice(String wetherID) throws Exception {
        return false;
    }

    @Override
    public boolean updateWether(WetherDTO wether) throws Exception {
        return false;
    }

    @Override
    public WetherDTO searchWether(String wetherID) throws Exception {
        Wether search = wetherDAO.search(wetherID);
        return new WetherDTO(
                search.getWetherID(),
                search.getwTime(),
                search.getwDate(),
                search.getRegID()
        );
    }

    @Override
    public WetherDTO searchLastWether() throws Exception {
        Wether lastWether = queryDAO.searchWetherByDate();
        return new WetherDTO(
                lastWether.getWetherID(),
                lastWether.getwTime(),
                lastWether.getwDate(),
                lastWether.getRegID()
        );
    }

    @Override
    public ArrayList<WetherDTO> getAllWether() throws Exception {
        ArrayList<Wether> wethers = wetherDAO.getAll();
        ArrayList<WetherDTO> dtos = new ArrayList<>();
        for (Wether wether : wethers){
            dtos.add(new WetherDTO(
                    wether.getWetherID(),
                    wether.getwTime(),
                    wether.getwDate(),
                    wether.getRegID()
            ));
        }
        return dtos;
    }
}
