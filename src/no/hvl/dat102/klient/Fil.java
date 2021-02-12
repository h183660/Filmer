package no.hvl.dat102.klient;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FILMarkivADT;

public class Fil {
	public static void skriveTilFil(FILMarkivADT filmer, String filnavn) {

		final String SKILLE = "#"; // parameter når vi lager metode
		final String FILNAVN = filnavn; // parameter når vi lager metode
		int antall = filmer.antall();

		try {
			// 1 - FileWriter
			FileWriter filSkriver = new FileWriter(FILNAVN, false);

			// 2 - PrintWriter
			PrintWriter utfil = new PrintWriter(filSkriver);

			// 3 - Skriver først ut antall ansatt-info-er på den første linjen
			utfil.println(antall);

			// Hvis vi tar imot en tabell av ansatte, ville vi her lage en løkke der
			// vi for hver ansatt henter ut feltvariable og skriver de ut på samme linje

			// 3 - Skriv postene, felt for felt
			for (Film film : filmer.hentFilmTabell()) {
				if (film != null) {
					utfil.print(film.getFilmnr());
					utfil.print(SKILLE);
					utfil.print(film.getProdusent());
					utfil.print(SKILLE);
					utfil.print(film.getTittel());
					utfil.print(SKILLE);
					utfil.print(film.getAar());
					utfil.print(SKILLE);
					utfil.print(film.getSjanger());
					utfil.print(SKILLE);
					utfil.print(film.getFilmselskap());
					utfil.println();
				}

			}

			// 4 - Lukk filen
			utfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil : " + e);
			System.exit(3);
		}

	}

	public static FILMarkivADT leseFraFil(String filnavn) {

		final String SKILLE = "#"; // kan være parameter når vi lager metode
		final String FILNAVN = filnavn; // parameter når vi lager metode
		Filmarkiv2 filmarkiv = new Filmarkiv2(); // Filmarkiv som skal returneres;

		FileReader filLeser = null;
		BufferedReader innfil = null;

		try {
			// // 1 - FileReader
			filLeser = new FileReader(FILNAVN);
		}

		catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + FILNAVN);
			System.exit(1);
			// Vi kan lage script som kjører programmet fra kommandolinjen
			// og fanger opp returkoden ved System.exit
			//
		}

		try {
			// 2 - BufferedReader
			innfil = new BufferedReader(filLeser);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			filmarkiv = new Filmarkiv2();

			// 4 - Les postene, en hel post om gangen
			String post = innfil.readLine();
			for (int i = 0; i < n; i++) {
				String[] felt = post.split(SKILLE);
				// http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String,
				// int)

				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.finnSjanger(felt[4]);
				String filmselskap = felt[5];

				Film film = new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap);
				filmarkiv.leggTilFilm(film);
				System.out.println(film.toString());

				post = innfil.readLine();
			}

			// 4 - Lukk filen
			innfil.close();
			System.out.println("Fil Lest.");
			return filmarkiv;

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
			return filmarkiv;
		}
	}
}