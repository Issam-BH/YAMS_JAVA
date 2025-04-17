package fr.uge.yams;

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
     * Calcule le score pour la combinaison "Three of a Kind".
     * 
     * @param board le plateau de jeu à analyser
     * @return 15 si brelan détecté (actuellement renvoie toujours 15)
     */
    @Override
    public int score(Board board) {
        // ⚠ À implémenter : vraie détection d’un brelan dans les dés
        return 15;
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
