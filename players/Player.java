package players;

import java.awt.Color;

import data.MethodHolder;

public class Player{
	public final MethodHolder	FUNCTION;
	public final int				PLAYERNUMBER;
	public final Color			PLAYERCOLOR;
	public final String			PLAYERNAME;
	protected int					points;

	Player(MethodHolder function, int playerNumber, String playerName){
		this.FUNCTION = function;
		this.PLAYERNUMBER = playerNumber;
		this.PLAYERNAME = playerName;

		if (this.PLAYERNUMBER == 1)
			this.PLAYERCOLOR = java.awt.Color.RED;
		else
			this.PLAYERCOLOR = java.awt.Color.BLUE;

		this.points = 0;
	}

	public void takeTurn(){}

	public int getPoints(){
		return this.points;
	}

	public void addPoint(){
		++this.points;
	}
}