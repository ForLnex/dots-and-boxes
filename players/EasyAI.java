// Makes a random valid move.

package players;

import data.*;

public class EasyAI extends AI{
	public EasyAI(MethodHolder function, int playerNumber, String playerName){
		super(function, playerNumber, playerName);
	}

	public void takeTurn(){
		startTurn();
		randomValidMove();
	}

	public void randomValidMove(){
		FUNCTION.takeLine(validLines.elementAt((int) (Math.random() * validLines.size())));
	}
}