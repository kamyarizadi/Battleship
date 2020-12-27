package battleship.start;

public class Tester extends Starter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tester");
		startGame();
		testGame();
	}

	private static void testGame() {
		/**
		 * Test of view
		 */
//		view.displayMiss("00");
//		view.displayHit("34");
//		view.displayMiss("55");
//		view.displayHit("12");
//		view.displayMiss("25");
//		view.displayHit("26");
		
//		view.displayMessage("Tap tap, is this thing on?");

		/**
		 * Test of model
		 */ 
//		model.fire("53");
//		
//		model.fire("06");
//		model.fire("16");
//		model.fire("26");
//		
//		model.fire("34");
//		model.fire("24");
//		model.fire("44");
//		
//		model.fire("12");
//		model.fire("11");
//		model.fire("10");
		/**
		 * Test of parseGuess in the controller
		 * 
		 */
		
//		controller.TestParseGuess();
		
		/**
		 * Test of processGuess in the controller
		 */
		controller.processGuess("A0");
		controller.processGuess("A6");
		controller.processGuess("B6");
		controller.processGuess("C6");
		controller.processGuess("C4");
		controller.processGuess("D4");
		controller.processGuess("E4");
		controller.processGuess("B0");
		controller.processGuess("B1");
		controller.processGuess("B2");
	}

	

}
