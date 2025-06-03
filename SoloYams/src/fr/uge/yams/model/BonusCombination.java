package fr.uge.yams.model;

import java.util.Random;

import fr.uge.yams.bonuses.Bonus;
import fr.uge.yams.bonuses.DoubleReroll;
import fr.uge.yams.bonuses.TwoTimes;

public class BonusCombination {
    public static Bonus parseCombination() { // je suis débile je me suis trompé sur le nom de la fonction à fix later mdr
    	Bonus choice = null;
    	Random rand = new Random();
        int nombreAleatoire = rand.nextInt(1); 
        switch (nombreAleatoire){
        case 1: {
        	choice = new DoubleReroll();
        } case 2 : {
        	choice = new TwoTimes();
        }
        	
        }
        
        return choice;
    }
}
