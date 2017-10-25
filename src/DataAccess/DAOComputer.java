package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Entities.Computer;
import Jdbc.ConnectionMySQL;
import Utils.Page;

public class DAOComputer {
	
	Connection conn;
	static DAOComputer DA = new DAOComputer();
	

	private DAOComputer() {
		conn = ConnectionMySQL.getInstance();
	}
	
	public static DAOComputer getInstance()
	{
		return DA;
	}
	
	
	
	public void addComputer(Computer computer) 
	{
		
		
		    try {
		    	

		    	String StrDateInc;
		    	String StrDateDec;

		    	
		    	if(computer.getDate_introduced() != null) StrDateInc = "'" + computer.getDate_introduced( )+ "'";
		    	else StrDateInc = null;
		    	
		    	if(computer.getDate_discontinued() != null) StrDateDec = "'" + computer.getDate_discontinued( )+ "'";
		    	else StrDateDec = null;
		    	
				Statement stmt = (Statement) conn.createStatement();
				String sql = "INSERT INTO computer (id, name, introduced, discontinued, company_id)"
						+ "VALUES ("
						+"NULL"
						+",'"
						+computer.getName()
						+"',"
						+StrDateInc
						+","
						+StrDateDec
						+", "
						+computer.getId_company()
						+");";

				 int result = stmt.executeUpdate(sql);
				 
				 if(result ==1) System.out.println("Ajout OK");
				 stmt.close();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    
	}	
	
	
	public void getComputers() throws SQLException
	{
		
	
			Statement stmt = null;
			ResultSet rs = null;
		
		    stmt = (Statement) conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM computer");


		    if (stmt.execute("SELECT * FROM computer")) {
		        rs = stmt.getResultSet();
		    }
		    
		    Page.doComputerPagination(rs);
		    rs.close();
		    stmt.close();
		    
		    	
	}
	
	public void updateComputer(int id,Computer computer)
	{
		Statement stmt = null;
		
		try {
			
			String StrDateInc;
	    	String StrDateDec;

	    	
	    	if(computer.getDate_introduced() != null) StrDateInc = "'" + computer.getDate_introduced( )+ "'";
	    	else StrDateInc = null;
	    	
	    	if(computer.getDate_discontinued() != null) StrDateDec = "'" + computer.getDate_discontinued( )+ "'";
	    	else StrDateDec = null;
			
			stmt = (Statement) conn.createStatement();
			String sql = "UPDATE computer SET name = '" + computer.getName() +"' , introduced = " + StrDateInc + " , discontinued = " + StrDateDec +" , company_id = "+ computer.getId_company()+" WHERE id = " + id;
							
			int result = stmt.executeUpdate(sql);
				 
			if(result ==1) System.out.println("Update OK");
			stmt.close();
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	}
	
	public void deleteComputer(int id)
	{
		
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "DELETE FROM computer WHERE id = " + id;
		
			int result = stmt.executeUpdate(sql);
				 
			if(result ==1) System.out.println("Suppression OK");
			stmt.close();
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	

}
