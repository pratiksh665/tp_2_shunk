import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;


public class AppRunnerTest {

//	private AppRunner appRunner  = new AppRunner();
	private Controller controller;

	private static final String NEW_LINE = "\n";
	//This private class will mock methods of Controller
	class ControllerHelper extends Controller {

		@Override
		public void createPlayers(int numPlayers) {
			System.out.println("Mocked Method: createPlayers");
		}

		@Override
		public void showRules() {
			System.out.println("Mocked Method: showRules");
		}

		@Override
		public void playerTurns() {
			System.out.println("Mocked Method: playerTurns");
			controller.finalTurnsFlag = true;

		}

		@Override
		public String roundEnd() {
			return "Mocked Method: roundEnd";
		}

		@Override
		public String gameEnd() {
			return "Mocked Method: gameEnd";
		}
	}
	//This class will mock few methods of AppRunner
	//Namely two methods: getRulesChoice, getPlayers
	//These two methods are used to take input from user
	class AppRunnerInputMock extends AppRunner {
		private String choice;
		private int numOfPlayers;
		public AppRunnerInputMock(String choice, int numOfPlayers) {
			this.choice = choice;
			this.numOfPlayers = numOfPlayers;
		}
		
		@Override
		public String getRulesChoice() {
			return choice;
		}
		
		@Override 
		public int getPlayers() {
			return numOfPlayers;
		}
		
	}

	@Before
	public void setup() {
		//Created Instance of Mocked Controller
		controller = new ControllerHelper();

	}
	
	

//
//	@Test
//	public void testYesChoice() {
//		appRunner = new AppRunnerInputMock("Yes", 2);
//		appRunner.displayGame(controller);
//	}
//	@Test
//	public void testNoChoice() {
//		appRunner = new AppRunnerInputMock("No", 2);
//		appRunner.displayGame(controller);
//	}

}
