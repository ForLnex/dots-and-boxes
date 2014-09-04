package gui;

import data.MethodHolder;
import data.Line;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LineButton extends JButton implements ActionListener{
	private final Dimension		HORIZONTALSIZE	= new Dimension(40, 10);
	private final Dimension		VERTICALSIZE	= new Dimension(10, 40);
	public final MethodHolder	FUNCTION;
	public final Line				DATALINE;

	public LineButton(MethodHolder function, Line lineIn, boolean isHLine){
		this.FUNCTION = function;
		this.DATALINE = lineIn;

		DATALINE.linkLineButton(this);

		if (isHLine)
			this.setPreferredSize(HORIZONTALSIZE);
		else
			this.setPreferredSize(VERTICALSIZE);

		this.setEnabled(true);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		FUNCTION.takeLine(this.DATALINE);
	}

	public void takeLine(){
		this.setEnabled(false);
		this.setBackground(FUNCTION.gameData.currentPlayer.PLAYERCOLOR);
	}
}