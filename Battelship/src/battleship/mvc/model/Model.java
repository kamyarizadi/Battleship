package battleship.mvc.model;

import battleship.mvc.view.View;

public class Model {
	
	private static Model model;
	
	private View view;
	
	int boardSize = 7;
	int numShips = 3;
	int shipLength = 3;
	int shipsSunk = 0;
	Ship[] ships;
	
	
	private Model(View view) {
		this.view = view;
		
		ships = new Ship[numShips];
		
		ships[0] = new Ship("06", "16", "26");
		ships[1] = new Ship("24", "34", "44");
		ships[2] = new Ship("10", "11", "12");				
	}
	
	
	public static Model createModel(View view) {
		if(model != null)
			return model;
		model = new Model(view);
		return model;
	}
	
	
	public int getBoardSize() {
		return this.boardSize; 
	}
	
	/**
	 * This methods accept a guess and verifies if it hits a ship or not
	 * @param guess
	 * @return
	 */
	public boolean fire(String guess) {
		for(int i = 0; i <numShips; ++ i) {
			Ship ship = this.ships[i];
			
			int index = indexOf(ship, guess);
			if(index >= 0) {
				ship.hits[index] = true;
				view.displayHit(guess);
				view.displayMessage("HIT!");
				if(isSunk(ship)) {
					view.displayMessage("you sank my battleship!");
					this.shipsSunk++;
				}
				return true;
			}
		}
		
		view.displayMiss(guess);
		view.displayMessage("You missed.");
		
		return false;
	}
	
	private int indexOf(Ship ship, String guess) {
		for(int i = 0; i < this.shipLength; ++i) {
			if(ship.locations[i].equals(guess))
				return i;
		}
		return -1;
	}
	
	/**
	 * This method is going to take a ship and return true if it is sunk
	 * @param ship
	 * @return
	 */
	public boolean isSunk(Ship ship) {
		for(int i = 0; i < this.shipLength; ++i) {
			if(ship.hits[i] != true) {
				return false;
			}
		}
		return true;
	}
}
