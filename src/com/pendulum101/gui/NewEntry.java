package com.pendulum101.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class NewEntry extends JFrame{
	private static final long serialVersionUID = -6513591532165233033L;
	//TODO create New Entry Screen
	JTextField entryTitle;
	JFormattedTextField todaysDate;
	JTextArea entry;
	JButton save, cancel, clear;
	
	public NewEntry(){
		setTitle("New Entry");
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
//		link to the home menu;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//TODO fill in the rest of the fields
		
		
		
		save = new JButton("Save");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		add(save,c);
		
		pack();
		setLocationRelativeTo(null);
	}
}
