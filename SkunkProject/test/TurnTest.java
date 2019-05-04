
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
//-------------------------TP 1.2 changes--------------------------------------------------//
public class TurnTest
{
	private Dice dice, dice2;
	private Die die1, die2, die3, die4;
	private int[] rollDie1, rollDie2, rollDie3, rollDie4;
	
	@Before
	public void setUp() throws Exception
	{
 		this.rollDie1 = new int[] { 1, 2, 3 }; // creating a non-random die roll
		this.die1 = new Die(rollDie1); // calling the overloaded Die class constructor with different parameter list

		this.rollDie2 = new int[] { 1, 2, 3 }; // creating a non-random die roll
		this.die2 = new Die(rollDie2);  // calling the overloaded Die class constructor with different parameter list

		this.dice = new Dice(die1, die2);  // calling the overloaded Die class constructor with different parameter list

		this.rollDie3 = new int[] { 3, 4, 5 }; // creating a non-random die roll
		this.die3 = new Die(rollDie3);  // calling the overloaded Die class constructor with different parameter list

		this.rollDie4 = new int[] { 4, 5, 6 }; // creating a non-random die roll
		this.die4 = new Die(rollDie4);  // calling the overloaded Die class constructor with different parameter list

		this.dice2 = new Dice(die3, die4);  // calling the overloaded Die class constructor with different parameter list

	}

	@Test
	public void testIsSkunk() {
		Turn turn = new Turn(dice); //calling the overloaded Turn class constructor with different parameter list
		turn.turnRoll(); // executing the turnRoll() method of the turn class
		boolean testBol = turn.isSkunk(); // gives true because die1 = {1,2,3} & die2 = {1,2,3}
		assertTrue(testBol);
	}

	@Test
	public void testTurnScore() {
		Turn turn2 = new Turn(dice2); //calling the overloaded Turn class constructor with different parameter list
		turn2.turnRoll(); // executing the turnRoll() method of the turn class
		int expectedTurnScore = 7; // expected turn Score = 1 + 2 + 3 = 7 from rolling a non-random die
		int actualTurnScore = turn2.getTurnScore(); // actual turn score is calculated using the getTurnScore() method in the Turn Class
		assertEquals(expectedTurnScore,actualTurnScore);
	}

	@Test
	public void testTurnScoreAfterSkunk() {
		Turn turn = new Turn(dice);  //calling the overloaded Turn class constructor with different parameter list
		turn.turnRoll(); // executing the turnRoll() method of the turn class
		int expectedTurnScore = 0; // expected turn Score = 0 due to rolling a skunk
		int actualTurnScore = turn.getTurnScore(); // actual turn score is calculated using the getTurnScore() method in the Turn Class
		assertEquals(expectedTurnScore,actualTurnScore);
	}


}
