package services;

import java.sql.SQLException;

import DataAccess.DAOCompany;
import DataAccess.DAOComputer;

public class CompanyService {

	DAOCompany da;
	
	public CompanyService()
	{
		da = DAOCompany.getInstance();
	}
	
	public void getCompanies() throws SQLException
	{
		da.getCompanies();
	}
	
}
