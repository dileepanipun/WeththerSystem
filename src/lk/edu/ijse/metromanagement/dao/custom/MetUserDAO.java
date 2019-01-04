package lk.edu.ijse.metromanagement.dao.custom;

import lk.edu.ijse.metromanagement.dao.CrudDAO;
import lk.edu.ijse.metromanagement.entity.MetUser;

public interface MetUserDAO extends CrudDAO<MetUser, String> {

    public MetUser searchByUserName(String userName) throws Exception;
}
