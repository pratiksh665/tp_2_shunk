import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkunkDiceTest{

	private SkunkDice sd; private Dice dice; private Die die1, die2; private int[] rollDie1, rollDie2;
	
	@Before
	public void setUp() throws Exception
	{
 		this.rollDie1 = new int[] { 1, 2, 3 };
		this.die1 = new Die(rollDie1);

		this.rollDie2 = new int[] { 1, 2, 3 };
		this.die2 = new Die(rollDie2);
		
		this.dice = new Dice(die1, die2);
		
		this.sd= new SkunkDice();
		
	}
	
	@Test
	public void testConstructor() {
		sd=new SkunkDice();
	}
	
	@Test
	public void testisSkunk() {		
		dice.roll();
		sd.isSkunk();
	}

	
	@Test
	public void testisDoubleSkunk() {
		dice.roll();
		sd.isDoubleSkunk();
	}	
	
}
