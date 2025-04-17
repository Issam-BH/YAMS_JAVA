package fr.uge.yams;

import java.util.Scanner;

/**
 * Classe principale du jeu de Yams.
 * 
 * Gère l’interaction avec le joueur, le déroulement des tours, 
 * les relances de dés, le choix de combinaisons et la mise à jour du score.
 */
public class Yams {

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
     * Demande au joueur s’il souhaite relancer un dé.
     * 
     * @param scanner le scanner pour lire la réponse
     * @return un entier entre 0 et 5 : 0 pour ne pas relancer, sinon l’index du dé à relancer
     */
    private static int askReroll(Scanner scanner) {
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
    private static String askCombination(Scanner scanner) {
        System.out.println("Please choose a combination to score in your score sheet by entering its first letter.");
        System.out.println("T = Three of a Kind | F = Full House");
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
    private static Combination parseCombination(String combinationName) {
        return switch (combinationName.toUpperCase()) {
            case "T" -> new ThreeOfAKind();
            case "F" -> new FullHouse();
            default -> throw new IllegalArgumentException("Unexpected value: " + combinationName);
        };
    }

    /**
     * Méthode principale : point d'entrée du jeu.
     * 
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var name = init(scanner); // Récupère le nom du joueur
        System.out.println("Hello " + name + ", and good luck !\n");

        var scoreSheet = new ScoreSheet(); // Feuille de score du joueur

        // Deux tours maximum
        for (var roundCounter = 0; roundCounter < 2; roundCounter++) {
            System.out.println("Welcome in round " + (roundCounter + 1));
            var board = new Board(); // Lancer initial des dés
            System.out.println(board);

            // Jusqu’à 3 relances possibles
            for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                var choice = askReroll(scanner);
                if (choice > 0) {
                    board.reroll(choice);
                    System.out.println(board);
                } else {
                    break;
                }
            }

            // Choix de la combinaison
            var combinationChoice = parseCombination(askCombination(scanner));
            scoreSheet.updateScore(combinationChoice, board); // Met à jour le score
            System.out.println(scoreSheet);
        }

        System.out.println("C'est fini !");
    }
}
