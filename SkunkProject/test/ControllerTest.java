import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	private static Controller controller = null;
	private SkunkDice dice;
	private static final String NEW_LINE = "\n";
	private static final int START_PLAYER = 0;
	
	
	
	@Before
	public void setUp() throws Exception {
			System.out.println("CALLED");
			controller = new Controller();
			String playerNames = new String("Tom" +NEW_LINE + "Alice" +  NEW_LINE + "Bob") ;
			InputStream in = new ByteArrayInputStream(playerNames.getBytes());
			System.setIn(in);
			controller.createPlayers(3);
			System.setIn(System.in);
		
		dice = new SkunkDice();
		controller.dice = dice;
		controller.currentPlayer = controller.playerList.get(START_PLAYER);
	}
	//To return exact dice value for Assertion, Mock methods of SkunkDice
	class SkunkDiceMock extends SkunkDice {
		private int die1Value;
		private int die2Value;
		public SkunkDiceMock(int die1Value, int die2Value) {
			this.die1Value = die1Value;
			this.die2Value = die2Value;
		}
		
		@Override
		public int getDie1Value(){
			return die1Value;
		}
		@Override
		public int getDie2Value(){
			return die2Value;
		}
		
		@Override
		public int getDiceValue(){
			return die1Value+die2Value;
		}
		
		
	}

	
	@Test
	public void testCreatePlayers() {
		int createdListSize = controller.playerList.size();
		assertTrue(createdListSize == 3);
	}

	@Test
	public void testNextPlayer() {
		int oldIndex = controller.getCurrentPlayerIndex();
		System.out.println("old index:" + oldIndex);
		controller.nextPlayer();
		System.out.println("new index:" + controller.getCurrentPlayerIndex());
		assert controller.getCurrentPlayerIndex() == (oldIndex + 1) % controller.playerList.size();
		
	}

	@Test
	public void testPlayerTurnYes() {
		String message = controller.playerTurn("Yes");
		Assert.assertEquals("\nTom's turn", message);

	}
	@Test
	public void testPlayerTurnNo() {
		String message = controller.playerTurn("No");
		Assert.assertEquals("\nTom skipped turn ", message);

	}

	@Test
	public void testPlayerTurnContinueWithSkunk() {
		controller.dice = new SkunkDiceMock(1, 6);
		Player player = new Player("Dragon");
		String rollInfo = controller.playerTurnContinue(player);
		Assert.assertEquals(0, player.turnScore);
	}
	
	@Test
	public void testPlayerTurnContinuewithDoubleSkunk() {
		controller.dice = new SkunkDiceMock(1, 1);
		Player player = new Player("Dragon");
		String rollInfo = controller.playerTurnContinue(player);
		Assert.assertEquals(0, player.turnScore);
	}


	@Test
	public void testAllPlayersInfo() {
		String info = controller.allPlayersInfo();
		Assert.assertEquals("\nTom's Game Score (Chip Score): 50\nAlice's Game Score (Chip Score): 50\nBob's Game Score (Chip Score): 50", info);
	}

	@Test
	public void testRollInfo() {
		controller.dice = new SkunkDiceMock(1, 6);
		Player player = new Player("Dragon");
		String info = controller.rollInfo(player);
	}

	@Test
	public void testPlayerTurnEndFalse() {
		controller.playerTurnEnd(controller.currentPlayer);
		Assert.assertFalse(controller.finalTurnsFlag);
	}
	
	@Test
	public void testPlayerTurnEndTrue() {
		//Set Round Goal to negative
		controller.roundGoal = -1;
		controller.playerTurnEnd(controller.currentPlayer);
		Assert.assertTrue(controller.finalTurnsFlag);
		//Set back to original
		controller.roundGoal = 100;
	}

	@Test
	public void testCheckSkunkDouble() {
		controller.dice = new SkunkDiceMock(1, 1);
		String message = controller.checkSkunk(controller.getCurrentPlayer());
		Assert.assertTrue(message.contains("You rolled a Double Skunk."));
	}
	@Test
	public void testCheckSkunk() {
		controller.dice = new SkunkDiceMock(1, 6);
		String message = controller.checkSkunk(controller.getCurrentPlayer());
		Assert.assertTrue(message.contains("You rolled a Skunk."));
	}
	
	@Test
	public void testShowRules() {
		controller.showRules();
	}

	@Test
	public void testCheckHundredTrue() {
		Player player = new Player("dragon");
		player.setTurnScore(controller.roundGoal+1);
		String message = controller.checkHundred(player);
		Assert.assertEquals("dragon has reached 100+ points.  Continue rolling to raise the round goal, or stop here? ", message);
	}
	@Test
	public void testCheckHundredFalse() {
		Player player = new Player("dragon");
		player.setTurnScore(controller.roundGoal-1);
		String message = controller.checkHundred(player);
		Assert.assertEquals("", message);
	}

	@Test
	public void testGetWinner() {
		Player expectedWinner = new Player("dragon");
		expectedWinner.setTurnScore(1000);
		expectedWinner.chipPile = 1001;
		controller.playerList.add(expectedWinner);
		Player actualWinner = controller.getWinner();
		Assert.assertEquals(expectedWinner.name, actualWinner.name);
		controller.playerList.remove(controller.playerList.size()-1);
	}
	
	@Test
	public void testGameEnd() {
		controller.gameEnd();
	}
	

	@Test
	public void testRoundEnd() {
		Player expectedWinner = new Player("dragon");
		expectedWinner.setRoundScore(controller.roundGoal);
		controller.playerList.add(expectedWinner);
		String message = controller.roundEnd();
		expectedWinner.chipPile = 0;
		Assert.assertTrue(message.contains("dragon won the round"));
		controller.playerList.remove(controller.playerList.size()-1);
	}
	/*@Test
	public void testSetFinalTurnFlag() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoundEnd() {
		fail("Not yet implemented");
	}


	@Test
	public void testPlayerTurns() {
		fail("Not yet implemented");
	}

	@Test
	public void testGameEnd() {
		fail("Not yet implemented");
	}
 */

}
