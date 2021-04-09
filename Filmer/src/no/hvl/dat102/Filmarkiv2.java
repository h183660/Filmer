package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class Filmarkiv2 implements FILMarkivADT {
	private int antall;
	private LinearNode<Film> start;
	// OBS! Ingen referanse til siste, kun start … /* Klassen skal ha de samme
	// operasjoner som for Filmarkiv i øving 2, men pass på at implementeringen av
	// alle metoder blir tilpasset den nye strukturen. */

	// Tom Konstruktør
	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public Film[] hentFilmTabell() {
		Film[] filmTabell = new Film[antall];
		LinearNode<Film> denne = start;
		int antNyTab = 0;
		for (int i = 0; i < antall; i++) {
			if (denne.getElement() != null) {
				filmTabell[antNyTab++] = denne.getElement();
				denne = denne.getNeste();
			}
		}
		trimTab(filmTabell, antNyTab);
		return filmTabell;
	}

	// Samme TrimTab som før
	private Film[] trimTab(Film[] tab, int n) { // n er antall elementer
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		// Konstruktør
		LinearNode<Film> nyFilmNode = new LinearNode<Film>(nyFilm);
		// Setter start til den nye noden sin neste,
		nyFilmNode.setNeste(start);
		// Setter nye Noden til start.
		start = nyFilmNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean filmFunnet = false;
		if (antall == 0) {
			throw new EmptyCollectionException("filmarkiv2");
		}
		// Sjekker om det er den første noden som skal slettes,
		// hvis ikke sjekker den resten.
		if (start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
			antall--;
			return true;
		}
		// Lager temp noder for å bruke den tidligere noden
		// når evt node blir funnet og skal slettes.
		LinearNode<Film> forgjenger = start;
		LinearNode<Film> denne = forgjenger.getNeste();
		// Går gjennom den hvert element i den kjedete strukturen
		// for å se om filmen er i arkivet
		while (!filmFunnet && denne.getNeste() != null) {
			if (filmnr == denne.getElement().getFilmnr()) {
				// Kommer du her er filmen funnet i kjeden
				forgjenger.setNeste(denne.getNeste());
				antall--;
			}
		}
		return filmFunnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> denne = start;
		Film[] tittelTab = new Film[antall];
		int antTittel = 0;
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getTittel().contains(delstreng)) {
				tittelTab[antTittel++] = denne.getElement();
			}
			denne = denne.getNeste();

		}
		return trimTab(tittelTab, antTittel);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> denne = start;
		Film[] prodTab = new Film[antall];
		int antProd = 0;
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getProdusent().contains(delstreng)) {
				prodTab[antProd++] = denne.getElement();
			}
			denne = denne.getNeste();

		}
		return trimTab(prodTab, antProd);
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		LinearNode<Film> denne = start;
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getSjanger() == (sjanger)) {
				antallSjanger++;
			}
			denne = denne.getNeste();
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

}
