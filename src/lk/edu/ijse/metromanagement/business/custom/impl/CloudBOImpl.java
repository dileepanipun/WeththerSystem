package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.CloudBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.CloudDAO;
import lk.edu.ijse.metromanagement.entity.Cloud;
import lk.edu.ijse.metromanagement.model.CloudDTO;

public class CloudBOImpl implements CloudBO {

    private static CloudDAO cloudDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CLOUD);

    @Override
    public CloudDTO searchCloud(String cloudID) throws Exception {
        Cloud search = cloudDAO.search(cloudID);
        return new CloudDTO(
                search.getCloudID(),
                search.getLcAmount(),
                search.getLcFrom(),
                search.getLcDirection(),
                search.getMcAmount(),
                search.getMcFrom(),
                search.getMcDirection(),
                search.getHcAmount(),
                search.getHcFrom(),
                search.getHcDirection(),
                search.getSgAmount(),
                search.getSgForm(),
                search.getSgHeight(),
                search.getTotalAmount(),
                search.getWetherID()
        );
    }
}
