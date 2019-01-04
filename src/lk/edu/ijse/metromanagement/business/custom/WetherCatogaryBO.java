package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.WetherCatogaryDTO;

import java.util.ArrayList;

public interface WetherCatogaryBO extends SuperBO {

    public boolean addWetherCatogary(WetherCatogaryDTO wetherCatogary)throws Exception;

    public boolean deleteWetherCatogary(String wetherCatogaryID)throws Exception;

    public boolean updateWetherCatogary(WetherCatogaryDTO wetherCatogary)throws Exception;

    public WetherCatogaryDTO searchWetherCatogary(String wetherCatogaryID)throws Exception;

    public ArrayList<WetherCatogaryDTO> getAllWetherCatogary()throws Exception;

    public ArrayList<String> getCatogaries() throws Exception;
}
