package fr.uge.yams;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente la combinaison "Three of a Kind" (brelan) dans le jeu de Yams.
 * 
 * Un brelan consiste à obtenir trois dés avec la même valeur, par exemple : [4, 4, 4, 2, 6].
 * 
 * Cette implémentation retourne actuellement un score fixe de 15 sans vérification,
 * et devra être améliorée pour détecter réellement un brelan sur le plateau.
 */
public record ThreeOfAKind() implements Combination {

    /**
     * Calcule le score pour la combinaison "Three of a Kind" a.k.a Brelan. 
     * 
     * @param board le plateau de jeu à analyser
     * @return valeurs de la somme des dés si brelan détecté
     */
	@Override
	public int score(Board board) {
	    Map<Integer, Integer> compteur = new HashMap<>();
	    int totalDes = 0;

	    for (Dice de : board) {
	        int val = de.value(); 
	        totalDes += val; // On fait le total de valeur de dé (pour éviter de faire de la multiplication)
	        compteur.put(val, compteur.getOrDefault(val, 0) + 1);  
	    }
	    /*
	     * On met la valeur au lieu du dé en lui meme
	     * pour éviter d'avoir des dé de la meme valeur en doublon
	     */

	    for (int count : compteur.values()) { // On cherche dans les valeurs si il existe un 3
	        if (count == 3) {
	            return totalDes; // retourne la somme de la valeur des dés
	        }
	    }

	    return 0; // Aucun brelan
	}

    /**
     * Représente cette combinaison en tant que chaîne de caractères.
     *
     * @return "Three of A Kind"
     */
    @Override
    public String toString() {
        return "Three of A Kind";
    }
}
