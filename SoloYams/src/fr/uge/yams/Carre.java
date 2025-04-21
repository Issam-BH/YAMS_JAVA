package fr.uge.yams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * ATTENTION: C'est littéralement le code du brelan mais avec des modifs mineurs
 * car meme fonctionnement il faudra changer les commentaire pour s'adapter
 * 
 * Représente la combinaison Carre dans le jeu de Yams.
 * 
 * Un carre consiste à obtenir 4 dés avec la même valeur, par exemple : [4, 4, 4, 2, 6].
 * 
 * Cette implémentation retourne actuellement un score fixe de 15 sans vérification,
 * et devra être améliorée pour détecter réellement un brelan sur le plateau.
 */
public record Carre() implements Combination {

    /**
     * Calcule le score pour la combinaison "Carree". 
     * 
     * @param board le plateau de jeu à analyser
     * @return valeurs de la somme des dés si brelan détecté
     */
	@Override
    public int score(Board board) {
        Map<Integer, Integer> compteur = new HashMap<>();
        int totalDes = 0;

        // Récupérer la liste des dés depuis le plateau
        ArrayList<Dice> dices = board.getFiveDice();  // Utilisation du getter

        // On parcourt la liste de dés
        for (Dice de : dices) { 
            int val = de.value(); 
            totalDes += val; // Somme des valeurs des dés
            compteur.put(val, compteur.getOrDefault(val, 0) + 1);  
        }

        // On cherche une valeur qui apparaît 4 fois, ce qui constitue un carre
        for (int count : compteur.values()) { 
            if (count == 4) {
                return totalDes; // Si 4 dés ont la même valeur, retourner la somme
            }
        }

        return 0; // Aucun carre trouvé
    }

    /**
     * Représente cette combinaison en tant que chaîne de caractères.
     *
     * @return "Carree"
     */
    @Override
    public String toString() {
        return "Square";
    }
}
