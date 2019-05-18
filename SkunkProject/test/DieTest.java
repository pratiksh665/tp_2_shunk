import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

//-------------------------TP 1.1 changes--------------------------------------------------//
public class DieTest {

	private Die die;
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConstructor(){
		die=new Die();
	}
	
	@Test
	public void testLoadedDie2() {
		int[] progRoll = {1,2,6,5};
		Die die1 = new Die (progRoll);
		int[] dieTest = new int[10];
		//roll preprogrammed Die object 10 times; should run through the preprogrammed values then start over
		for (int i=0; i<=9; i++) {
			die1.roll();
			dieTest[i] = die1.getLastRoll();
			System.out.println(dieTest[i]);
		}
		
		String expected = Arrays.toString(new int[] {1,2,6,5,1,2,6,5,1,2});
		String actual = Arrays.toString(dieTest);
		
		Assert.assertEquals(expected,actual);
	}
	
	@Test
	//test that the nullPointerException is thrown when an empty array is passed as a parameter to Die obj
	public void nullExceptionTest() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Empty Array Initialized");
		int[] emptyArray = null;
		Die empty = new Die(emptyArray);
	}
	
	
	@Test
	public void testLoadedDie() {
		int[] progRoll = {1,2,6,5};
		Die die1 = new Die (progRoll);
		int[] dieTest = new int[4];
		int arrayIndex;
		
		//for (int arrayIndex=progRoll.length-1; arrayIndex>=1; arrayIndex=arrayIndex -1) { // forloop for iterating the array backwards
		
		  for (arrayIndex=0; arrayIndex<dieTest.length; arrayIndex++) //forloop for iterating the array forwards
		  {
			die1.roll();
			dieTest[arrayIndex] = die1.getLastRoll();
			System.out.println(dieTest[arrayIndex]);
		  }

		String actual = Arrays.toString(dieTest );
		String expected = Arrays.toString(new int[] {1,2,6,5});
		
		assertEquals(expected,actual);  
	}
	
	@Test
	public void testrandomroll() {
		die=new Die();
		die.roll();
		Assert.assertTrue(die.isItARandomRoll);

	
		int[] progRoll = {1,2,6,5};
		die = new Die(progRoll);
		Assert.assertFalse(die.isItARandomRoll);
	}

}
