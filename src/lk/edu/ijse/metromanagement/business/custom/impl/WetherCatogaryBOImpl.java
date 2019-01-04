package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.WetherCatogaryBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.WetherCatogaryDAO;
import lk.edu.ijse.metromanagement.entity.WetherCatogary;
import lk.edu.ijse.metromanagement.model.WetherCatogaryDTO;

import java.util.ArrayList;

public class WetherCatogaryBOImpl implements WetherCatogaryBO {

    private WetherCatogaryDAO wetherCatogaryDAO;

    public WetherCatogaryBOImpl() {
        wetherCatogaryDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.WETHER_CATOGARY);
    }

    @Override
    public boolean addWetherCatogary(WetherCatogaryDTO wetherCatogary) throws Exception {
        return wetherCatogaryDAO.save(new WetherCatogary(
                wetherCatogary.getCatogaryID(),
                wetherCatogary.getcTypes()
        ));
    }

    @Override
    public boolean deleteWetherCatogary(String wetherCatogaryID) throws Exception {
        return wetherCatogaryDAO.delete(wetherCatogaryID);
    }

    @Override
    public boolean updateWetherCatogary(WetherCatogaryDTO catogary) throws Exception {
        return wetherCatogaryDAO.update(new WetherCatogary(
                catogary.getCatogaryID(),
                catogary.getcTypes()
        ));
    }

    @Override
    public WetherCatogaryDTO searchWetherCatogary(String wetherCatogaryID) throws Exception {
        WetherCatogary search = wetherCatogaryDAO.search(wetherCatogaryID);
        return new WetherCatogaryDTO(
                search.getCatogaryID(),
                search.getcTypes()
        );
    }

    @Override
    public ArrayList<WetherCatogaryDTO> getAllWetherCatogary() throws Exception {
        ArrayList<WetherCatogary> catogaries = wetherCatogaryDAO.getAll();
        ArrayList<WetherCatogaryDTO> dtos = new ArrayList<>();
        for (WetherCatogary e : catogaries){
            dtos.add(new WetherCatogaryDTO(
                    e.getCatogaryID(),
                    e.getcTypes()
            ));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getCatogaries() throws Exception {
        ArrayList<WetherCatogary> catogaries = wetherCatogaryDAO.getAll();
        ArrayList<String> dtos = new ArrayList<>();
        for (WetherCatogary e : catogaries) {
            dtos.add(e.getcTypes());
        }
        return dtos;
    }
}
