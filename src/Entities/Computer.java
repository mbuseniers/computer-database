package Entities;

import java.sql.Date;

public class Computer {

	private int id;
	private String name;
	private Date date_introduced;
	private Date date_discontinued;
	private int id_company;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_introduced() {
		return date_introduced;
	}
	public void setDate_introduced(Date date_introduced) {
		this.date_introduced = date_introduced;
	}
	public Date getDate_discontinued() {
		return date_discontinued;
	}
	public void setDate_discontinued(Date date_discontinued) {
		this.date_discontinued = date_discontinued;
	}
	public int getId_company() {
		return id_company;
	}
	public void setId_company(int id_company) {
		this.id_company = id_company;
	}
	
	public Computer(String name, Date date_introduced, Date date_discontinued, int id_company) {
		super();
		this.name = name;
		this.date_introduced = date_introduced;
		this.date_discontinued = date_discontinued;
		this.id_company = id_company;
	}

}
