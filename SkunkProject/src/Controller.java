import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Controller {
	
	public ArrayList<Player> playerList = new ArrayList<Player>();
	public SkunkDice dice;
	public int kitty;
	public int roundGoal = 100;
	public Player currentPlayer;
	public int 	currentPlayerIndex=0;

	
	public Player getCurrentPlayer() {
		
		return currentPlayer;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public boolean turnInProg;
	public boolean finalTurnsFlag;

	//better method:  loop is then placed in AppRunner based on user input; takes user input/app output out of the method
//	public Player createPlayers(String name) {		
//			Player player = new Player(StdIn.readLine());
//			playerList.add(player);
//			currentPlayer = playerList.get(currentPlayerIndex);
//			return player;
//			}
	

	public void createPlayers(int numPlayers) {		
		for (int j = 1; j <= numPlayers; j++) {
			StdOut.println("Player " + j + " Name: ");
			Player player = new Player(StdIn.readLine());
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
			message = "\n" + currentPlayer.name + " skipped turn ";
			nextPlayer();
		} 
		else if (decision.equalsIgnoreCase("Yes")) {
			turnInProg = true;
			dice = new SkunkDice();
			message = "\n" + currentPlayer.name + "'s turn";
		}
		
		return message;
	}
	
	//Method for player continuing their turn
	public String playerTurnContinue(Player player) {
		dice.roll();
		if (dice.isSkunk())
		{
			player.turnScore = 0;
		}

		else if (dice.isDoubleSkunk())
		{
			player.turnScore = 0;
		}

		else
		{
			player.turnScore += dice.getDiceValue();
		}
		
//		player.setTurnScore(dice.getDiceValue());
		return rollInfo(player);
	}
	
	public String allPlayersInfo() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Player player : playerList) {
			sb.append("\n" + player.name + "'s Game Score (Chip Score): " + player.getChip());
		}
		return sb.toString();
	}
	
	public String rollInfo(Player player) {
		String message = "\nRoll Info: "
				+ "\nDie 1: " + dice.getDie1Value() + ";" + " Die 2: " + dice.getDie2Value()
				+ "\nRoll total: " + dice.getDiceValue()
				+ "\nTurn total: " + player.getTurnScore()
				+ "\nRound total: " + player.getRoundScore() + "  ||  Goal: " + roundGoal
				+ "\nChip total: " + player.getChip()
				+ "\n" + checkSkunk(player)
				+ "\n" + checkHundred(player);
		return message;
	}

	public String playerTurnEnd(Player player) {
		int turnScore = player.getTurnScore();
		player.addRoundScore(turnScore);
		String message = "\n" + player.name + " is ending turn \nRound score : " + player.getRoundScore() + " || Round goal: " + roundGoal + "\nChip Count: " + player.getChip();
		if (player.getRoundScore() >= roundGoal) {
			setRoundGoal(player.getRoundScore());
			setFinalTurnFlag(true);
			message += "\nPlayer " + player.name + " surpassed the goal.  Next player needs to beat " + roundGoal + " points";
		}
		turnInProg = false;
		allPlayersInfo();
		player.setTurnScore(0);
		nextPlayer();
		return message;
	} 
	
	public String checkSkunk(Player player) {
		String message = "";
		if (dice.isSkunk() || dice.isDoubleSkunk()) {
			if (dice.isSkunk()) {
				player.addChip(-1);
				StdOut.println("chips: " + player.getChip());
				kitty += 1;
				message = "\nYou rolled a Skunk.\nTurn score set to 0. \n1 chip lost \nRound score is " + player.getRoundScore() + "\nChip total is " + player.getChip() + "\n\n" + kitty + " chip(s) now in the kitty";
				playerTurnEnd(currentPlayer);
			}
			else if (dice.isDoubleSkunk()) {
				player.addRoundScore(0);
				player.addChip(-2);
				kitty += 2;
				message = "\nYou rolled a Double Skunk. \nTurn AND round score is set to 0. \n2 chips lost. \nChip total is " + player.getChip() + "\n" + kitty + " chip(s) now in the kitty";
				playerTurnEnd(currentPlayer);
			}
		} 
		return message;
	}
	
	public  String checkHundred (Player player) {
		String message = "";
		if (player.getTurnScore() >= roundGoal ) {
			message = player.name + " has reached " + roundGoal + "+ points.  Continue rolling to raise the round goal, or stop here? ";

		}
		return message;
	}
	
	private void setRoundGoal(int goal) {
		this.roundGoal = goal;
	}
	
	public void setFinalTurnFlag(boolean b) {
		this.finalTurnsFlag = b;
	}

	public String roundEnd() { 
		Player roundWinner = null;
		for (Player player : playerList) {
			int score = player.getRoundScore();
			if (score == roundGoal) {
				StdOut.println(roundGoal);
				roundWinner = player;
				roundWinner.addChip(kitty);
			}
			player.roundScore = 0;
		}

		String message = "\n" + roundWinner.name + " won the round with " + roundGoal + " points! " + roundWinner.name + " receives " + kitty + " chip(s)\n";
		
		kitty = 0;
		roundGoal = 100;
		finalTurnsFlag = false;
		
		return message;
	}
	
	public Player getWinner() {
		Player winner = null;
		int winningScore = 0;
		for (Player player : playerList) {
			if(player.getChip() > winningScore) {
				winningScore = player.getChip();
				winner = player;
			}
		}
		
		return winner;
	}
	
	public void playerTurns() {
		StdOut.println(currentPlayer.name + " start your turn ?(Yes/No)");
		String decision = StdIn.readLine();
		playerTurn(decision);
	
		while (turnInProg) {
			StdOut.println("\n" + currentPlayer.name + " would you like to roll? (Yes/No)");
			String rollTurn = StdIn.readLine();
			if (rollTurn.equalsIgnoreCase("Yes")) {
				StdOut.println(playerTurnContinue(currentPlayer));
			}
			else if (rollTurn.equalsIgnoreCase("No")) {
				StdOut.println(playerTurnEnd(currentPlayer));
			}
		} 
	}
	
	public String gameEnd() {
		Player winner = getWinner();
		int winningScore = winner.getChip();
		String message = "\n The winner of the game is " + winner.name + " with " + winningScore + " chips!!!";
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

	public int getcurrentPlayerIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
