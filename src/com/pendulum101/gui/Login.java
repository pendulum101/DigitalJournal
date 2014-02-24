package com.pendulum101.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
	private static final long serialVersionUID = 922748467593428542L;
	JButton login, cancel;
	JLabel u, p;
	JTextField uName;
	JPasswordField pass;

	public Login(){
		setTitle("Digital Journal");
		setLayout(new GridLayout(3,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		u = new JLabel("Username");
		p = new JLabel("Password");
		u.setHorizontalAlignment(JLabel.CENTER);
		p.setHorizontalAlignment(JLabel.CENTER);
		
		uName = new JTextField(10);
		pass = new JPasswordField(10); 		

		login = new JButton("Login");
		cancel = new JButton("Cancel");

		add(u);
		add(uName);

		add(p);
		add(pass);

		add(login);
		add(cancel);

		uName.requestFocus();

		cancel.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent ae){
				System.exit(0);
			}
		});

		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String un = uName.getText();
				String pa = new String(pass.getPassword());

				if ((un.equals("myuser")) && pa.equals("mypass")){
					dispose();
					new Home();
				}
			}
		});

		KeyAdapter k = new KeyAdapter() {
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_ENTER)
					login.doClick();
			}
		};
		
		pass.addKeyListener(k);
		uName.addKeyListener(k);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	protected ImageIcon createImageIcon(String url, String description) {
		java.net.URL imgURL = getClass().getResource(url);
		if (imgURL != null){
			return new ImageIcon(imgURL, description);
		} else{
			System.err.println("Couldn't find file:" + url);
			return null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new Login();
			}
		});
	}

}
