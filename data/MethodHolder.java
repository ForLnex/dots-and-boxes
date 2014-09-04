package data;

import gui.MainFrame;
import gui.NewGameFrame;

import javax.swing.JOptionPane;

import players.EasyAI;
import players.HardAI;
import players.Human;
import players.MediumAI;
import players.Player;
import players.VeryHardAI;

public class MethodHolder{
	public final MainFrame	MAINFRAME;
	public GameBoardData		gameData;
	public BoxesArray			gameBoard;

	public MethodHolder(MainFrame mainFrame){
		this.MAINFRAME = mainFrame;
	}

	public void fileNew(){
		@SuppressWarnings("unused")
		NewGameFrame fileNewFrame = new NewGameFrame(this);
	}

	public void fileSave(){}

	public void fileOpen(){}

	public void fileClose(){
		MAINFRAME.dispose();
	}

	public void newGame(int p1Type, int p2Type, String p1Name, String p2Name, int xDots, int yDots){
		gameData = new GameBoardData(this, p1Type, p2Type, p1Name, p2Name, xDots, yDots);
		updateScore();
		gameData.PLAYERONE.takeTurn();
	}

	public Player loadPlayer(int playerType, int playerNumber, String playerName){
		switch (playerType){
		case -2:
			return new Human(this, playerNumber, playerName, true); // human
																						// player
		case -1:
			return new Human(this, playerNumber, playerName, false);// human
																						// player
		case 0:
			return new EasyAI(this, playerNumber, playerName); // easy
																				// AI
																				// player
		case 1:
			return new MediumAI(this, playerNumber, playerName); // medium
																					// AI
																					// player
		case 2:
			return new HardAI(this, playerNumber, playerName); // hard
																				// AI
																				// player
		case 3:
			return new VeryHardAI(this, playerNumber, playerName); // very
																						// hard
																						// AI
																						// player
		default:
			return null;
		}
	}

	public void takeLine(Line lineIn){
		boolean boxTaken;

		boxTaken = false;
		lineIn.used = true;

		lineIn.lineButton.takeLine();

		if (lineIn.boxes == 1){
			if (lineIn.box1.justTaken(gameData.currentPlayer)){
				boxTaken = true;
				gameData.currentPlayer.addPoint();
				lineIn.box1.boxPanel.takeBox(gameData.currentPlayer.PLAYERCOLOR);
			}
			if (gameData.checkGameOver())
				gameOver();
			else
				gameData.nextPlayerTurn(boxTaken);
		}else{
			if (lineIn.box1.justTaken(gameData.currentPlayer)){
				boxTaken = true;
				gameData.currentPlayer.addPoint();
				lineIn.box1.boxPanel.takeBox(gameData.currentPlayer.PLAYERCOLOR);
			}
			if (lineIn.box2.justTaken(gameData.currentPlayer)){
				boxTaken = true;
				gameData.currentPlayer.addPoint();
				lineIn.box2.boxPanel.takeBox(gameData.currentPlayer.PLAYERCOLOR);
			}
			if (gameData.checkGameOver())
				gameOver();
			else
				gameData.nextPlayerTurn(boxTaken);
		}
	}

	public void updateScore(){
		MAINFRAME.scoreP.updateScore();
	}

	public void gameOver(){
		String gameOverMessage, winner;

		updateScore();

		if (gameData.PLAYERONE.getPoints() > gameData.PLAYERTWO.getPoints())
			winner = gameData.PLAYERONE.PLAYERNAME + " wins!";
		else if (gameData.PLAYERONE.getPoints() < gameData.PLAYERTWO.getPoints())
			winner = gameData.PLAYERTWO.PLAYERNAME + " wins!";
		else
			winner = "It's a tie!";

		gameOverMessage =
				new String("Final Score\n" + gameData.PLAYERONE.PLAYERNAME + ": " + gameData.PLAYERONE.getPoints() + "\n" + gameData.PLAYERTWO.PLAYERNAME
						+ " :" + gameData.PLAYERTWO.getPoints() + "\n" + winner);

		JOptionPane.showMessageDialog(MAINFRAME, gameOverMessage, "Game Over", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	}
}