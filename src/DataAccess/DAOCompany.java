package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Statement;

import Jdbc.ConnectionMySQL;
import Utils.Page;

public class DAOCompany {

	
	Connection conn;
	static DAOCompany DA = new DAOCompany();
	

	private DAOCompany() {
		conn = ConnectionMySQL.getInstance();
	}
	
	public static DAOCompany getInstance()
	{
		return DA;
	}
	
	public void getCompanies() throws SQLException
	{
		
		Statement stmt = null;
		ResultSet rs = null;
	
	    stmt = (Statement) conn.createStatement();
	    rs = stmt.executeQuery("SELECT * FROM company");


	    if (stmt.execute("SELECT * FROM company")) {
	        rs = stmt.getResultSet();
	    }
	    
	    
	    Page.doCompanyPagination(rs);
	    rs.close();
	    stmt.close();
		
		
	}
}
