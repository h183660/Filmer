package no.hvl.dat102;

public class Film {

	// Variabler
	private int filmnr;
	private String produsent;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;

	// Tom Konstruktør
	public Film() {

	}

	// Full Kontruktør
	public Film(int filmnr,
				String produsent,
				String tittel, 
				int aar, Sjanger sjanger, 
				String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	// Metoder
	public String toString() {
		return filmnr + " " + produsent + " " + tittel + " " + aar + " " + sjanger + " " + filmselskap;
	}

	// Get/Set Metoder
	public int getFilmnr() {
		return filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public int getAar() {
		return aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
}