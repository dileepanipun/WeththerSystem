package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.MetUserDTO;

import java.util.ArrayList;

public interface MetUserBO extends SuperBO {

    public boolean addUser(MetUserDTO metUser)throws Exception;

    public boolean deleteUser(String metUserID)throws Exception;

    public boolean updateUser(MetUserDTO metUser)throws Exception;

    public MetUserDTO searchUserByID(String metUserID)throws Exception;

    public MetUserDTO searchUserByName(String metUserName)throws Exception;

    public ArrayList<MetUserDTO> getAllUsers()throws Exception;
}
