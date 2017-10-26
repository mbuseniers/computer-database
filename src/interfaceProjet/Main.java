package interfaceProjet;

import java.sql.SQLException;
import Utils.Utils;
import services.CompanyService;
import services.ComputerService;

public class Main {

	public static void main(String[] args) throws SQLException {

		System.out.println("Bienvenue sur le projet Computer Database");
		boolean continuer = true;
		ComputerService ComputerCtrl = new ComputerService();
		CompanyService CompanyCtrl = new CompanyService(); 

		
		while(continuer)
		{
			System.out.println("Quel action souhaitez vous effectuer ?");
			System.out.println("1 - Lister les Computer");
			System.out.println("2 - Ajouter un Computer");
			System.out.println("3 - Modifier un Computer");
			System.out.println("4 - Supprimer un Computer");
			System.out.println("5 - Afficher les Company");
			System.out.println("6 - Quitter");
			
			int choix= Utils.scanInt();
			
			
			switch(choix) {
			
			case 1 : 
				ComputerCtrl.getComputers();
				break;
				
			case 2 : 
				ComputerCtrl.addComputer();
				break;
				
			case 3 : 
				ComputerCtrl.updateComputer();
				break;
				
			case 4 : 
				ComputerCtrl.deleteComputer();
				break;
				
			case 5 :
				CompanyCtrl.getCompanies();
				break;
				
			case 6 : 
				continuer = false;
				System.out.println("Bye Bye");
				break;
				
			default : 
				System.out.println("Erreur de saisie");
				break;
			
			}
			
			
		}
			

	}

}
