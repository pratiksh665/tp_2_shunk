import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkunkDiceTest{

	private SkunkDice sd; 
	private Die die1, die2; 
	private int[] rollDie1, rollDie2;
	
	@Before
	public void setUp() throws Exception
	{
 		this.rollDie1 = new int[] { 1, 2, 3 };
		this.die1 = new Die(rollDie1);

		this.rollDie2 = new int[] { 1, 2, 3 };
		this.die2 = new Die(rollDie2);
				
		this.sd= new SkunkDice(die1, die2);
		
	}
	
	@Test
	public void testConstructor() {
		sd=new SkunkDice();
		assertNotNull(sd);
	}
	
	@Test
	public void testisDoubleSkunk() {		
		sd.roll();
		assertTrue(sd.isDoubleSkunk());
	}

	
	@Test
	public void testisSkunk() {
		sd.roll();
		sd.roll();
		assertFalse(sd.isSkunk());
	}	
	
}
