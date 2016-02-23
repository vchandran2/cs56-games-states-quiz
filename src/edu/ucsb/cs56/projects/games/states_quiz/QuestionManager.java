package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.util.ArrayList;

/**
 * QuestionManager manages the current question and score
 *
 * @author Nina Kaufman
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 * @author Nick Eidler
 */

public abstract class QuestionManager {
    protected GamePanel gamePanel;
    protected MapPanel mapPanel;

    protected String difficulty;
    protected String option;
    protected int currentQuestion;
    protected int randIndex;
    protected int currentScore;

    protected ArrayList<State> states;
    protected ArrayList<Integer> randStateIndexes;
    protected ArrayList<State> correctStates;
    protected ArrayList<JButton> hiddenButtons;


    /**
     * Constructor QuestionManager creates a new array of the fifty state names
     */
    public QuestionManager(GamePanel parent) {
        states = new ArrayList<State>();
        correctStates = new ArrayList<State>();
        randStateIndexes = new ArrayList<Integer>();
	hiddenButtons = new ArrayList<JButton>();

        gamePanel = parent;
        mapPanel = gamePanel.getMapPanel();
        mapPanel.setQuestionManager(this);
        states = mapPanel.getCountry().getStatesArray();

        for(int i=0;i<states.size();i++){
            randStateIndexes.add(i);
        }
    }

    /**
     * Sets the current question and score to zero and then asks the first
     * question. Also gets the GUI and MapPanel from GameFrame.
     */
    public void init() {
        randIndex = (int) (Math.random() * states.size());
        currentQuestion = randStateIndexes.get(randIndex);
        currentScore = 0;

        this.askNextQuestion();
    }

    /**
     * Called by the MapPanel when a button is pressed on the screen.
     * @param o Object representing the button that was clicked.
     */
    public void mapClickCallback(Object o) {
        this.receiveAnswer(((JButton) o));
    }

    public State getCorrectState(){
	return this.states.get(currentQuestion);
    }

    public String getDifficulty(){
	return this.difficulty;
    }

    public void setDifficulty(String diff){
	this.difficulty = diff;
    }

    /**
     * Asks the next question if the question counter is less than 50. Prints
     * out the current state.
     */
    public abstract void askNextQuestion();

    /**
     * Receives the answer from MapPanel and checks to see if the answer is
     * equivalent to the current state. Prints out the current score and
     * increments the counters.
     */
    public abstract void receiveAnswer(JButton answerButton);

}
