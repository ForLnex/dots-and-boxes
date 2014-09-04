package gui;

import java.awt.*;
import data.MethodHolder;
import javax.swing.*;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel{
	public final MethodHolder	FUNCTION;
	private JLabel					score, player;
	private JLabel					player1Score, player2Score, currentPlayer;

	public ScorePanel(MethodHolder function){
		GridBagConstraints c;

		this.FUNCTION = function;
		this.setPreferredSize(new Dimension(200, 50));
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		score = new JLabel("Score:");
		c.gridx = 2;
		c.gridy = 0;
		this.add(score, c);

		player1Score = new JLabel("Player 1:");
		c.gridy = 1;
		this.add(player1Score, c);

		player2Score = new JLabel("Player 2:");
		c.gridy = 2;
		this.add(player2Score, c);

		player = new JLabel("Current Player:");
		c.insets = new Insets(0, 0, 0, 35);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		this.add(player, c);

		currentPlayer = new JLabel("");
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(currentPlayer, c);
	}

	public void updateScore(){
		player1Score.setText("Player 1: " + Integer.toString(FUNCTION.gameData.PLAYERONE.getPoints()));
		player2Score.setText("Player 2: " + Integer.toString(FUNCTION.gameData.PLAYERTWO.getPoints()));
		currentPlayer.setText(FUNCTION.gameData.currentPlayer.PLAYERNAME);
	}
}