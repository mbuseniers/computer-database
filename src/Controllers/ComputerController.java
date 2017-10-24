package Controllers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import DataAccess.DataAccess;
import Entities.Company;
import Entities.Computer;

public class ComputerController {

	DataAccess da;
	
	public ComputerController()
	{
		da = DataAccess.getInstance();
		da.connexion();
	}

	
	public void addComputer() 
	{
		String nom;
		Date date_intro;
		Date date_fin;
		int id_company;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le nom du Computer ");
		nom = sc.nextLine();
		
		/* Saisie dates */
		
		id_company = SaisiesController.choixCompany();

		
		da.addComputer(new Computer(nom,null,null,id_company));
		

	}
	
	public void getComputers() throws SQLException
	{

		da.getComputers();
	}
	
	public void updateComputer()
	{
		System.out.println("Saisir l'ID du Computer à modifier");
		int id=SaisiesController.saisieEntier();

		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le nouveau nom du Computer ");
		String nom = sc.nextLine();
		
		int id_company = SaisiesController.choixCompany();

		da.updateComputer(id, new Computer(nom,null,null,id_company));
		
	}
	
	public void deleteComputer()
	{
		System.out.println("Saisir l'ID du Computer à supprimer");
		int id=SaisiesController.saisieEntier();
		
		da.deleteComputer(id);


	}
}
