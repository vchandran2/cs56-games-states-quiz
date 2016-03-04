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
 * @author Ryan Allen
 * @author Ryan Kemper
 */

public class QuestionManager {
    protected GamePanel gamePanel;
    protected MapPanel mapPanel;

    protected String gameMode;
    protected String difficulty;
    protected String option;
    protected int currentQuestion;
    protected int randIndex;
    protected int currentScore;
    protected int guesses = 0;
    
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

    /**
     * Called by the GameFrame when the game starts
     * @param diff String representing the difficulty selected
     */
    
    public void setDifficulty(String diff){
	this.difficulty = diff;
    }

    public String getDifficulty(){
	return this.difficulty;
    }

    /**
     * Called by GameFrame when a game mode is selected and the game starts
     * @param mode String that represents the game mode selected
     */
    
    public void setGameMode(String mode){
	this.gameMode = mode;
    }
    
    public String getGameMode(){
	return this.gameMode;
    }
    
    /**
     * Asks the next question if the question counter is less than 50. Prints
     * out the current state.
     */
    public void askNextQuestion(){
	if(!randStateIndexes.isEmpty()) {
	    if (this.gameMode == "Capitals")
		gamePanel.setQuestionTextArea("Click on: " + states.get(currentQuestion).getCapital() + "\n");
	    else
		gamePanel.setQuestionTextArea("Click on: " + states.get(currentQuestion).getName() + "\n");
	    mapPanel.setAnswer(mapPanel.stateButtons[currentQuestion]);
	}
	else {
	    gamePanel.setQuestionTextArea("You're finished! Yay!");
	}
    }
    
    /**
     * If the answer given was wrong, reasks the question without re-printing
     */
    public void repeatQuestion() {
	mapPanel.setAnswer(mapPanel.stateButtons[currentQuestion]);
    }        
    
    /**
     * Receives the answer from MapPanel and checks to see if the answer is
     * equivalent to the current state. Prints out the current score and
     * increments the counters.
     */
    public  void receiveAnswer(JButton answerButton){
	if (answerButton == mapPanel.stateButtons[currentQuestion]) {
	    if (this.gameMode == "States then Capitals") {
		checkCapital();
	    }
	    gamePanel.setAnswerTextArea(states.get(currentQuestion).getName());
	    gamePanel.getQuestionTextArea().setText("Congrats! ");

	    correctStates.add(states.get(currentQuestion));

	    for (JButton button : this.hiddenButtons) {
		button.setVisible(true);
	    }

	    if (this.getDifficulty() == "Easy") {
		answerButton.setVisible(false);
	    }

	    randStateIndexes.remove(randIndex);
	    if (!randStateIndexes.isEmpty()) {
		randIndex = (int) (Math.random() * (randStateIndexes.size()-1));
		currentQuestion = randStateIndexes.get(randIndex);
	    }

	    gamePanel.setHintButtonVisible(false);

	    if (guesses == 0)
		currentScore++;
	    else
		this.guesses = 0;
	    gamePanel.setQuestionTextArea("Your current score is: " + currentScore + "\n");
	    this.askNextQuestion();
	}
	else {
	    if (this.getDifficulty() != "Hard"){
		answerButton.setVisible(false);
		this.hiddenButtons.add(answerButton);
	    }
	    guesses++;
	    if (guesses == 3)
		gamePanel.setHintButtonVisible(true);
	    
	    //	    gamePanel.setQuestionTextArea("Nope!");
	    gamePanel.getQuestionTextArea().setText("Nope! Guesses: " + this.guesses + "\n");
	    this.askNextQuestion();
	    //	    this.repeatQuestion();
	}
    }

    /**
     * Called when in StateThenCapitals mode
     * Continuosly loops until the capital is entered correctly
     */
    
    private void checkCapital(){
	boolean answer = askCapital();
	while (!answer){
	    gamePanel.setQuestionTextArea("Capital is Incorrect! ");
	    answer = askCapital();
	    this.guesses++;
	}
    }

    /**
     * Called by checkCapital during StateThenCapitals mode
     * Prompts the user for the capital of the current state
     */

    private boolean askCapital(){
	String s = JOptionPane.showInputDialog(gamePanel.getParent(), "Enter the capital of " + states.get(currentQuestion).getName() + ":", "Capital Input", JOptionPane.PLAIN_MESSAGE);
	if (s.equals(states.get(currentQuestion).getCapital()))
	    return true;
	else
	    return false;
    }

}
