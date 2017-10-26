package services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Scanner;

import DataAccess.DAOComputer;
import Entities.Company;
import Entities.Computer;
import Utils.Utils;

public class ComputerService {

	DAOComputer da;
	
	public ComputerService()
	{
		da = DAOComputer.getInstance();
	}

	
	public void addComputer()
	{
		String nom;
		int id_company;
		
		/* Saisie nom pc*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le nom du Computer ");
		nom = sc.nextLine();
		
		/* Saisie dates */
		System.out.println("Saisir la date de mise en marche (format dd/MM/yyyy)");
		String StrDate_inc = sc.nextLine();
		Timestamp ts_inc = Utils.convertStringToTimestamp(StrDate_inc);
		
		System.out.println("Saisir la date de fin de marche (format dd/MM/yyyy)");
		String StrDate_dis = sc.nextLine();
		Timestamp ts_des = Utils.convertStringToTimestamp(StrDate_dis);
		
		/* Saisie company */
		id_company = Utils.chooseCompany();

		
		da.addComputer(new Computer(nom,ts_inc,ts_des,id_company));
		
	}
	
	public void getComputers() throws SQLException
	{

		da.getComputers();
	}
	
	public void updateComputer()
	{
		System.out.println("Saisir l'ID du Computer à modifier");
		int id=Utils.scanInt();

		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le nouveau nom du Computer ");
		String nom = sc.nextLine();
		
		/* Saisie dates */
		
		System.out.println("Saisir la date de mise en marche (format dd/MM/yyyy)");
		String StrDate_inc = sc.nextLine();
		
		Timestamp ts_inc = Utils.convertStringToTimestamp(StrDate_inc);
		
		
		System.out.println("Saisir la date de fin de marche (format dd/MM/yyyy)");
		String StrDate_dis = sc.nextLine();
		
		Timestamp ts_des = Utils.convertStringToTimestamp(StrDate_dis);
		
		int id_company = Utils.chooseCompany();

		da.updateComputer(id, new Computer(nom,ts_inc,ts_des,id_company));
		
	}
	
	public void deleteComputer()
	{
		System.out.println("Saisir l'ID du Computer à supprimer");
		int id=Utils.scanInt();
		
		da.deleteComputer(id);


	}
	

}
