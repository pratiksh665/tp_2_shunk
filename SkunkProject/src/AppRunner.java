import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

//-------------------------TP 1.2 changes--------------------------------------------------//
public class AppRunner {
	boolean turnInProg;
	boolean roundInProg;
	Player currentPlayer;
	
	public void displayGame() {
		Controller c = new Controller();
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Scanner scan = new Scanner(System.in);
		StdOut.println("Would you like to see the rules? (Yes/No)");
		if (scan.next().equalsIgnoreCase("Yes") ) {
			c.showRules();
		}
		StdOut.println("Number of players: ");
		int numPlayers = scan.nextInt();
		c.createPlayer(numPlayers);
		roundInProg = true;

		while(roundInProg) {
			currentPlayer = c.currentPlayer;
			StdOut.println(currentPlayer.name + " start your turn ?(Yes/No)");
			String decision = scan.next(); 
			c.playerTurn(decision);
		
			while (c.turnInProg) {
				StdOut.println(c.currentPlayer.name + " would you like to roll? (Yes/No)");
				String rollTurn = scan.next();
				if (rollTurn.equalsIgnoreCase("Yes")) {
					StdOut.println(c.playerTurnContinue(currentPlayer));
				}
				else if (rollTurn.equalsIgnoreCase("No")) {
					StdOut.println(c.playerTurnEnd(currentPlayer));
				}
			}
		}
	}
}// end of class
