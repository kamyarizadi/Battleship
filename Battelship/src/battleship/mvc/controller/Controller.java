package battleship.mvc.controller;

import javax.swing.JOptionPane;

import battleship.mvc.model.Model;

public class Controller {
	private static Controller controller = null;
	
	private Model model;
	
	private int guesses = 0;

	
	/**
	 * Controller is created as singleton pattern
	 */
	private Controller(Model model) {
		this.model = model;
	}
	
	public static Controller createController(Model model) {
		if(controller != null) {
			return controller;			
		}
		controller = new Controller(model);
		return controller;			
	}
	
	public void processGuess(String guess) {
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
	 * since this method is private and could not be tested out of the class scope
	 */	
	public static void TestParseGuess() {
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
