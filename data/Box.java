package data;

import gui.BoxPanel;
import players.Player;

public class Box{
	private Line		north, south, west, east;
	private int			ownedBy;
	public BoxPanel	boxPanel;

	Box(){
		north = south = west = east = null;
	}

	Box(Line northIn, Line southIn, Line westIn, Line eastIn){
		ownedBy = 0;
		this.north = northIn;
		north.linkBox(this);
		this.south = southIn;
		south.linkBox(this);
		this.west = westIn;
		west.linkBox(this);
		this.east = eastIn;
		east.linkBox(this);
	}

	public int ownedBy(){
		return this.ownedBy;
	}

	public int sidesLeft(){
		int sidesLeft = 4;
		if (north.used)
			--sidesLeft;
		if (south.used)
			--sidesLeft;
		if (west.used)
			--sidesLeft;
		if (east.used)
			--sidesLeft;

		return sidesLeft;
	}

	public Line getValidSide(){
		if (!north.used)
			return north;
		if (!south.used)
			return south;
		if (!west.used)
			return west;
		if (!east.used)
			return east;
		return null;
	}

	public boolean justTaken(Player currentPlayer){
		if (this.sidesLeft() == 0 && this.ownedBy() == 0){
			this.ownedBy = currentPlayer.PLAYERNUMBER;
			return true;
		}else
			return false;
	}

	public void linkBoxPanel(BoxPanel boxPanel){
		this.boxPanel = boxPanel;
	}
}