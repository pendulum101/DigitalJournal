package com.pendulum101.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame {
	private static final long serialVersionUID = -2658352827263601379L;
	JLabel label = new JLabel("Welcome to Your Digital Journal");
//TODO 2 add functionality to the buttons 
		JButton newEntry, calendar, scrollView ,logout;
		
		public Home(){
			setTitle("Digital Journal");
			setLayout(new GridLayout(2,2));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			setMinimumSize(new Dimension(300, 180));
			setAlwaysOnTop(true);
			setLocationRelativeTo(null);
			
			newEntry = new JButton("New Entry");
			calendar = new JButton("Calendar View");
			scrollView = new JButton("Scroll View");
			logout = new JButton("Logout"); 
			
			add(newEntry);
			add(calendar);
			add(scrollView);
			add(logout);

			//Hit Enter for new journal entry screen
//			newEntry.requestFocus();
//			
//			KeyAdapter k = new KeyAdapter() {
//				public void keyPressed(KeyEvent ke){
//					if(ke.getKeyCode() == KeyEvent.VK_ENTER)
//						newEntry.doClick();
//				}
//			};
//			
//			newEntry.addKeyListener(k);
			
			newEntry.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					new NewEntry();
				}
			});

			
			pack();
		}
		public static void main(String[] args){
			new Home();
		}
}
