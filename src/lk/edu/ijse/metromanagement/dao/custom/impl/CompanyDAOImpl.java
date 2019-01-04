package lk.edu.ijse.metromanagement.dao.custom.impl;

import lk.edu.ijse.metromanagement.dao.CrudUtil;
import lk.edu.ijse.metromanagement.dao.custom.CompanyDAO;
import lk.edu.ijse.metromanagement.entity.Company;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CompanyDAOImpl implements CompanyDAO {
    @Override
    public boolean save(Company company) throws Exception {
        return CrudUtil.executeUpdate(
                "Insert into company values(?,?,?,?)",
                company.getCompanyID(),
                company.getName(),
                company.getAddress(),
                company.getTelephoneNo()
        ) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("Delete from company where companyID=?", s) > 0;
    }

    @Override
    public boolean update(Company entitiy) throws Exception {
        return CrudUtil.executeUpdate("UPDATE company SET cmpName=?,address=?,telephoneNo=? WHERE companyID=?",
                entitiy.getName(),
                entitiy.getAddress(),
                entitiy.getTelephoneNo(),
                entitiy.getCompanyID()
        ) > 0;
    }

    @Override
    public Company search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from company where companyID=?", id);
        if (rst.next()){
            return new Company(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Company> getAll() throws Exception {
        ArrayList<Company> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from company");
        while (rst.next()){
            company.add(new Company(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return company;
    }
}
