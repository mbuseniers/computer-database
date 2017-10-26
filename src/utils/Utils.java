package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.CompanyEnum;

public class Utils {

	/**
	 * 		
	 * @param str_date date saisie au format String
	 * @return	Timestamp contenant la date si le format est correct, null sinon
	 */
	/*public static LocalDate convertStringToLocalDate(String str_date) {
	    try {
	      DateFormat formatter;
	      formatter = new SimpleDateFormat("dd/MM/yyyy");
	      Date date = (Date) formatter.parse(str_date);
	      //Timestamp timeStampDate = new Timestamp(date.getTime());

	      return date;
	    } catch (ParseException e) {
	      System.out.println("Mauvaise saisie de la date");
	      return null;
	    }
	 }*/
	
	/**
	 * 	Gere la saisie d'un entier au clavier
	 * @return int avec pour valeur l'entier saisie, ou 0 en cas de mauvaise saisie
	 */
	public static int scanInt() {

		try {
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			return choix;
		} catch (InputMismatchException ime) {
			System.out.println("Valeur saisie non numérique\n" + "ou hors des limites int.");
			return 0;
		}
	}

	/**
	 * 	Gere la selection d'une company
	 * @return int => l'ID de la company choisie
	 */
	public static int chooseCompany() {

		CompanyEnum[] companies = CompanyEnum.values();
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
