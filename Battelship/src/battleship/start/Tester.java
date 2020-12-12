package battleship.start;

public class Tester extends Starter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tester");
		startGame();
		testGame();
	}

	private static void testGame() {
 
		view.displayMiss("00");
		view.displayHit("34");
		view.displayMiss("55");
		view.displayHit("12");
		view.displayMiss("25");
		view.displayHit("26");
		
		view.displayMessage("Tap tap, is this thing on?");
	}

	

}
