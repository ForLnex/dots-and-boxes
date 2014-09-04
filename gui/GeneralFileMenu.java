/*
 * Author: Jason Bury Last Modified by: Jason Bury Date Modified: November 03, 2011 This class creates a typical "File" menu, with "new", "save",
 * "open", and "exit" menu items.
 */

package gui;

import javax.swing.*;

import data.MethodHolder;

@SuppressWarnings("serial")
public class GeneralFileMenu extends JMenu{
	public final MethodHolder	FUNCTION;
	private JMenuItem				menuItem;

	public GeneralFileMenu(MethodHolder function){
		this.FUNCTION = function;
		this.setText("File");

		menuItem = new JMenuItem("New");
		menuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				FUNCTION.fileNew();
			}
		});
		this.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				FUNCTION.fileSave();
			}
		});
		this.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				FUNCTION.fileOpen();
			}
		});
		this.add(menuItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				FUNCTION.fileClose();
			}
		});
		this.add(menuItem);
	}
}