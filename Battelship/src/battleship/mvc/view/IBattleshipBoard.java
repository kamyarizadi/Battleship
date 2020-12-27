package battleship.mvc.view;

import battleship.mvc.controller.Controller;

public interface IBattleshipBoard {
	/**
	 * Displays game massages on the board
	 * @param msg: message to be shown on board
	 */
	public void displayMessage(String msg);	
	
	/**
	 * Displays Miss at the specified location
	 * @param location: indicates where Miss has to be displayed
	 */
	public void displayMiss(String location);

	/**
	 * Displays Miss at the specified location
	 * @param location: indicates where Miss has to be displayed
	 */
	public void displayHit(String location);
	
	
	
	public void setController(Controller controller);

}
