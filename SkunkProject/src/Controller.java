import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

public class Controller {
	
	public ArrayList<Player> playerList = new ArrayList();
	public Dice dice;
	public int kitty;
	public int roundGoal;
	public Player currentPlayer;
	public int currentPlayerIndex;
	public boolean turnInProg;

	public void createPlayer(int numPlayers) {
		for (int j = 1; j <= numPlayers; j++) {
			StdOut.println("Player " + j + " Name: ");
			Scanner scan = new Scanner(System.in);
			Player player = new Player(scan.next());
			playerList.add(player);
		}
		currentPlayerIndex=0;
		currentPlayer = playerList.get(currentPlayerIndex);
		
		StdOut.println("First player: " + currentPlayer.name);
	}
	
	public void nextPlayer() {
		if (currentPlayerIndex == (playerList.size() - 1)) {
			currentPlayerIndex = 0;
			currentPlayer = playerList.get(currentPlayerIndex);
		} else {
			currentPlayerIndex++;
			currentPlayer = playerList.get(currentPlayerIndex);
		}
	}
	
	//Questioning if player wants to begin turn or skip
	public String playerTurn(String decision) {
		String message = null;
		if (decision.equalsIgnoreCase("No")) { // execute if user input = no
			turnInProg = false;
			message = currentPlayer.name + " skipped turn ";
			nextPlayer();
		} 
		else if (decision.equalsIgnoreCase("Yes")) {
			turnInProg = true;
			dice = new Dice();
			message = currentPlayer.name + "'s turn";
		}
		
		return message;
	}
	
	//Method for player continuing their turn
	public String playerTurnContinue(Player player) {
		dice.roll(player);
		return rollInfo(player);
	}
	
	public String rollInfo(Player player) {
		String message = "Roll Info: "
				+ "\nDie 1: " + getDie1Value() + ";" + " Die 2: " + getDie2Value()
				+ "\nRoll total: " + getDiceValue()
				+ "\nTurn total: " + player.getTurnScore()
				+ "\nGame total: " + player.getScore()
				+ "\nKitty total: " + player.getChip()
				+ "\n" + checkSkunk(player)
				+ "\n" + checkHundred(player);
		return message;
	}
	
	public String playerTurnEnd(Player player) {
		int turnScore = player.getTurnScore();
		player.addScore(turnScore);
		String message = player.name + " is ending turn \nTurn score was " + player.getTurnScore() + "\nRound score is " + player.getScore();
		turnInProg = false;
		nextPlayer();
		return message;

	} 
	
	public String checkSkunk(Player player) {
		String message = "";
		if (dice.isSkunk() || dice.isDoubleSkunk()) {
			if (dice.isSkunk()) {
				message = "You rolled a Skunk; end of turn \nTotal score is " + player.getScore();
				player.addSubChip(-1);
				kitty += 1;
				playerTurnEnd(currentPlayer);
			}
			else if (dice.isDoubleSkunk()) {
				player.addScore(0);
				message = "You rolled a Double Skunk; \nend of turn \nTotal score is " + player.getScore();
				player.addSubChip(-2);
				kitty += 2;
				playerTurnEnd(currentPlayer);
			}
		} 
		return message;
	}
	
	public  String checkHundred (Player player) {
		String message = "";
		if (player.getTurnScore() >= 100) {
			message = player.name + " has reached 100 points.  Continue rolling to raise the round goal, or stop here? ";
			roundGoal = player.getScore();
		}
		return message;
	}
	
	public String roundEnd(Player player) {
		String message =  player.name + " won the round with " + player.playerScore + " points!";
		return message;
	}
	
	
	public void showRules() {
		
		 // The name of the file to open.
       String fileName = "SkunkRules";

       // This will reference one line at a time
       String line = null;

       try {
           // FileReader reads text files in the default encoding.
           FileReader fileReader = new FileReader(fileName);

           // Always wrap FileReader in BufferedReader.
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           //read line by line in the text file until the line is not null
           while((line = bufferedReader.readLine()) != null) {
               System.out.println(line);
           }   

           // Always close files.
           bufferedReader.close();         
       }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");                
       }
       catch(IOException ex) {
       	System.out.println("Error reading file '" + fileName + "'");                  
       }
   }
	
	public int getDie1Value() {
		return dice.getDie1();
	}
	
	public int getDie2Value() {
		return dice.getDie2();
	}
	
	public int getDiceValue() {
		return dice.getDiceValue();
	}

	
}
