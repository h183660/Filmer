package no.hvl.dat102.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.Sjanger;

class Filmarkiv2Test {

	private Filmarkiv2 filmer;

	// Filmer
	private Film film0 = new Film(1, "Christopher Nolan", "Interstellar", 2014, Sjanger.ADVENTURE,
			"Warner Bros. Pictures");
	private Film film1 = new Film(2, "David Fincher", "Se7en", 1995, Sjanger.CRIME, "New Line Cinema");
	private Film film2 = new Film(3, "Pete Dicter", "Monsters, Inc.", 2001, Sjanger.ANIMATION, "Pixar");
	private Film film3 = new Film(4, "Quentin Tarantino", "Django Unchained", 2012, Sjanger.DRAMA, "Columbia Pictures");
	private Film film4 = new Film(5, "Denis Villeneuve", "Blade Runner 2049", 2017, Sjanger.ACTION,
			"Warner Bros. Pictures");
	private Film film5 = new Film(6, "Bong Joon Ho", "Parasite", 2019, Sjanger.DRAMA, "Neon");
	private Film film6 = new Film(7, "Martin Scorsese", "The Departed", 2006, Sjanger.DRAMA, "Warner Bros. Pictures");
	private Film film7 = new Film(8, "Damien Chazelle", "La La Land", 2016, Sjanger.DRAMA, "Summit");
	private Film film8 = new Film(9, "David Fincher", "Gone Girl", 2014, Sjanger.DRAMA, "20th Century Fox");
	private Film film9 = new Film(10, "Andrew Stanton", "WALL-E", 2008, Sjanger.ANIMATION, "Pixar");

	/**
	 * Lager et nytt filmarkiv for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		filmer = new Filmarkiv2();
	}

	/**
	 * Test på at et nytt arkiv er tomt.
	 */
	@Test
	public void nyFilmArkivErTomTest() {
		assertTrue(filmer.antall() == 0);
	}

	/**
	 * Test på at et arkiv med noen filmer ikke er tom.
	 */
	@Test
	public final void erIkkeTomTest() {
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		assertFalse(filmer.antall() == 0);
	}

	/**
	 * Test på at Arkivet tar imot og kan slette flere elementer.
	 */
	@Test
	public final void innOgUtFilmerTest() {
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertTrue(filmer.slettFilm(film0.getFilmnr()));
		assertTrue(filmer.slettFilm(film1.getFilmnr()));
		assertTrue(filmer.slettFilm(film2.getFilmnr()));
		assertTrue(filmer.slettFilm(film3.getFilmnr()));
		assertTrue(filmer.slettFilm(film4.getFilmnr()));
		assertTrue(filmer.slettFilm(film5.getFilmnr()));
		assertTrue(filmer.slettFilm(film6.getFilmnr()));
		assertTrue(filmer.slettFilm(film7.getFilmnr()));
		assertTrue(filmer.slettFilm(film8.getFilmnr()));
		assertTrue(filmer.slettFilm(film9.getFilmnr()));
	}

	/**
	 * Test på inn og ut med duplikater
	 */
	@Test
	public final void innOgUtMedDuplikaterTest() {
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		try {
			assertTrue(filmer.slettFilm(film0.getFilmnr()));
			assertTrue(filmer.slettFilm(film1.getFilmnr()));
			assertTrue(filmer.slettFilm(film2.getFilmnr()));
			assertTrue(filmer.slettFilm(film3.getFilmnr()));
			assertTrue(filmer.slettFilm(film4.getFilmnr()));
			assertTrue(filmer.slettFilm(film4.getFilmnr()));
			assertTrue(filmer.slettFilm(film5.getFilmnr()));
			assertTrue(filmer.slettFilm(film6.getFilmnr()));
			assertTrue(filmer.slettFilm(film7.getFilmnr()));
			assertTrue(filmer.slettFilm(film8.getFilmnr()));

		} catch (EmptyCollectionException e) {
			fail("failed unexpectedly " + e.getMessage());
		}

	}

	/**
	 *  
	 */
	@Test
	public void sletteFraTomtArkivTest() {

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			filmer.slettFilm(1);
		});
	}

	/**
	 * Test på at et arkiv holder styr på antall elementer.
	 */
	@Test
	public final void antallTest() {
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		assertEquals(5, filmer.antall());
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertEquals(10, filmer.antall());
	}

	/**
	 * Test på at sjanger søke algoritmen funker.
	 */
	@Test
	public final void antallSjangerTest() {
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertEquals(5, filmer.antallSjanger(Sjanger.DRAMA));
		assertEquals(1, filmer.antallSjanger(Sjanger.ACTION));
		assertEquals(2, filmer.antallSjanger(Sjanger.ANIMATION));

	}

	/**
	 * Test på at et arkiv holder styr på antall elementer.
	 */
	@Test
	public final void hentFilmTabTest() {
		Film[] helFilmTab = new Film[10];
		helFilmTab[0] = film0;
		helFilmTab[1] = film1;
		helFilmTab[2] = film2;
		helFilmTab[3] = film3;
		helFilmTab[4] = film4;
		helFilmTab[5] = film5;
		helFilmTab[6] = film6;
		helFilmTab[7] = film7;
		helFilmTab[8] = film8;
		helFilmTab[9] = film9;
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertArrayEquals(helFilmTab, filmer.hentFilmTabell());
	}

	/**
	 * Test på at tittel søk algoritmen funker.
	 */
	@Test
	public final void soekTittelTest() {
		Film[] soekTittelTest = new Film[6];
		soekTittelTest[5] = film0;
		soekTittelTest[4] = film3;
		soekTittelTest[3] = film4;
		soekTittelTest[2] = film5;
		soekTittelTest[1] = film6;
		soekTittelTest[0] = film7;
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertArrayEquals(soekTittelTest, filmer.soekTittel("a"));
	}

	/**
	 * Test på at produsent søk algoritmen funker.
	 */
	@Test
	public final void soekProdusentTest() {
		Film[] soekProdusentTest = new Film[1];
		soekProdusentTest[0] = film0;
		filmer.leggTilFilm(film0);
		filmer.leggTilFilm(film1);
		filmer.leggTilFilm(film2);
		filmer.leggTilFilm(film3);
		filmer.leggTilFilm(film4);
		filmer.leggTilFilm(film5);
		filmer.leggTilFilm(film6);
		filmer.leggTilFilm(film7);
		filmer.leggTilFilm(film8);
		filmer.leggTilFilm(film9);
		assertArrayEquals(soekProdusentTest, filmer.soekProdusent("Nolan"));
	}

}