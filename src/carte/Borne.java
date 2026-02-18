package carte;

public class Borne extends Carte {

	private int km;
	
	public Borne(int km) {
		km = this.km; 
	}
	
	public String toString() {
		return "Carte " + km + " bornes";
	}
}
