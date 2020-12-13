package battleship.start;

public class Tester extends Starter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tester");
		startGame();
		testGame();
	}

	private static void testGame() {
 
//		view.displayMiss("00");
//		view.displayHit("34");
//		view.displayMiss("55");
//		view.displayHit("12");
//		view.displayMiss("25");
//		view.displayHit("26");
		
//		view.displayMessage("Tap tap, is this thing on?");
		
		model.fire("53");
		
		model.fire("06");
		model.fire("16");
		model.fire("26");
		
		model.fire("34");
		model.fire("24");
		model.fire("44");
		
		model.fire("12");
		model.fire("11");
		model.fire("10");
	}

	

}
