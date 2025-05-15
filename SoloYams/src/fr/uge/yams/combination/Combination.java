package fr.uge.yams.combination;

import fr.uge.yams.model.Board;

/**
 * Représente une combinaison possible dans le jeu de Yams (comme brelan, carré, full, etc.).
 * 
 * Cette interface peut être implémentée par différentes classes représentant
 * des types spécifiques de combinaisons. Elle propose une méthode par défaut
 * pour calculer le score associé à la combinaison selon l'état actuel du plateau (Board).
 */
public interface Combination {

    /**
     * Calcule le score obtenu pour cette combinaison selon le plateau de jeu donné.
     * 
     * Par défaut, cette méthode retourne 0. Elle doit être surchargée
     * par les classes implémentant cette interface pour définir leur propre logique de calcul.
     * 
     * @param board le plateau de jeu contenant les dés et/ou les combinaisons jouées
     * @return le score correspondant à cette combinaison (par défaut 0)
     */
    default int score(Board board) {
        return 0;
    }

}
