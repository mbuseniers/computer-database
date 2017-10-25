package Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Company;

public class Utils {

	
	public static Timestamp convertStringToTimestamp(String str_date) {
	    try {
	      DateFormat formatter;
	      formatter = new SimpleDateFormat("dd/MM/yyyy");
	      Date date = formatter.parse(str_date);
	      Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Mauvaise saisie de la date");
	      return null;
	    }
	 }
	
	public static int saisieEntier() {

		try {
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			return choix;
		} catch (InputMismatchException ime) {
			System.out.println("Valeur saisie non numérique\n" + "ou hors des limites int.");
			return 0;
		}
	}

	public static int choixCompany() {

		Company[] companies = Company.values();
		boolean valide = false;
		int choix=0;

		do {
			try {

				for (int i = 1; i < companies.length; i++) {
					System.out.println(i + " => " + companies[i]);

				}

				System.out.println("Saisir l'ID du fabriquant entre 1 et " + (companies.length - 1));

				Scanner sc = new Scanner(System.in);
				choix = sc.nextInt();

				if (choix > 0 && choix <= companies.length) {
					valide = true;
				} else {
					System.out.println("Mauvaise saisie de l'ID du fanbriquant");
				}

				// sc.close();
			} catch (InputMismatchException ime) {
				System.out.println("Valeur saisie non numérique\n" + "ou hors des limites int.");
			}

		} while (!valide);

		return choix;
	}
}
