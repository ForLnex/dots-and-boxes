// Uses high level strategy.

package players;

import data.MethodHolder;

public class VeryHardAI extends MediumAI{
	public VeryHardAI(MethodHolder function, int playerNumber, String playerName){
		super(function, playerNumber, playerName);
	}

	public void takeTurn(){
		startTurn();
	}
}