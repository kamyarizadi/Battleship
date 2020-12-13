package battleship.mvc.model;

public class Ship {
	String[] locations  = {"", "", ""};
	boolean[] hits = {false, false, false};
	
	public Ship(String cell1, String cell2, String cell3) {
		locations[0] = cell1;
		locations[1] = cell2;
		locations[2] = cell3;
	}

}
