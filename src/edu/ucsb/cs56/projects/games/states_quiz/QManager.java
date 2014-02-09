package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;

/** 
	QManager manages the current question and score
	@author Nina Kaufman
*/

public class QManager{
	private GUI gui;
	private Geopanel geo;
	private int currentQ;
	private int currentScore;

	private String[] stateNames;


/** Constructor
	QManager creates a new array of the fifty state names
*/

	public QManager(){

		stateNames = new String[50];	

	}

/**
	Sets the current question and score to zero and then asks the first question. Also gets the GUI and Geopanel from geomain.
*/

	public void init()
	{
		gui = geomain.getGUI();
		geo = gui.getGeopanel();

		currentQ = 0;
		currentScore = 0;

		this.askNextQuestion();
	}

/**
	Asks the next question if the question counter is less than 50. Prints out the current state.
*/

	public void askNextQuestion()
	{
		if(currentQ < 50)
		{
			geomain.getGUI().setText("Click on: " + stateNames[currentQ] + " ");
			geo.setAnswer(geo.states[currentQ]);
		}
		else
			geomain.getGUI().setText("You're finished! Yay!");
	}

/**
	Receives the answer from Geopanel and checks to see if the answer is equivalent to the current state. Prints out the current score and increments the counters.
*/

	public void receiveAnswer(Object a)
	{
		JButton answer = (JButton)a;

		if(answer == geo.states[currentQ])
		{
			geomain.getGUI().setText("Congrats! ");
			currentQ++;
			currentScore++;
		}
		else
		{
			geomain.getGUI().setText("Nope! ");			
		}
		
		geomain.getGUI().setText("Your current score is: " + currentScore + "\n");
		this.askNextQuestion();
	}

/**
	Sets the name of the state.
*/

	public void setStateName(String name, int index)
	{
		stateNames[index] = name;
	}
	
}
