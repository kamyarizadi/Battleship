package battleship.mvc.view;

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
	 * sends massages to the board to be shown on game's GUI
	 * @param msg: message to be shown on game's board
	 */
	public void displayMessage(String msg) {
		board.displayMessage(msg);
	}
	
	/**
	 * send display miss message to the board to display miss icon at the cell specified by the location parameter
	 * @param location
	 */
	public void displayMiss(String location) {
		board.displayMiss(location);
	}
	
	/**
	 * send display hit message to the board to display battle icon at the cell specified by the location parameter
	 * @param location
	 */

	public void displayHit(String location) {
		board.displayHit(location);
	}	

}
