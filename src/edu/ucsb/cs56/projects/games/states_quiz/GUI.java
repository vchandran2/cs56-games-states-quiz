package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
	GUI sets up the GUI with the frame that holds the text and the scrollbar.
	@author Nina Kaufman
*/

public class GUI {

	private Geopanel geo; //geo is a Geopanel reference
	private JFrame frame;
	private JTextArea text;
	private Font ourFont;	
	private JScrollPane scroll;

	public GUI(){
	
		ourFont = new Font("Arial", Font.PLAIN, 24);
		geo = new Geopanel(); 
				
		text = new JTextArea(4,20);
		text.setLineWrap(true);

		scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		text.setFont(ourFont);
		text.append("Welcome to the USA map quiz!\n");
		text.setEditable(false);
		frame = new JFrame();

		frame.setSize(713,639);
		frame.getContentPane().add(BorderLayout.CENTER,geo);
		frame.getContentPane().add(BorderLayout.SOUTH,scroll);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(20, 40);
		frame.setVisible(true);


		geo.repaint();
		
	}
	


/**
	Returns the text in the TextArea.
*/

	public JTextArea getTextArea()
	{
		return this.text;
	}

/**
	Adds text to the TextArea.
*/

	public void setText(String txt)
	{
		this.text.append(txt);
	}

/**
	Returns the Geopanel geo.
*/
	public Geopanel getGeopanel(){
		return this.geo;
	}
}

