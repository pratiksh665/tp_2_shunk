import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class Controller {
	
	public ArrayList<Player> playerList = new ArrayList();
	public Turn turn;

	

	public Player createPlayer(String name) {
		Player player = new Player(name);
		playerList.add(player);
		return player;
	}
	
	public void playerTurn() {
		turn = new Turn();
	}
	
	public String playerTurnContinue(Player player) {
		turn.turnRoll();
		return rollInfo(player);
	}
	
	public String rollInfo(Player player) {
		String message = "Roll Info: "
				+ "\nDie 1: " + getDie1Value() + ";" + " Die 2: " + getDie2Value()
				+ "\nRoll total: " + getDiceValue()
				+ "\nTurn total: " + getTurnScore()
				+ "\nGame total: " + player.getScore()
				+ "\n" + checkSkunk(player)
				+ "\n" + hundredCheck(player);
		return message;
	}
	
	public String playerTurnEnd(Player player) {
		player.setScore(getTurnScore());
		String message = player.name + "is ending turn \nTurn score was " + getTurnScore() + "\nTotal score is " + player.getScore();
		return message;

	} 
	
	public String checkSkunk(Player player) {
		String message = "";
		if (turn.isSkunk() || turn.isDoubleSkunk()) {
			if (turn.isSkunk()) {
				message = "You rolled a Skunk; end of turn \nTotal score is " + player.getScore();
				player.chipPenalty(1);
			}
			else if (turn.isDoubleSkunk()) {
				player.setScore(0);
				message = "You rolled a Double Skunk; \nend of turn \nTotal score is " + player.getScore();
				player.chipPenalty(2);
			}
		} 
		return message;
	}
	
	public  String hundredCheck(Player player) {
		String message = "";
		if (player.getScore() >= 100) {
			message = roundEnd(player);
		}
		return message;
		
	}
	
	public String roundEnd(Player player) {
		String message =  player.name + " won the game with " + player.playerScore + " points!";
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
		return turn.getDie1Value();
	}
	
	public int getDie2Value() {
		return turn.getDie2Value();
	}
	
	public int getDiceValue() {
		return turn.getDiceValue();
	}
	
	public int getTurnScore() {
		return turn.getTurnScore();
	}
	
	
	
}
