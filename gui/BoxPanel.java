package gui;

import data.MethodHolder;
import data.Box;
import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoxPanel extends JPanel{
	public final MethodHolder	FUNCTION;
	public final Box				DATABOX;
	private JPanel					iBox;

	BoxPanel(MethodHolder function, Box boxIn){
		this.FUNCTION = function;
		this.DATABOX = boxIn;

		DATABOX.linkBoxPanel(this);

		this.setLayout(new GridBagLayout());
		this.setSize(new Dimension(40, 40));

		iBox = new JPanel();
		iBox.setPreferredSize(new Dimension(this.getWidth() - 4, this.getHeight() - 4));
		this.add(iBox);
	}

	public void takeBox(Color colorIn){
		iBox.setBackground(colorIn);
	}
}