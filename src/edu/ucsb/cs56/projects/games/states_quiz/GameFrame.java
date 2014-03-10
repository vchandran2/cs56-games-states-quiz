package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;

/** GameFrame sets and initializes the frame and QuestionManager.
    @author Nina Kaufman
    @author Jenny Vien
    @author Zhansaya Abdikarimova
*/

public class GameFrame extends JFrame implements ActionListener{

    private static GamePanel gamePanel;
    private FrontPanel frontPanel;
    private static QuestionManager questionManager;

    
    public GameFrame(){
		
	
	questionManager = new QuestionManager();		
	gamePanel = new GamePanel();
	
	frontPanel = new FrontPanel();
	frontPanel.getStateButton().addActionListener(this);
	frontPanel.getCapitalButton().addActionListener(this);
		
		
	this.setSize(980, 680);
	this.setTitle("You think you know all US states?");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.getContentPane().add(gamePanel);
	this.getContentPane().add(frontPanel);
	this.setVisible(true);
    }
	

    /**
     * @return GUI frame the whole window of the game
     */
    public static GamePanel getGamePanel(){
	return gamePanel;
    }

    /**
     * @return questionManager  
     */

    public static QuestionManager getQuestionManager(){
	return questionManager;
    }
	
    @Override
    public void actionPerformed(ActionEvent e){
	String option;
	frontPanel.setVisible(false);
	gamePanel.setVisible(true);
	if(e.getActionCommand().matches("Capitals")){
			
	    option = "Capital";
	    System.out.println("Capitals");
	    
	}
	else {
	    option = "State";
	    System.out.println("States");
	}
	questionManager.setOption(option);
	questionManager.init();
    }

}
