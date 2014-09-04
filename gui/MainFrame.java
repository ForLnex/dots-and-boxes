package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.BoxesArray;
import data.MethodHolder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	public final MethodHolder	FUNCTION;
	public JPanel					contentP;
	public GamePanel				gameP;
	public ScorePanel				scoreP;

	public MainFrame(){
		FUNCTION = new MethodHolder(this);

		this.setTitle("Dots and Boxes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(205, 75));
		this.setResizable(false);
		this.setJMenuBar(new MainMenuBar(FUNCTION));

		contentP = new JPanel();
		contentP.setLayout((LayoutManager) new GridBagLayout());
		this.setContentPane(contentP);

		this.setVisible(true);
	}

	public void redraw(MethodHolder FUNCTION, BoxesArray GAMEBOARD, int xDots, int yDots){
		GridBagConstraints c = new GridBagConstraints();

		contentP.removeAll();

		gameP = new GamePanel(FUNCTION, GAMEBOARD, xDots, yDots);
		c.gridy = 0;
		c.gridx = GridBagConstraints.REMAINDER;
		contentP.add(new GamePanel(FUNCTION, GAMEBOARD, xDots, yDots), c);

		scoreP = new ScorePanel(FUNCTION);
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridx = GridBagConstraints.REMAINDER;
		contentP.add(scoreP, c);

		this.pack();
	}

	public static void main(String[] args){
		new MainFrame();
	}
}