import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

public class AppRunner {
	boolean turnInProg;
	boolean roundInProg;
	boolean gameInProg;
	Controller c = new Controller();
	Scanner scan = new Scanner(System.in);

	
	
	public void displayGame() {
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		StdOut.println("Would you like to see the rules? (Yes/No)");
		if (scan.next().equalsIgnoreCase("Yes") ) {
			c.showRules();
		}
		StdOut.println("Number of players: ");
		int numPlayers = scan.nextInt();
		c.createPlayer(numPlayers);
		roundInProg = true;
		gameInProg = true;

		
		for (int round = 1; round <=5; round++) {
			
			StdOut.println("\nRound " + round + "\n");
			
			if (c.finalTurnsFlag) {
				
				int turnsLeft = numPlayers-1;
				for (int i = 0; i < turnsLeft; i++) {
					StdOut.println("\nFinal Turn in Round\n");
					playerTurns();	
				}
				
				StdOut.println(c.roundEnd());
				roundInProg = false;
			} 
			
			else {
				
				playerTurns();
			}
		} 
		
		gameEnd();
		
	}
	
	public void playerTurns() {
		StdOut.println(c.currentPlayer.name + " start your turn ?(Yes/No)");
		String decision = scan.next(); 
		c.playerTurn(decision);
	
		while (c.turnInProg) {
			StdOut.println(c.currentPlayer.name + " would you like to roll? (Yes/No)");
			String rollTurn = scan.next();
			if (rollTurn.equalsIgnoreCase("Yes")) {
				StdOut.println(c.playerTurnContinue(c.currentPlayer));
			}
			else if (rollTurn.equalsIgnoreCase("No")) {
				StdOut.println(c.playerTurnEnd(c.currentPlayer));
			}
		} 
	}
	
	public void gameEnd() {
		Player winner = c.getWinner();
		int winningScore = winner.getChip();
		StdOut.println("\n The winner of the game is " + winner.name + " with " + winningScore + " chips!!!");
	}
	
}
