package players;

import java.util.Vector;
import data.Line;
import data.Box;
import data.MethodHolder;

public class AI extends Player{
	protected Vector<Line>	validLines;
	protected Vector<Box>	validBoxes;

	public AI(MethodHolder function, int playerNumber, String playerName){
		super(function, playerNumber, playerName);
		validLines = new Vector<Line>();
		validBoxes = new Vector<Box>();
	}

	public void startTurn(){
		FUNCTION.MAINFRAME.gameP.setEnabled(false);
		validLines = FUNCTION.gameBoard.availableLines();
		validBoxes = FUNCTION.gameBoard.availableBoxes();
	}
}