package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewGamePlayerPanel extends JPanel{
	public final String[]		playerTypes	= { "Human Player", "Easy AI", "Medium AI", "Hard AI", "Very Hard AI" };
	private JTextField			playerTF;
	private JLabel					playerTypeL;
	private JComboBox<String>	playerTypeCom;
	private JCheckBox				promptNeededChk;
	private int						mod;

	NewGamePlayerPanel(int playerNumber){
		mod = 1;
		GridBagConstraints c = new GridBagConstraints();

		this.setLayout((LayoutManager) new GridBagLayout());

		playerTF = new JTextField("Player " + playerNumber);
		playerTF.setPreferredSize(new Dimension(60, 20));
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		this.add(playerTF, c);

		playerTypeL = new JLabel("Player Type:");
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 1;
		this.add(playerTypeL, c);

		playerTypeCom = new JComboBox<String>(playerTypes);
		playerTypeCom.setSelectedIndex(0);
		playerTypeCom.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				newType();
			}
		});
		c.gridy = 2;
		this.add(playerTypeCom, c);

		promptNeededChk = new JCheckBox("Prompt Player", false);
		promptNeededChk.setEnabled(true);
		promptNeededChk.addItemListener(new java.awt.event.ItemListener(){
			public void itemStateChanged(java.awt.event.ItemEvent evt){
				newMod();
			}
		});
		c.gridy = 3;
		this.add(promptNeededChk, c);
	}

	public void newType(){
		if (playerTypeCom.getSelectedIndex() == 0)
			promptNeededChk.setEnabled(true);
		else{
			promptNeededChk.setEnabled(false);
			promptNeededChk.setSelected(false);
		}
	}

	public void newMod(){
		if (mod == 1)
			mod = 2;
		else
			mod = 1;
	}

	public String getName(){
		return playerTF.getText();
	}

	public int getType(){
		return ( (playerTypeCom.getSelectedIndex() - 1) * mod);
	}
}