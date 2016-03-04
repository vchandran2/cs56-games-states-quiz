package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** GameFrame sets and initializes the frame and QuestionManager.
 @author Nina Kaufman
 @author Jenny Vien
 @author Zhansaya Abdikarimova
 @author Nick Eidler
 @author Ryan Allen
 @author Ryan Kemper
 */

public class GameFrame extends JFrame implements ActionListener {

    private static Dimension frameDimension = new Dimension(980, 680);

    private GamePanel gamePanel;
    private FrontPanel frontPanel;
    private QuestionManager questionManager;
    
    public static void main(String[] args) {
        new GameFrame();
    }

    public GameFrame() {
        gamePanel = new GamePanel();

        frontPanel = new FrontPanel();
	
        frontPanel.getStateButton().addActionListener(this);
        frontPanel.getCapitalButton().addActionListener(this);
        frontPanel.getStateThenCapitalButton().addActionListener(this);

        this.setResizable(false);
        this.getContentPane().add(gamePanel);
	this.getContentPane().add(frontPanel);
        this.setMinimumSize(frameDimension);

        this.setTitle("You think you know all US states?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
	frontPanel.setVisible(false);
	gamePanel.setVisible(true);
	questionManager = new QuestionManager(gamePanel);
	
        if(e.getActionCommand().matches("Capitals")){
	    questionManager.setGameMode("Capitals");
	    System.out.println("Capitals");
	    this.setTitle("Capitals");
	}
        else if (e.getActionCommand().matches("States")){
	    questionManager.setGameMode("States");
            System.out.println("States");
	    this.setTitle("States");
        }
	else if (e.getActionCommand().matches("State then Capitals")){
	    questionManager.setGameMode("States then Capitals");
	    System.out.println("States then Capitals");
	    this.setTitle("States then Capitals");
        }
	ButtonModel selectedDiff = frontPanel.getDifficultiesGroup().getSelection();
	questionManager.init();
	questionManager.setDifficulty(selectedDiff.getActionCommand());
	System.out.println(questionManager.getDifficulty());
    }
}
