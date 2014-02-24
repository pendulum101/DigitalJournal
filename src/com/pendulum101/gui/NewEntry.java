package com.pendulum101.gui;

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
//		setLayout();
//		link to the home menu;
//		setDefaultCloseOperation();
		add();
	}
}
