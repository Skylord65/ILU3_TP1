package carte;

public class JeuDeCartes {

	private Carte[] carte;
	private Configuration[] configurations;
	
	public JeuDeCartes() {
		
		for (int i = 0; i<19; i++) {
			configurations[i]= new Configuration(carte, i)
		}
	}
	
	private class Configuration {
		private int nbExemplaire;
		private Carte carte;
		private Configuration(Carte carte, int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
		}
		public int getNbExemplaire() {
			return nbExemplaire;
		}
		public Carte getCarte() {
			return carte;
		}
	}

	public Carte[] donnerCartes() {
		for(int i)
	}
	
	public String AffichageJeuDeCarte() {
		return " ";
	}
	
	
}
