package battleship.start;


import battleship.gui.Board;
import battleship.mvc.controller.Controller;
import battleship.mvc.model.Model;
import battleship.mvc.view.IBattleshipBoard;
import battleship.mvc.view.View;

public class Starter {

	protected static IBattleshipBoard board = null;
	protected static View view;
	protected static Model model; 
	protected static Controller controller;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main App");
		startGame();
	}

	
	public static void startGame() {
		board = Board.startBoard();
		view = View.createView(board);	
		model = Model.createModel(view);
		controller = Controller.createController(model);
	};

	

}
