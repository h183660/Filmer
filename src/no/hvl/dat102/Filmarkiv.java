package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class Filmarkiv implements FILMarkivADT {
	// Variabler
	private Film[] filmarkiv;
	private int antall;

	// Konstruktører
	public Filmarkiv() {
	}

	public Filmarkiv(int rader) {
		this.filmarkiv = new Film[rader];
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmarkiv;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmarkiv.length) {
			utvidKapasitet();
		}
		filmarkiv[antall] = nyFilm;
		antall++;
		trimTab(filmarkiv, antall);

	}

	// Korter ned tabellen sann det ikke er plass til overs.
	private Film[] trimTab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}

	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[2 * filmarkiv.length];

		for (int i = 0; i < filmarkiv.length; i++) {
			hjelpetabell[i] = filmarkiv[i];
		}
		filmarkiv = hjelpetabell;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (antall == 0) {
			throw new EmptyCollectionException("filmarkiv");
		}
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getFilmnr() == filmnr) {
				filmarkiv[i] = filmarkiv[antall - 1];
				antall--;
				System.out.println(filmnr + " ble slettet");
				trimTab(filmarkiv, antall());
				return true;
			}
		}
		System.out.println(filmnr + " ble ikke funnet.");
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] filmer = new Film[filmarkiv.length];
		int titteler = 0;

		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getTittel().contains(delstreng)) {
				filmer[titteler++] = filmarkiv[i];
			}
		}
		filmer = trimTab(filmer, titteler);
		return filmer;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] filmer = new Film[filmarkiv.length];
		int produsenter = 0;

		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getProdusent().contains(delstreng)) {
				filmer[produsenter++] = filmarkiv[i];
			}
		}
		filmer = trimTab(filmer, produsenter);
		return filmer;
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

}