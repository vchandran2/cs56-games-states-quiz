package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

/**
 * QuizFrontPage sets up the frame that opens up when a user starts the game.
 * 
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */
 
 public class QuizFrontPage extends JPanel{
 	
 	private JButton stateButton;
 	private JButton capitalButton;
 	
 	private BufferedImage map;
 	
 	
 	public QuizFrontPage(){
 		
 		stateButton = new JButton("States");
 		capitalButton = new JButton("Capitals");
 		
 		try{
	    	map = ImageIO.read(getClass().getClassLoader().getResource("image/front.jpg"));
		} catch(IOException ie){}
		this.repaint();
 		
 		
 		//this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
 		//stateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
 		//capitalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
 		this.add(stateButton);
 		this.add(capitalButton);
 		this.setVisible(true);
 		
 	}
 	
 	public void paintComponent(Graphics g){
	 g.drawImage(map, 0, 0,980,680, this);
	    
    }
 
 }
 