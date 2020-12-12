package battleship.start;


import battleship.gui.Board;
import view.IBattleshipBoard;
import view.View;

public class Starter {

	protected static IBattleshipBoard board = null;
	protected static View view;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main App");
		startGame();
	}

	
	public static void startGame() {
		board = Board.startBoard();
		view = View.createView(board);						
	};

	

}
