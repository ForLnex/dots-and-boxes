package data;

import java.util.Vector;

public class BoxesArray{
	public final int	xDots, yDots;
	private Box[][]	boxes;
	private Line[][]	hLines, vLines;

	BoxesArray(int xDotsIn, int yDotsIn){
		this.xDots = xDotsIn;
		this.yDots = yDotsIn;

		hLines = new Line[xDots - 1][yDots];
		vLines = new Line[xDots][yDots - 1];
		boxes = new Box[xDots][yDots];

		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots; ++j)
				hLines[i][j] = new Line(yDots - 1, i, j, true);

		for (int i = 0; i < xDots; ++i)
			for (int j = 0; j < yDots - 1; ++j)
				vLines[i][j] = new Line(xDots - 1, i, j, false);

		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots - 1; ++j)
				boxes[i][j] = new Box(hLines[i][j], hLines[i][j + 1], vLines[i][j], vLines[i + 1][j]);
	}

	// North South West East

	public Line getHLine(int x, int y){
		return this.hLines[x][y];
	}

	public Line getVLine(int x, int y){
		return this.vLines[x][y];
	}

	public Box getBox(int x, int y){
		return this.boxes[x][y];
	}

	public Vector<Line> availableLines(){
		Vector<Line> lines = new Vector<Line>();
		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots; ++j)
				if (!hLines[i][j].used)
					lines.add(hLines[i][j]);

		for (int i = 0; i < xDots; ++i)
			for (int j = 0; j < yDots - 1; ++j)
				if (!vLines[i][j].used)
					lines.add(vLines[i][j]);

		return lines;
	}

	public Vector<Box> availableBoxes(){
		Vector<Box> unownedBoxes = new Vector<Box>();
		for (int i = 0; i < xDots - 1; ++i)
			for (int j = 0; j < yDots - 1; ++j)
				if (boxes[i][j].ownedBy() == 0)
					unownedBoxes.add(boxes[i][j]);

		return unownedBoxes;
	}
}