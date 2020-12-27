package battleship.mvc.controller;

import javax.swing.JOptionPane;

import battleship.mvc.model.Model;
import battleship.mvc.view.View;

public class Controller {
	private static Controller controller = null;
	
	private Model model;
	private View view;
	
	private int guesses = 0;

	
	/**
	 * Controller is created as singleton pattern
	 */
	private Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public static Controller createController(Model model, View view) {
		if(controller != null) {
			return controller;			
		}
		controller = new Controller(model, view);
		return controller;			
	}
	
	public void processGuess(String guess) {
		String location = parseGuess(guess);
		if(location != null) {
			this.guesses++;
			boolean hit = model.fire(location);
			if (hit && model.getShipsSunk() == model.getNumShips()) {
				view.displayMessage("You sank all my battleships, in " +
				this.guesses + " guesses");
			}
		}
	}

	private String parseGuess(String guess) {
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		
		if (guess == null || guess.length() != 2) {
			JOptionPane.showMessageDialog(null, "Oops, please enter a letter and a number on the board.");
		}
		else {
			char firstChar = guess.charAt(0);
			int row = this.indexOf(alphabet, firstChar);
			
			char column = guess.charAt(1);
			
			if (!(column >= '0' && column <= '9')){ //isNan(row) is not applicable here
				JOptionPane.showMessageDialog(null, "Oops, that isn't on the board.");				
			}
			else if(row < 0 || row >= model.getBoardSize() || Character.getNumericValue(column) >= model.getBoardSize()){
				JOptionPane.showMessageDialog(null, "Oops, that's off the board!");
			}
			else {
				return String.valueOf(new char[] {Character.forDigit(row, 10), column});
			}			
		}
		
		return null;
	}
	
	/**
	 * This method is designed only to test the parseGuess method 
	 * since parseGuess method is private and could not be tested out of the class scope
	 */	
	public void TestParseGuess() {
		System.out.println(controller.parseGuess("A0"));
		System.out.println(controller.parseGuess("B6"));
		System.out.println(controller.parseGuess("G3"));
		System.out.println(controller.parseGuess("H0"));
		System.out.println(controller.parseGuess("A7"));
		//The following test is besides above advised in the book
		System.out.println(controller.parseGuess("AA")); 		
		
	}
	
	
	
	private int indexOf(char[] cList, char c) {
		for(int i = 0; i < cList.length; ++i)
			if(cList[i] == c)
				return i;
		return -1;
	}
	
}
