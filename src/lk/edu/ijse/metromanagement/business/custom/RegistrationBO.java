package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {

    public boolean addRegistration(RegistrationDTO registration)throws Exception;

    public boolean deleteRegistration(String registrationID)throws Exception;

    public boolean updateRegistration(RegistrationDTO registration)throws Exception;

    public RegistrationDTO searchRegistration(String registrationID)throws Exception;

    public ArrayList<RegistrationDTO> getAllRegistrations()throws Exception;
}
