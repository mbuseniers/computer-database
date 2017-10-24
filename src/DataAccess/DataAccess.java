package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import com.mysql.jdbc.Statement;

import Entities.Computer;

public class DataAccess {

	static DataAccess DA = new DataAccess();
	
	Connection conn = null;

	
	private DataAccess() {
	}
	
	public static DataAccess getInstance()
	{
		return DA;
	}
	
	public void connexion()
	{
		System.out.println("Connexion à la base");
		
		
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db","admincdb" ,"qwerty1234");

		    // Do something with the Connection

		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		/*finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		

	}
	
	public void addComputer(Computer computer) 
	{
		
		Statement stmt = null;
		//ResultSet rs = null;
		
		    try {
				stmt = (Statement) conn.createStatement();
				String sql = "INSERT INTO computer (id, name, introduced, discontinued, company_id)"
						+ "VALUES ("
						+"NULL"
						+",'"
						+computer.getName()
						+"',"
						+computer.getDate_introduced()
						+", "
						+computer.getDate_discontinued()
						+", "
						+computer.getId_company()
						//+"( SELECT id from company WHERE name='Apple' ) "
						+");";
				
				System.out.println(computer.getId_company());
				System.out.println(sql);
				 int result = stmt.executeUpdate(sql);
			

				 
				 if(result ==1) System.out.println("Ajout OK");

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    
	}	
	
	
	public void getComputers() throws SQLException
	{
		
			System.out.println("get computer dao ");
	
			Statement stmt = null;
			ResultSet rs = null;
		
		    stmt = (Statement) conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM computer");


		    if (stmt.execute("SELECT * FROM computer")) {
		        rs = stmt.getResultSet();
		    }
		    
		    while (rs.next()) {
		    	int id = rs.getInt(1); 
		    	String nom = rs.getString(2); 
		    	//Date date_inc = rs.getDate(3);
		    	//Date date_des = rs.getDate(4);
		    	int id_company = rs.getInt(5); 
		    	int row = rs.getRow(); 
		    	System.out.println("id : "+id+" nom : "+nom+ 
		    	//" date_inc : "+date_inc+" date_des : "+date_des+ 
		    	" id_company " +id_company); 	         
		    }
		    
		    	
	}
	
	public void updateComputer(int id,Computer computer)
	{
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			String sql = "UPDATE computer SET name = '" + computer.getName() +"' , company_id = '"+ computer.getId_company()+"'WHERE id = " + id;
		
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
				 
			if(result ==1) System.out.println("Update OK");

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    
	}
	
	public void deleteComputer(int id)
	{
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			String sql = "DELETE FROM computer WHERE id = " + id;
		
			int result = stmt.executeUpdate(sql);
				 
			if(result ==1) System.out.println("Suppression OK");

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    
	}
	
	
	public void deconnexion()
	{
		System.out.println("Deconnexion de la base");
	}
}
