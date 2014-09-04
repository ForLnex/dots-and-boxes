// Completes the most boxes possible, then makes a random move that does not add a third side to a box.

package players;

import data.MethodHolder;

public class HardAI extends AI{
	public HardAI(MethodHolder function, int playerNumber, String playerName){
		super(function, playerNumber, playerName);
	}

	public void takeTurn(){
		startTurn();
	}
}