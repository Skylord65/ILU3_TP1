package jeu;

import carte.Carte;

public class Sabot {
	private Carte[] carte;
	private int nbCartes;
	
	public Sabot(Carte[] carte) {
		this.carte = carte;
		this.nbCartes = carte.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte newCarte) {
		for(int i = 0; i<carte.length; i++) {	
			if (carte[i]!=null) {
				carte[i] = newCarte;
				nbCartes++;
			}
		}
	}
}
