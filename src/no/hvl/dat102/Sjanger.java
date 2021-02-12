package no.hvl.dat102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI, ANIMATION, HORROR, ADVENTURE, CRIME , MYSTERY;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}

		}
		return sjang;

	}
	

}