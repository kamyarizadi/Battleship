package battleship.mvc.model;

import java.util.Random;

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
		
//		ships[0] = new Ship("06", "16", "26");
//		ships[1] = new Ship("24", "34", "44");
//		ships[2] = new Ship("10", "11", "12");
		
		/**
		 * ships are created with no location 
		 * locations are created by calling generateShipLocations
		 */
		ships[0] = new Ship("", "", "");
		ships[1] = new Ship("", "", "");
		ships[2] = new Ship("", "", "");
		
		
		this.generateShipLocations();
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

	public int getNumShips() {
		return numShips;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	
	private void generateShipLocations() {
		String[] locations;
		for (var i = 0; i < this.numShips; i++) {
			do {
				locations = this.generateShip();
				} while (this.collision(locations));
			this.ships[i].locations = locations;
		}
	}
	
	private String[] generateShip() {
		Random random = new Random();
		int direction = random.nextInt(2);
		
		int row, col;
		if(direction == 1) {
			row = random.nextInt(this.boardSize);
			col = random.nextInt(this.boardSize - 3);
		} else {
			row = random.nextInt(this.boardSize - 3);
			col = random.nextInt(this.boardSize);			
		}
		
		String[] newLocations = new String[this.shipLength];
		for(int i = 0; i <this.shipLength; ++i) {
			if(direction == 1) {
				newLocations[i] = String.valueOf(new char[] {Character.forDigit(row, 10), Character.forDigit(col + i, 10)});
			} else {
				newLocations[i] = String.valueOf(new char[] {Character.forDigit(row + i, 10), Character.forDigit(col, 10)});
			}
			
		}
		
		return newLocations;
	}
	
	private boolean collision(String[] locations) {
		for (int i = 0; i < this.numShips; i++) {
			Ship ship = this.ships[i];
			for(int j = 0; j < locations.length; ++j) {
				if(indexOf(ship, locations[j]) >= 0) {
					return true;
				}
			}
		}
		return false;
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
	
	/**
	 * returns the index of location indicates by parameter guess
	 * if guess is one of locations occupied by ship 
	 * @param ship
	 * @param guess: location which we want to test if it is on the ship or not
	 * @return position of ship which guess is located on it
	 */
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
