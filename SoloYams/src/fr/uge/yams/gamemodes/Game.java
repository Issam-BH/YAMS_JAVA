package fr.uge.yams.gamemodes;

import java.util.Scanner;

import fr.uge.yams.Yams;
import fr.uge.yams.vue.Vue;

public class Game {
	
	public static void game(String name) {
	    var scanner = new Scanner(System.in);
	    
	    int gamemode = Vue.gamemode(scanner);
        
	    switch(gamemode) {
	    case 1: {
	        Classic.classic(name);
	        break;
	    }
	    case 2: {
	        CompVs.compVs(name);
	        break;
	    }
	    case 3: {
	        Multiplayer.multi(name);
	        break;
	    }
	    default: {
	        System.out.println("Choix invalide");
	    }
	}

	System.out.println("Game Over!");
	scanner.close();
	}

    }
