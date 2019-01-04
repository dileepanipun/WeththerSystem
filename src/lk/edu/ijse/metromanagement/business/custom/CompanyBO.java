package lk.edu.ijse.metromanagement.business.custom;

import lk.edu.ijse.metromanagement.business.SuperBO;
import lk.edu.ijse.metromanagement.model.CompanyDTO;

import java.util.ArrayList;

public interface CompanyBO extends SuperBO {

    public boolean addCompany(CompanyDTO company)throws Exception;

    public boolean deleteCompany(String companyID)throws Exception;

    public boolean updateCompany(CompanyDTO company)throws Exception;

    public CompanyDTO searchCompany(String companyID)throws Exception;

    public ArrayList<CompanyDTO> getAllCompany()throws Exception;

    public ArrayList<CompanyDTO> getAllCompanyIds() throws Exception;
}
