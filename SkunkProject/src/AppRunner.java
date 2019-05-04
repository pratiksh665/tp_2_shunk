import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

//-------------------------TP 1.2 changes--------------------------------------------------//
public class AppRunner {

	public int numPlayers;

	
	public void displayGame() {
		Controller controller = new Controller();
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Scanner scan = new Scanner(System.in);
		StdOut.println("Would you like to see the rules? (Yes/No)");
		if (scan.next().equalsIgnoreCase("Yes") ) {
			controller.showRules();
		}
		StdOut.println("Number of players: ");
		numPlayers = scan.nextInt();
		
		for (int i = 1; i <= numPlayers; i++) {
			StdOut.println("Player " + i + " Name: ");
			controller.createPlayer(scan.next());
		}

		// Player Turn (For loop was used because we know that a Skunk game has 5 turns
		// )

//		while (!controller.isHundred) {

			for (Player player : controller.playerList) {
				StdOut.println(player.name + " start your turn ?(Yes/No)"); // user prompt
				String decision = scan.next(); // storing user input
				if (decision.equalsIgnoreCase("No")) { // execute if user input = no
					StdOut.println(player.name + " skipped turn ");
				}

				while (decision.equalsIgnoreCase("Yes")) { // execute if user input = yes
					controller.playerTurn();
					StdOut.println(player.name + " would you like to roll? (Yes/No)");
					String rollTurn = scan.next();
					if (rollTurn.equalsIgnoreCase("Yes")) {
						StdOut.println(controller.playerTurnContinue(player));
						
					}
					
					else if (rollTurn.equalsIgnoreCase("No")) {
						controller.playerTurnEnd(player);
						break;
					}
				} // end of while loop

			} // end of for loop
			
			controller.showRules();

			
		} // end of while loop

//	} // end of playgame method

	// Updated showRules() method to display info from a text file called SkunkRules for code reusability
	
} // end of class
