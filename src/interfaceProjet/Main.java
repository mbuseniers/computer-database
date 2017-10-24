package interfaceProjet;

import java.sql.SQLException;
import java.util.Scanner;

import Controllers.ComputerController;
import Controllers.SaisiesController;
import DataAccess.DataAccess;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("Bienvenue sur le projet Computer Database");
		boolean continuer = true;
		ComputerController cc = new ComputerController();

		
		while(continuer)
		{
			System.out.println("Quel action souhaitez vous effectuer ?");
			System.out.println("1 - Lister les Computer");
			System.out.println("2 - Ajouter un Computer");
			System.out.println("3 - Modifier un Computer");
			System.out.println("4 - Supprimer un Computer");
			System.out.println("5 - Quitter");
			
			int choix= SaisiesController.saisieEntier();
			
			
			switch(choix) {
			
			case 1 : 
				System.out.println("Appel liste");
				cc.getComputers();
				break;
				
			case 2 : 
				System.out.println("Appel ajout");
				cc.addComputer();
				break;
				
			case 3 : 
				System.out.println("Appel modif");
				cc.updateComputer();
				break;
				
			case 4 : 
				System.out.println("Appel delete");
				cc.deleteComputer();
				break;
				
			case 5 : 
				continuer = false;
				System.out.println("Bye Bye");
				break;
				
			default : 
				System.out.println("Erreur de saisie");
			
			}
			
			
		}
			

	}

}
