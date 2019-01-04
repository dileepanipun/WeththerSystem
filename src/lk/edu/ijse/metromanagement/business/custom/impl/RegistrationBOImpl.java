package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.RegistrationBO;
import lk.edu.ijse.metromanagement.dao.custom.RegistrationDAO;
import lk.edu.ijse.metromanagement.dao.custom.impl.RegistraionDAOImpl;
import lk.edu.ijse.metromanagement.entity.Registration;
import lk.edu.ijse.metromanagement.model.RegistrationDTO;

import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {

    private static RegistrationDAO registrationDAO = new RegistraionDAOImpl();

    @Override
    public boolean addRegistration(RegistrationDTO registration) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRegistration(String registrationID) throws Exception {
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO registration) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO searchRegistration(String registrationID) throws Exception {
        Registration search = registrationDAO.search(registrationID);
        return new RegistrationDTO(
                search.getRegisterID(),
                search.getUserID(),
                search.getRegDate()
        );
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() throws Exception {
        return null;
    }
}
