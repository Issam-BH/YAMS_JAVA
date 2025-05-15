package fr.uge.yams;

import java.util.Scanner;

import fr.uge.yams.combination.Carre;
import fr.uge.yams.combination.Chance;
import fr.uge.yams.combination.Combination;
import fr.uge.yams.combination.FullHouse;
import fr.uge.yams.combination.LargeStraight;
import fr.uge.yams.combination.Sacrifice;
import fr.uge.yams.combination.SmallStraight;
import fr.uge.yams.combination.ThreeOfAKind;
import fr.uge.yams.combination.YamsCombination;
import fr.uge.yams.gamemodes.Game;
import fr.uge.yams.vue.Vue;

/**
 * Classe principale du jeu de Yams.
 * 
 * Gère l'interaction avec le joueur, le déroulement des tours, 
 * les relances de dés, le choix de combinaisons et la mise à jour du score.
 */
public class Yams {

    /**
     * Affiche un message de bienvenue et demande le nom du joueur.
     * 
     * @param scanner le scanner utilisé pour lire l'entrée utilisateur
     * @return le nom du joueur
     */
    

    /**
     * Convertit une lettre de combinaison en instance réelle de combinaison.
     * 
     * @param combinationName la lettre entrée par le joueur
     * @return une instance de {@link Combination}
     * @throws IllegalArgumentException si la lettre est invalide
     */


    /**
     * Méthode principale : point d'entrée du jeu.
     * 
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Un seul scanner pour toute l'application
        var scanner = new Scanner(System.in);
        var name = Vue.init(scanner); // Récupère le nom du joueur
        System.out.println("Hello " + name + ", and good luck !\n");
        Game.game(name);
    }
}