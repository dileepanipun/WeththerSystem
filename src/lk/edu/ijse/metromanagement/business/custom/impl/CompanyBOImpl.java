package lk.edu.ijse.metromanagement.business.custom.impl;

import lk.edu.ijse.metromanagement.business.custom.CompanyBO;
import lk.edu.ijse.metromanagement.dao.DAOFactory;
import lk.edu.ijse.metromanagement.dao.custom.CompanyDAO;
import lk.edu.ijse.metromanagement.entity.Company;
import lk.edu.ijse.metromanagement.model.CompanyDTO;

import java.util.ArrayList;

public class CompanyBOImpl implements CompanyBO {

    private static CompanyDAO companyDAO;

    public CompanyBOImpl() {
        companyDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.COMPANY);
    }

    @Override
    public boolean addCompany(CompanyDTO company) throws Exception {
        return companyDAO.save(new Company(
                company.getCompanyID(),
                company.getName(),
                company.getAddress(),
                company.getTelephoneNo()
                ));
    }

    @Override
    public boolean deleteCompany(String companyID) throws Exception {
        return companyDAO.delete(companyID);
    }

    @Override
    public boolean updateCompany(CompanyDTO company) throws Exception {
        return companyDAO.update(new Company(
                company.getCompanyID(),
                company.getName(),
                company.getAddress(),
                company.getTelephoneNo()
        ));
    }

    @Override
    public CompanyDTO searchCompany(String companyID) throws Exception {
        Company company = companyDAO.search(companyID);
        return new CompanyDTO(
                company.getCompanyID(),
                company.getName(),
                company.getAddress(),
                company.getTelephoneNo()
        );
    }

    @Override
    public ArrayList<CompanyDTO> getAllCompany() throws Exception {
        ArrayList<CompanyDTO> dtos = new ArrayList<>();
        ArrayList<Company> companies = companyDAO.getAll();
        for (Company company: companies){
            dtos.add(new CompanyDTO(
                    company.getCompanyID(),
                    company.getName(),
                    company.getAddress(),
                    company.getTelephoneNo()
            ));
        }
        return dtos;
    }

    @Override
    public ArrayList<CompanyDTO> getAllCompanyIds() throws Exception {

        ArrayList<Company> companyId=companyDAO.getAll();
        ArrayList<CompanyDTO> dtos = new ArrayList<>();

        for (Company e : companyId){
            dtos.add(new CompanyDTO(e.getCompanyID(), e.getName()));
        }
        return dtos;
    }
}
