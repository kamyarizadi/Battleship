package view;

import battleship.gui.Board;

public class View {
	private static View view = null;
	private IBattleshipBoard board;
	
	/**
	 * View is created as singleton pattern
	 * @param board: GUI of game
	 */
	private View(IBattleshipBoard board) {
		this.board = board;
	}
	
	
	public static View createView(IBattleshipBoard board) {
		if(view != null)
			return view;
		view = new View(board);
		return view;
	}
	/**
	 * sends game massages to the board to be shown on game's GUI
	 * @param msg: message to be shown on game's board
	 */
	public void displayMessage(String msg) {
		board.displayMessage(msg);
	}

}
