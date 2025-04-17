package fr.uge.yams;

/**
 * Représente la combinaison "Full House" dans le jeu de Yams.
 * 
 * Un Full House est une combinaison composée de trois dés identiques (un brelan)
 * et de deux autres dés identiques (une paire), comme [2, 2, 3, 3, 3].
 * 
 * Cette implémentation retourne actuellement un score fixe de 25, 
 * sans vérifier la validité de la combinaison sur le plateau.
 * 
 * Elle doit être améliorée pour analyser les dés du {@link Board}.
 */
public record FullHouse() implements Combination {

    /**
     * Calcule le score pour la combinaison "Full House".
     * 
     * @param board le plateau de jeu actuel
     * @return 25 si Full House est détecté (actuellement toujours 25, sans analyse)
     */
    @Override
    public int score(Board board) {
        // ⚠ À implémenter : analyse réelle des dés du plateau
        return 25;
    }

    /**
     * Fournit une représentation textuelle de cette combinaison.
     * 
     * @return "Full House"
     */
    @Override
    public String toString() {
        return "Full House";
    }
}
