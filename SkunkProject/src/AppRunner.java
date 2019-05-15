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
	
	
	public void displayGame(Controller c) {
		StdOut.println("Welcome to 635 Skunk project\n\n");
		StdOut.println("Would you like to see the rules? (Yes/No)");
		String decision = StdIn.readLine();
		if (decision.equalsIgnoreCase("Yes") ) {
			c.showRules();
		}
		StdOut.println("Number of players: ");
		int numPlayers = Integer.parseInt(StdIn.readLine());
		c.createPlayers(numPlayers);
		roundInProg = true;

		
		for (int round = 1; round <=5; round++) {
			roundInProg = true;
			while (roundInProg) {
			StdOut.println("\nRound " + round + "\n");
			
			if (c.finalTurnsFlag) {
				
				int turnsLeft = numPlayers-1;
				for (int i = 0; i < turnsLeft; i++) {
					StdOut.println("\nFinal Turn in Round\n");
					c.playerTurns();	
				}
				
				StdOut.println(c.roundEnd());
				roundInProg = false;
			} 
			
			else {
				
				c.playerTurns();
			}
			}
		} 
		
		StdOut.println(c.gameEnd());
		
	}
	

	
}
