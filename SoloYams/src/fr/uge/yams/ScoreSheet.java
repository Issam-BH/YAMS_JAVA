package fr.uge.yams;

import java.util.HashMap;
import java.util.Objects;

/**
 * Représente la feuille de score d'une partie de Yams.
 * 
 * Cette classe permet d'enregistrer le score obtenu pour chaque combinaison jouée,
 * et de calculer le score total cumulé.
 * 
 * Chaque combinaison (comme Full House, Three of a Kind, etc.) ne peut être enregistrée qu'une seule fois.
 */
public class ScoreSheet {

    // Dictionnaire associant chaque combinaison à son score
    private final HashMap<Combination, Integer> scoreMap = new HashMap<>();

    /**
     * Met à jour le score pour une combinaison donnée si elle n'a pas encore été jouée.
     * 
     * @param pattern la combinaison à évaluer
     * @param board le plateau de jeu utilisé pour calculer le score
     * @throws IllegalArgumentException si cette combinaison a déjà été utilisée
     * @throws NullPointerException si pattern est null
     */
    public void updateScore(Combination pattern, Board board) {
        Objects.requireNonNull(pattern, "La combinaison ne doit pas être null");

        if (scoreMap.containsKey(pattern)) {
            throw new IllegalArgumentException("Un score est déjà enregistré pour cette combinaison.");
        }

        // Calcule le score et l'enregistre
        scoreMap.put(pattern, pattern.score(board));
    }

    /**
     * Calcule le score total obtenu jusqu'à présent.
     * 
     * @return la somme des scores enregistrés pour toutes les combinaisons
     */
    public int scoreTotal() {
        return scoreMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Représente la feuille de score sous forme de chaîne de caractères.
     * 
     * @return une chaîne listant chaque combinaison jouée et son score
     */
    @Override
    public String toString() {
        return scoreMap.toString();
    }
}
