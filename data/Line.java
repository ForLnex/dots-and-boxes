package data;

import gui.LineButton;

public class Line{
	public final int	xPosition, yPosition;
	public final boolean	isFirstEdge, isLastEdge, isHLine;
	public int				boxes;
	public boolean			used;
	public LineButton		lineButton;
	public Box				box1, box2;

	public Line(int lastEdge, int x, int y, boolean isHLine){
		this.xPosition = x;
		this.yPosition = y;
		this.isHLine = isHLine;
		this.boxes = 0;
		this.used = false;

		if (isHLine){
			if (yPosition == 0)
				this.isFirstEdge = true;
			else
				this.isFirstEdge = false;
			if (yPosition == lastEdge)
				this.isLastEdge = true;
			else
				this.isLastEdge = false;
		}else{
			if (xPosition == 0)
				this.isFirstEdge = true;
			else
				this.isFirstEdge = false;
			if (xPosition == lastEdge)
				this.isLastEdge = true;
			else
				this.isLastEdge = false;
		}
	}

	public void linkLineButton(LineButton lineButton){
		this.lineButton = lineButton;
	}

	public void linkBox(Box box){
		if (boxes == 0)
			this.box1 = box;
		else
			this.box2 = box;
		++boxes;
	}
}