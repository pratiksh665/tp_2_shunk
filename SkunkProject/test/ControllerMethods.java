import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerMethods {
	Controller c;
	SkunkDice dice;
	
	
	@Before
	public void setUp() throws Exception {
		c = new Controller();
		dice = new SkunkDice();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	
	@Test
	public void testCreatePlayers() {
		
		c.createPlayers(4);
		int createdListSize = c.playerList.size();
		
		assertTrue(createdListSize == 4);
	}

	@Test
	public void testNextPlayer() {
		
		c.createPlayers(4);
		int oldIndex = c.getCurrentPlayerIndex();
		System.out.println("old index:" + oldIndex);
		c.nextPlayer();
		System.out.println("new index:" + c.getCurrentPlayerIndex());
		assert c.getCurrentPlayerIndex() == (oldIndex+1)%c.playerList.size();
	}

	@Test
	public void testPlayerTurn() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlayerTurnContinue() {
		fail("Not yet implemented");
	}

	@Test
	public void testAllPlayersInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testRollInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlayerTurnEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckSkunk() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckHundred() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFinalTurnFlag() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoundEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWinner() {
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

	@Test
	public void testShowRules() {
		fail("Not yet implemented");
	}

}
