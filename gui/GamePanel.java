package gui;

import data.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	public MethodHolder	FUNCTION;
	private int				xDots, yDots;
	private LineButton[][]	vLines, hLines;
	private BoxPanel[][]		boxes;

	public GamePanel(){}

	public GamePanel(MethodHolder function, BoxesArray data, int xDots, int yDots){
		GridBagConstraints c;

		this.FUNCTION = function;
		this.xDots = xDots;
		this.yDots = yDots;
		this.hLines = new LineButton[xDots - 1][yDots];
		this.vLines = new LineButton[xDots][yDots - 1];
		this.boxes = new BoxPanel[xDots][yDots];
		c = new GridBagConstraints();

		this.setLayout(new GridBagLayout());

		// Adds the horizontal lines to the GamePanel
		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots; ++j){
				hLines[i][j] = new LineButton(FUNCTION, data.getHLine(i, j), true);
				c.gridx = ( (i * 2) + 1);
				c.gridy = (j * 2);
				this.add(hLines[i][j], c);
			}

		// Adds the vertical lines to the GamePanel
		for (int i = 0; i < xDots; ++i)
			for (int j = 0; j < yDots - 1; ++j){
				vLines[i][j] = new LineButton(FUNCTION, data.getVLine(i, j), false);
				c.gridy = ( (j * 2) + 1);
				c.gridx = (i * 2);
				this.add(vLines[i][j], c);
			}

		// Adds the boxes to be drawn to the GamePanel
		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots - 1; ++j){
				boxes[i][j] = new BoxPanel(FUNCTION, data.getBox(i, j));
				c.gridx = ( (i * 2) + 1);
				c.gridy = ( (j * 2) + 1);
				this.add(boxes[i][j], c);
			}
	}

	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);

		if (enabled){
			for (int i = 0; i < xDots - 2; ++i)
				for (int j = 0; j < yDots - 1; ++j)
					hLines[i][j].setEnabled(!hLines[i][j].DATALINE.used);

			for (int i = 0; i < xDots - 1; ++i)
				for (int j = 0; j < yDots - 2; ++j)
					vLines[i][j].setEnabled(!vLines[i][j].DATALINE.used);
		}

		else{
			for (int i = 0; i < xDots - 2; ++i)
				for (int j = 0; j < yDots - 1; ++j)
					hLines[i][j].setEnabled(false);

			for (int i = 0; i < xDots - 1; ++i)
				for (int j = 0; j < yDots - 2; ++j)
					vLines[i][j].setEnabled(false);
		}
	}
}