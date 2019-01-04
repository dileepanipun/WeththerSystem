package lk.edu.ijse.metromanagement.dao;

import lk.edu.ijse.metromanagement.dao.custom.impl.*;

public class DAOFactory {

    public enum DAOTypes {
        WETHER, BAROMETER, THERMOMETER, HUMIDITY, CLOUD, WIND, RAIN, SEASTATE, COMPANY, DEVICE, WETHER_CATOGARY, METUSER, REGISTER, CUSTOM;
    }

    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T> T getDao(DAOTypes daoType) {
        switch (daoType) {

            case WETHER:
                return (T) new WetherDAOImpl();

            case BAROMETER:
                return (T) new BarometerDAOImpl();

            case THERMOMETER:
                return (T) new ThermometerDAOImpl();

            case HUMIDITY:
                return (T) new HumidityDAOImpl();

            case RAIN:
                return (T) new RainDAOImpl();

            case WIND:
                return (T) new WindDAOImpl();

            case CLOUD:
                return (T) new CloudDAOImpl();

            case SEASTATE:
                return (T) new SeaStateDAOImpl();

            case COMPANY:
                return (T) new CompanyDAOImpl();

            case DEVICE:
                return (T) new DeviceDAOImpl();

            case WETHER_CATOGARY:
                return (T) new WetherCatogaryDAOImpl();

            case METUSER:
                return (T) new MetUserDAOImpl();

            case REGISTER:
                return (T) new RegistraionDAOImpl();

            case CUSTOM:
                return (T) new QueryDAOImpl();

            default:
                return null;
        }
    }
}
