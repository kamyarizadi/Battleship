package battleship.start;


import battleship.gui.Board;
import view.IBattleshipBoard;
import view.View;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main App");
		startGame();
	}

	
	public static void startGame() {
		
		IBattleshipBoard board =  Board.startBoard();
		View view = View.createView(board);		
		view.displayMessage("Testing ...");			
	};

	

}
