package data;

import players.Player;

public class GameBoardData{
	public final MethodHolder	FUNCTION;
	public final Player			PLAYERONE, PLAYERTWO;
	public final int				TOTALBOXES;
	public Player					currentPlayer;
	public BoxesArray				GAMEBOARD;

	public GameBoardData(MethodHolder function, int player1Type, int player2Type, String player1Name, String player2Name, int xDots, int yDots){
		this.FUNCTION = function;
		this.PLAYERONE = FUNCTION.loadPlayer(player1Type, 1, player1Name);
		this.PLAYERTWO = FUNCTION.loadPlayer(player2Type, 2, player2Name);
		this.GAMEBOARD = new BoxesArray(xDots, yDots);
		FUNCTION.gameBoard = GAMEBOARD;
		this.TOTALBOXES = (xDots - 1) * (yDots - 1);
		FUNCTION.MAINFRAME.redraw(FUNCTION, GAMEBOARD, xDots, yDots);
		currentPlayer = PLAYERONE;
	}

	public boolean checkGameOver(){
		return (PLAYERONE.getPoints() + PLAYERTWO.getPoints() == TOTALBOXES);
	}

	public void nextPlayerTurn(boolean boxTaken){
		if (boxTaken)
			;
		else if (currentPlayer == PLAYERONE)
			currentPlayer = PLAYERTWO;
		else
			currentPlayer = PLAYERONE;

		FUNCTION.updateScore();
		currentPlayer.takeTurn();
	}
}