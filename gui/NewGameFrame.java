package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import data.MethodHolder;

@SuppressWarnings("serial")
public class NewGameFrame extends JFrame{
	public final MethodHolder	FUNCTION;
	private JLabel					xDotsL, yDotsL;
	private JTextField			xDotsTF, yDotsTF;
	private NewGamePlayerPanel	player1P, player2P;
	private JButton				startGameB, cancelB;

	public NewGameFrame(MethodHolder function){
		GridBagConstraints c;

		this.FUNCTION = function;
		c = new GridBagConstraints();

		this.setTitle("New Game");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLayout((LayoutManager) new GridBagLayout());

		xDotsL = new JLabel("Horizontal Dots");
		xDotsL.setPreferredSize(new Dimension(90, 20));
		c.insets = new Insets(0, 10, 20, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		this.add(xDotsL, c);

		yDotsL = new JLabel("Vertical Dots");
		xDotsL.setPreferredSize(new Dimension(100, 20));
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 0;
		this.add(yDotsL, c);

		xDotsTF = new JTextField("3");
		xDotsTF.setPreferredSize(new Dimension(20, 20));
		xDotsTF.setHorizontalAlignment(JTextField.CENTER);
		c.insets = new Insets(0, 5, 20, 5);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		this.add(xDotsTF, c);

		yDotsTF = new JTextField("3");
		yDotsTF.setPreferredSize(new Dimension(20, 20));
		yDotsTF.setHorizontalAlignment(JTextField.CENTER);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		this.add(yDotsTF, c);

		player1P = new NewGamePlayerPanel(1);
		c.insets = new Insets(0, 10, 20, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		this.add(player1P, c);

		player2P = new NewGamePlayerPanel(2);
		c.insets = new Insets(0, 0, 20, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		this.add(player2P, c);

		startGameB = new JButton("Start Game");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		startGameB.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				startGame();
			}
		});
		this.add(startGameB, c);

		cancelB = new JButton("Cancel");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		cancelB.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				cancel();
			}
		});
		this.add(cancelB, c);

		this.pack();
		this.setVisible(true);
	}

	public void startGame(){
		this.dispose();
		FUNCTION.newGame(player1P.getType(), player2P.getType(), player1P.getName(), player2P.getName(), Integer.parseInt(xDotsTF.getText()),
				Integer.parseInt(yDotsTF.getText()));
	}

	public void cancel(){
		this.dispose();
	}
}
