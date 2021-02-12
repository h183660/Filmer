package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FILMarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Hva er FilmNR?");
		int filmnr = Integer.parseInt(scan.nextLine());

		System.out.println("Hvem er produsenten?");
		String produsent = scan.nextLine();

		System.out.println("Hva er tittelen på filmen?");
		String tittel = scan.nextLine();

		System.out.println("Hvilket år kom filmen ut?");
		int aar = Integer.parseInt(scan.nextLine());

		System.out.println("Hva sjanger er filmen?");
		Sjanger sjanger = Sjanger.finnSjanger(scan.nextLine());

		System.out.println("Hvilket filmselskap lagde filmen?");
		String filmselskap = scan.nextLine();

		Film film = new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap);

		visFilm(film);
		System.out.println("Film Lest");
		return film;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		if (film != null) {
			String s = "FilmNR: " + film.getFilmnr() + " Produsent: " + film.getProdusent() + " Tittel: "
					+ film.getTittel() + " År: " + film.getAar() + " Sjanger: " + film.getSjanger() + " Filmselskap: "
					+ film.getFilmselskap();
			System.out.println(s);
		}

	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma) {
		Scanner scan = new Scanner(System.in);
		String delstreng = scan.nextLine();

		Film[] filmer = filma.soekTittel(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			visFilm(filmer[i]);
		}
		System.out.println("Filmer med " + delstreng + " i tittelen skrevet ut.");

	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FILMarkivADT filma) {
		Scanner scan = new Scanner(System.in);
		String delstreng = scan.nextLine();

		Film[] filmer = filma.soekProdusent(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			visFilm(filmer[i]);
		}
		System.out.println("Filmer produsentert av " + delstreng + " skrevet ut.");
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FILMarkivADT filma) {
		System.out.println("Antall Filmer Totalt: " + filma.antall());

		for (Sjanger sjanger : Sjanger.values()) {
			System.out.println("Antall " + sjanger + " filmer: " + filma.antallSjanger(sjanger));
		}

		System.out.println("Statistikk skrevet ut.");
	}

	public void skrivUtArkiv(FILMarkivADT filma) {
		Film[] filmer = filma.hentFilmTabell();
		for (Film film : filmer) {
			visFilm(film);
		}
		System.out.println("Arkiv skrevet ut.");
	}

	public void lagreFil(FILMarkivADT filma) {
		Scanner scan = new Scanner(System.in);
		String filnavn = scan.nextLine();

		Fil.skriveTilFil(filma, filnavn);
		System.out.println("Skrevet til " + filnavn);

	}

}