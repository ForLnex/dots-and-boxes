package players;

import data.MethodHolder;
import javax.swing.JOptionPane;

public class Human extends Player{
	public final boolean	PROMPTNEEDED;

	public Human(MethodHolder function, int playerNumber, String playerName, boolean promptNeeded){
		super(function, playerNumber, playerName);
		this.PROMPTNEEDED = promptNeeded;
	}

	public void takeTurn(){
		if (PROMPTNEEDED)
			JOptionPane.showMessageDialog(FUNCTION.MAINFRAME, "It is now Player " + PLAYERNUMBER + "'s turn.", "Next Turn",
					javax.swing.JOptionPane.INFORMATION_MESSAGE);
	}
}