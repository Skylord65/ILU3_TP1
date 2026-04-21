package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import carte.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] carte;
	private int nbCartes;
	private int nbOperation = 0;
	
	public Sabot(Carte[] carte) {
		this.carte = carte;
		this.nbCartes = carte.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public Carte[] ajouterCarte(Carte carteAjoute) {
        for (int i = 0; i < carte.length; i++) {
            if (carte[i] == null) {
                carte[i] = carteAjoute;
                nbCartes++;
                nbOperation++;
                return carte;
            }
        }
        throw new IllegalStateException("Capacité maximale atteinte : impossible d'ajouter la carte.");
    }
	
	public Carte piocher() {
        Iterator<Carte> iter = iterator();
        if (!iter.hasNext()) {
            throw new IllegalStateException("Le sabot est vide, impossible de piocher.");
        }
        Carte carte = iter.next();
        iter.remove();
        return carte;
    }
	
	private class Iterateur implements Iterator<Carte> {
        private int indiceIterateur = 0;
        private int nbOperationReference = nbOperation;
        private boolean nextEffectue = false;

        @Override
        public boolean hasNext() {
            while (indiceIterateur < carte.length && carte[indiceIterateur] == null) {
            	indiceIterateur++;
            }
            return indiceIterateur < carte.length;
        }

        @Override
        public Carte next() {
        	verificationConcurrence();
            if (hasNext()) {
            	Carte newCarte = carte[indiceIterateur];
            	nextEffectue = true;
            	indiceIterateur++;
                return newCarte;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
        	verificationConcurrence();
            if (!nextEffectue) {
                throw new IllegalStateException("remove() ne peut être appelé qu'après next().");
            }

            carte[indiceIterateur - 1] = null;
            nbCartes--;
            nbOperationReference = nbOperation;
            nextEffectue = false;
        }

        private void verificationConcurrence() {
            if (nbOperation != nbOperationReference) {
                throw new ConcurrentModificationException();
            }
        } 
    }
	
	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return new Iterateur();
	}
}
