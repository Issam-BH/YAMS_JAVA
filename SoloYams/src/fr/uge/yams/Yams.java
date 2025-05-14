package fr.uge.yams;

import java.util.Scanner;

/**
 * Classe principale du jeu de Yams.
 * 
 * Gère l'interaction avec le joueur, le déroulement des tours, 
 * les relances de dés, le choix de combinaisons et la mise à jour du score.
 */
public class Yams {

	public String name = "";
    /**
     * Affiche un message de bienvenue et demande le nom du joueur.
     * 
     * @param scanner le scanner utilisé pour lire l'entrée utilisateur
     * @return le nom du joueur
     */
    public static String init(Scanner scanner) {
        System.out.println("Welcome, player, please enter your name.");
        return scanner.nextLine();
    }

    /**
     * Demande au joueur de choisir un mode de jeu.
     * 
     * @param scanner le scanner utilisé pour lire l'entrée utilisateur
     * @return le mode de jeu choisi (1=Classic, 2=VS COMP, 3=1V1)
     */
    public static int gamemode(Scanner scanner) {
        System.out.println("Choose your game mode : \n 1 = Classic \n 2 = V.S. COMP \n 3 = 1 V 1");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Pour vider le buffer
        return choice;
    }

    /**
     * Demande au joueur s'il souhaite relancer un dé.
     * 
     * @param scanner le scanner pour lire la réponse
     * @return un entier entre 0 et 5 : 0 pour ne pas relancer, sinon l'index du dé à relancer
     */
    public static int askReroll(Scanner scanner) {
        System.out.println("Do you want to reroll a die? Type 0 for no, 1-5 to reroll this die.");
        var choice = scanner.nextLine();
        return Integer.parseInt(choice);
    }

    /**
     * Demande au joueur de choisir une combinaison.
     * 
     * @param scanner le scanner pour lire l'entrée
     * @return la lettre représentant la combinaison
     */
    public static String askCombination(Scanner scanner) {
        System.out.println("Please choose a combination to score in your score sheet by entering its first letter.");
        System.out.println("T = Three of a Kind | F = Full House | SQ = Carré | SS = Small Straight | LS = Large Straight | C = Chance | Y = Yams | S = Sacrifice");
        System.out.println("Note : You can't use the combination you've already choose.");
        var choice = scanner.nextLine();
        return choice;
    }

    /**
     * Convertit une lettre de combinaison en instance réelle de combinaison.
     * 
     * @param combinationName la lettre entrée par le joueur
     * @return une instance de {@link Combination}
     * @throws IllegalArgumentException si la lettre est invalide
     */
    public static Combination parseCombination(String combinationName) {
        return switch (combinationName.toUpperCase()) {
            case "T" -> new ThreeOfAKind();
            case "F" -> new FullHouse(); 
            case "SQ" -> new Carre();
            case "SS" -> new SmallStraight();
            case "LS" -> new LargeStraight();
            case "C" -> new Chance();
            case "Y" -> new YamsCombination();
            case "S" -> new Sacrifice();
            default -> throw new IllegalArgumentException("Unexpected value: " + combinationName);
        };
    }

    /**
     * Méthode principale : point d'entrée du jeu.
     * 
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Un seul scanner pour toute l'application
        var scanner = new Scanner(System.in);
        var name = init(scanner); // Récupère le nom du joueur
        System.out.println("Hello " + name + ", and good luck !\n");
        Game.game(name);
    }
}