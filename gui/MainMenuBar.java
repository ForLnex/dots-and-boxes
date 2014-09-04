package gui;

import data.MethodHolder;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenuBar extends JMenuBar{
	public final MethodHolder	FUNCTION;

	public MainMenuBar(MethodHolder function){
		this.FUNCTION = function;
		this.add(new GeneralFileMenu(FUNCTION));
	}
}
