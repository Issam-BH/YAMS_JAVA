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
	public int score(Board board) {
        Map<Integer, Integer> compteur = new HashMap<>();
        int totalDes = 0;

        // Utiliser le getter pour accéder à la liste des dés
        for (Dice de : board.getFiveDice()) {  // Utilisation du getter pour accéder aux dés
            int val = de.value(); 
            totalDes += val; // Somme des valeurs des dés
            compteur.put(val, compteur.getOrDefault(val, 0) + 1);  
        }

        // Recherche d'un brelan (3 dés avec la même valeur)
        for (int count : compteur.values()) {
            if (count == 3) {
                return totalDes; // Retourne la somme des dés si un brelan est trouvé
            }
        }

        return 0; // Aucun brelan trouvé
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
