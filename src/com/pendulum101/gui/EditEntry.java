package com.pendulum101.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.pendulum101.dao.*;
import javax.swing.*;

public class EditEntry extends JFrame{
	private static final long serialVersionUID = -6513591532165233033L;
//TODO 2 create New journalEntry Screen
	JPanel top, mid, bottom;
	JTextField journalEntryTitle;
	JFormattedTextField entryDate;
	JTextArea journalEntry;
	JScrollPane scrollPane;
	JButton save, cancel, clear;
	
	public EditEntry(){
		// frame config
		setTitle("New journalEntry");
		setMinimumSize(new Dimension(380, 180));
		setVisible(true);
		setLayout(new GridBagLayout());
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		
		// JPanel config
		top = new JPanel();
		c.gridy = 0;
		this.add(top, c);
		mid = new JPanel(new GridLayout());
		c.gridy = 1;
		this.add(mid, c);
		bottom = new JPanel();
		c.gridy = 2;
		this.add(bottom, c);		

		// XMLAccess
//TODO 1 must select the correct entry details to update
		final XMLAccess journalXML = new XMLAccess();
		journalXML.readXML("resources/data/journal.xml");
		
//TODO 4 Have title disappear when you start typing 		
		// top panel: title and date
		journalEntryTitle = new JTextField(journalXML.getTitle(), 20);
		top.add(journalEntryTitle);		
//TODO 2 Show todays date by default
		entryDate = new JFormattedTextField(journalXML.getDate());
		top.add(entryDate);			

		// mid panel: journal entry
		journalEntry = new JTextArea(journalXML.getEntryContents(), 5, 30);
		scrollPane = new JScrollPane( journalEntry );
		mid.add(scrollPane);	
		
//TODO 5 Insert mood Selection
		
		// bottom panel: Buttons at Bottom of the page
		save = new JButton("Save");
		bottom.add(save);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				journalXML.setTitle(journalEntryTitle.getText());
				journalXML.setEntryContents(journalEntry.getText());
				journalXML.setDate(entryDate.getText());
				journalXML.saveToXML("resources/data/journal2.xml");
				dispose();
			}
		});
		
		clear = new JButton("Clear");
		bottom.add(clear);
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				journalEntryTitle.setText("Title");
				journalEntry.setText("");
			}
		});
		
		cancel = new JButton("Cancel");
		bottom.add(cancel);

//TODO 5 add popup when clicking cancel to warn user data will be lost
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent ae){
				dispose();
			}
		});
		
		pack();
	}
	
	public static void main(String[] args){
		new EditEntry();
	}
}
