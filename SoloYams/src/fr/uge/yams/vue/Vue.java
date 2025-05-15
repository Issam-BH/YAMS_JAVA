package fr.uge.yams.vue;

import java.util.Scanner;

public class Vue {
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
}
