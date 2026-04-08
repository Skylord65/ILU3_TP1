package testsFonctionnels;

import carte.*;

public class TestJeuDeCarte {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageJeuDeCarte());
		
		//System.out.println("Test checkCount : " + jeu.checkCount());
	}
}