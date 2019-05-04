import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
//-------------------------TP 1.1 changes--------------------------------------------------//
public class DiceTest
{
	private Dice dice;
	private Die die1, die2;
	private int[] rollDie1, rollDie2;

	@Before
	public void setUp() throws Exception
	{
 		this.rollDie1 = new int[] { 1, 2, 3 };
		this.die1 = new Die(rollDie1);

		this.rollDie2 = new int[] { 1, 2, 3 };
		this.die2 = new Die(rollDie2);
		
		this.dice = new Dice(die1, die2);
	}

	@Test
	public void test_Init_PredictableDie()
	{
		dice.roll();
		int value = dice.getLastRoll();  // adds rollDie1's position1 + rollDie2's position1
		assertEquals(2, value);
	}

	@Test
	public void test_Predictable_Roll_2()
	{
		dice.roll();
		dice.roll();
		int value = dice.getLastRoll();  // adds rollDie1's position2 + rollDie2's position2
		assertEquals(4, value);
	}

	@Test
	public void test_Predictable_Roll_3()
	{
		dice.roll();
		dice.roll();
		dice.roll();
		int value = dice.getLastRoll();
		assertEquals(6, value);  // adds rollDie1's position3 + rollDie2's position3
	}

	@Test
	public void test_toString()
	{
		dice.toString();
		assertEquals("Dice with last roll:   =>  + ", "Dice with last roll:   =>  + ");
	}
	
}