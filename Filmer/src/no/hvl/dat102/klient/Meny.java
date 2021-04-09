package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.adt.FILMarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filma;

	public Meny() {
		tekstgr = new Tekstgrensesnitt();
	}

	public void start() {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		System.out.println("Skriv navn på fil som skal leses:");
		filma = Fil.leseFraFil(scan.nextLine());
		do {

			System.out.println("-------------------");
			System.out.println("|Hva vil du gjøre?|");
			System.out.println("-------------------");

			System.out.println("1: Legge til en ny film i arkivet.");
			System.out.println("2: Skrive ut alle Filmer med en spesiell delstreng i tittelen.");
			System.out.println("3: Skriver ut alle Filmer av en produsent.");
			System.out.println("4: Skriv ut statestikk om filmarkivet.");
			System.out.println("5: Skriv ut hele arkivet.");
			System.out.println("9: Lagre Filmarkivet til en tekstfil.");
			System.out.println("0: Exit.");

			int valg = scan.nextInt();
			switch (valg) {
			case 1:
				System.out.println("Legger til ny film i arkivet:");
				filma.leggTilFilm(tekstgr.lesFilm());
				break;

			case 2:
				System.out.println("Hva delstreng i tittelen vil du gi som parameter?");
				tekstgr.skrivUtFilmDelstrengITittel(filma);
				break;

			case 3:
				System.out.println("Hvilken produsent vil du søke etter?");
				tekstgr.skrivUtFilmProdusent(filma);
				break;

			case 4:
				tekstgr.skrivUtStatistikk(filma);
				break;

			case 5:
				tekstgr.skrivUtArkiv(filma);
				break;

			case 9:
				System.out.println("Hva skal filen hete?");
				tekstgr.lagreFil(filma);
				break;

			case 0:
				System.out.println("Closing program");
				run = false;
				break;

			default:
				System.out.println("Ukjent komando prøv igjen.");
			}
		} while (run);
		scan.close();
	}
}