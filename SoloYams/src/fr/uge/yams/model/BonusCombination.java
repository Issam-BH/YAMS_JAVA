package fr.uge.yams.model;

import java.util.Random;
import fr.uge.yams.bonuses.Bonus;
import fr.uge.yams.bonuses.DoubleReroll;
import fr.uge.yams.bonuses.PerfectReroll;
import fr.uge.yams.bonuses.TwoTimes;

public class BonusCombination {
    public static Bonus parseCombination() { // je suis débile je me suis trompé sur le nom de la fonction à fix later mdr
        Bonus choice = new DoubleReroll(); // Valeur par défaut
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(2); // Génère 0 ou 1
        
        switch (nombreAleatoire) {
            case 0: {
                choice = new DoubleReroll();
                break;
            }
            case 1: {
                choice = new TwoTimes();
                break;
            } case 2: {
                choice = new PerfectReroll();
                break;
            }
        }
        
        return choice;
    }
}