// Completes the most boxes possible, then makes a random valid move.

package players;

import data.MethodHolder;
import data.Box;

public class MediumAI extends EasyAI{
	public MediumAI(MethodHolder function, int playerNumber, String playerName){
		super(function, playerNumber, playerName);
	}

	public void takeTurn(){
		startTurn();
		if (completePossibleBoxes())
			randomValidMove();
	}

	public boolean completePossibleBoxes(){
		Box boxToTake;

		boxToTake = null;
		for (int i = 0; i < validBoxes.size(); ++i)
			if (validBoxes.elementAt(i).sidesLeft() == 1)
				boxToTake = validBoxes.elementAt(i);

		if (boxToTake != null){
			FUNCTION.takeLine(boxToTake.getValidSide());
			return false;
		}
		return true;
	}
}