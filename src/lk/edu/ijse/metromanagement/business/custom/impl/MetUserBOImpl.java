package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.MetUserBO;
import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.MetUserDAO;
import lk.edu.ijse.metromanagement.dao.custom.QueryDAO;
import lk.edu.ijse.metromanagement.dao.custom.RegistrationDAO;
import lk.edu.ijse.metromanagement.db.DBConnection;
import lk.edu.ijse.metromanagement.entity.MetUser;
import lk.edu.ijse.metromanagement.entity.Registration;
import lk.edu.ijse.metromanagement.model.MetUserDTO;
import lk.edu.ijse.metromanagement.model.RegistrationDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class MetUserBOImpl implements MetUserBO {

    private static MetUserDAO metUserDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.METUSER);

    private static RegistrationDAO registrationDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.REGISTER);

    private static QueryDAO queryDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CUSTOM);

    private static Connection connection;

    @Override
    public boolean addUser(MetUserDTO metUser) throws Exception {

        connection = DBConnection.getInstance().getConnection();

        RegistrationDTO registrationDTO = metUser.getRegistrationDTO();

        boolean saveUser = metUserDAO.save(new MetUser(
                metUser.getUserID(),
                metUser.getFirstName(),
                metUser.getLastName(),
                metUser.getAddress(),
                metUser.getDob(),
                metUser.getNicNo(),
                metUser.getTelephone(),
                metUser.getUserName(),
                metUser.getUserState(),
                metUser.getEmail(),
                metUser.getPassword()
        ));

        boolean saveRegister = registrationDAO.save(new Registration(
                registrationDTO.getRegisterID(),
                registrationDTO.getUserID(),
                registrationDTO.getRegDate()
        ));
        try {
            connection.setAutoCommit(false);
            if (saveUser && saveRegister) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteUser(String metUserID) throws Exception {
        if (registrationDAO.delete(metUserID) && metUserDAO.delete(metUserID)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateUser(MetUserDTO metUser) throws Exception {
        connection = DBConnection.getInstance().getConnection();

        MetUser metUserEntity = new MetUser(
                metUser.getUserID(),
                metUser.getFirstName(),
                metUser.getLastName(),
                metUser.getAddress(),
                metUser.getDob(),
                metUser.getNicNo(),
                metUser.getTelephone(),
                metUser.getUserName(),
                metUser.getUserState(),
                metUser.getEmail(),
                metUser.getPassword()
        );

        RegistrationDTO registrationDTO = metUser.getRegistrationDTO();
        Registration registrationEntitiy = new Registration(
                registrationDTO.getRegisterID(),
                registrationDTO.getUserID(),
                registrationDTO.getRegDate()
        );

        try {
            connection.setAutoCommit(false);
            if (registrationDAO.update(registrationEntitiy) && metUserDAO.update(metUserEntity)) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public MetUserDTO searchUserByID(String metUserID) throws Exception {
        MetUser searchUser = queryDAO.searchUserByName(metUserID);
        return new MetUserDTO(
                searchUser.getUserID(),
                searchUser.getUserName(),
                searchUser.getPassword()
        );
    }

    @Override
    public MetUserDTO searchUserByName(String metUserID) throws Exception {
        MetUser searchUser = metUserDAO.search(metUserID);
        Registration searchReg = registrationDAO.search(metUserID);
        return new MetUserDTO(
                searchUser.getUserID(),
                searchUser.getFirstName(),
                searchUser.getLastName(),
                searchUser.getAddress(),
                searchUser.getDob(),
                searchUser.getNicNo(),
                searchUser.getTelephone(),
                searchUser.getUserName(),
                searchUser.getUserState(),
                searchUser.getEmail(),
                searchUser.getPassword(),
                new RegistrationDTO(
                        searchReg.getRegisterID(),
                        searchReg.getUserID(),
                        searchReg.getRegDate()
                )
        );
    }

    @Override
    public ArrayList<MetUserDTO> getAllUsers() throws Exception {
        ArrayList<MetUser> metUsers = metUserDAO.getAll();
        ArrayList<MetUserDTO> dtos = new ArrayList<>();
        for (MetUser user : metUsers){
            dtos.add(new MetUserDTO(
                    user.getUserID(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getAddress(),
                    user.getDob(),
                    user.getNicNo(),
                    user.getTelephone(),
                    user.getUserName(),
                    user.getUserState(),
                    user.getEmail(),
                    user.getPassword()
            ));
        }
        return dtos;
    }
}
