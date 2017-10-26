package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionMySQL;
import mappers.CompanyMapper;
import model.Company;

public class DAOCompany {

	
	Connection conn;
	static DAOCompany DA = new DAOCompany();
	
	private String sqlGetCompanies = "SELECT * FROM company";
	

	private DAOCompany() {
		conn = ConnectionMySQL.getInstance();
	}
	
	public static DAOCompany getInstance()
	{
		return DA;
	}
	
	public ArrayList<Company> getCompanies()
	{
		CompanyMapper cm = CompanyMapper.getInstance();
		ArrayList<Company> listCompanies = new ArrayList<>();
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sqlGetCompanies);
			ResultSet rs = preparedStatement.executeQuery();
	    
			while(rs.next()) {
				listCompanies.add(cm.mappToCompany(rs.getInt(1), rs.getString(2)));
				
			}
			
		    rs.close();
		    preparedStatement.close();
			
		    return listCompanies;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
		
	}
}
