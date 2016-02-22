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
 */

public class GameFrame extends JFrame implements ActionListener {

    private static Dimension frameDimension = new Dimension(980, 680);

    private GamePanel gamePanel;
    private FrontPanel frontPanel;
    private QuestionManager questionManager;
    private DifficultyPanel difficultyPanel;
    
    public static void main(String[] args) {
        new GameFrame();
    }

    public GameFrame() {
        gamePanel = new GamePanel();
	difficultyPanel = new DifficultyPanel();
        frontPanel = new FrontPanel();
	
	difficultyPanel.getEasyButton().addActionListener(this);
	difficultyPanel.getNormalButton().addActionListener(this);
	difficultyPanel.getHardButton().addActionListener(this);

        frontPanel.getStateButton().addActionListener(this);
        frontPanel.getCapitalButton().addActionListener(this);
        frontPanel.getStateThenCapitalButton().addActionListener(this);

        this.setResizable(false);
        this.getContentPane().add(gamePanel);
	this.getContentPane().add(difficultyPanel);
	this.getContentPane().add(frontPanel);
        this.setMinimumSize(frameDimension);

        this.setTitle("You think you know all US states?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
	//        frontPanel.setVisible(false);
	//	difficultyPanel.setVisible(true);
	//        gamePanel.setVisible(true);
        if(e.getActionCommand().matches("Capitals")){
	    frontPanel.setVisible(false);
	    difficultyPanel.setVisible(true);
            questionManager = new CapitalQuestionManager(gamePanel);
            System.out.println("Capitals");
        }
        else if (e.getActionCommand().matches("States")){
	    frontPanel.setVisible(false);
	    difficultyPanel.setVisible(true);
	    questionManager = new StateQuestionManager(gamePanel);
            System.out.println("States");
        }
	else if (e.getActionCommand().matches("States then Capitals")){
	    frontPanel.setVisible(false);
	    difficultyPanel.setVisible(true);
	    questionManager = new StateThenCapitalQuestionManager(gamePanel);
            System.out.println("States then Capitals");
        }
	else if(e.getActionCommand().matches("Easy")){
	    difficultyPanel.setVisible(false);
	    gamePanel.setVisible(true);
	    questionManager.init();
	}
	else if(e.getActionCommand().matches("Normal")){
	    difficultyPanel.setVisible(false);
	    gamePanel.setVisible(true);
	    questionManager.init();
	}
	else {
	    difficultyPanel.setVisible(false);
	    gamePanel.setVisible(true);
	    questionManager.init();
	}
    }
}
