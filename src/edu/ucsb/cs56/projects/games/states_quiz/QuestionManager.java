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
    private GamePanel gamePanel;
    private MapPanel mapPanel;

    private String option;
    private int currentQuestion;
    private int randIndex;
    private int currentScore;

    private ArrayList<State> states;
    private ArrayList<Integer> randStateIndexes;
    private ArrayList<State> correctStates;


    /**
     * Constructor QuestionManager creates a new array of the fifty state names
     */

    public QuestionManager(GamePanel parent) {
        states = new ArrayList<State>();
        correctStates = new ArrayList<State>();
        randStateIndexes = new ArrayList<Integer>();

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
//        mapPanel = gamePanel.getMapPanel();
//        states = mapPanel.getCountry().getStatesArray();

//        for(int i=0;i<states.size();i++){
//            randStateIndexes.add(i);
//        }

        randIndex = (int) (Math.random() * states.size());
        currentQuestion = randStateIndexes.get(randIndex);
        currentScore = 0;

        this.askNextQuestion();
    }

    public void mapClickCallback(Object o) {
        JButton answer = (JButton) o;
        this.receiveAnswer(answer);
    }

    /**
     * Asks the next question if the question counter is less than 50. Prints
     * out the current state.
     */

    public abstract void askNextQuestion();
//    {
//        if(!randStateIndexes.isEmpty()){
//            if(option.equals("State")){
//                gamePanel.setQuestionTextArea("Click on: " + states.get(currentQuestion).getName() + "\n");
//            }
//            else
//                gamePanel.setQuestionTextArea("Click on: " + states.get(currentQuestion).getCapital() + "\n");
//            mapPanel.setAnswer(mapPanel.stateButtons[currentQuestion]);
//        }
//        else
//            gamePanel.setQuestionTextArea("You're finished! Yay!");
//    }

    /**
     * Receives the answer from MapPanel and checks to see if the answer is
     * equivalent to the current state. Prints out the current score and
     * increments the counters.
     */

    public abstract void receiveAnswer(JButton answerButton);
//    {
//        JButton answer = (JButton) o;
//
//        if (answer == mapPanel.stateButtons[currentQuestion]) {
//            gamePanel.setQuestionTextArea("Congrats! ");
//
//            if(option.equals("State")){
//                gamePanel.setAnswerTextArea(states.get(currentQuestion).getName());
//            }
//            else{
//                gamePanel.setAnswerTextArea(states.get(currentQuestion).getCapital());
//            }
//
//            correctStates.add(states.get(currentQuestion));
//
//            randStateIndexes.remove(randIndex);
//            randIndex = (int) (Math.random() * (randStateIndexes.size()-1));
//            currentQuestion = randStateIndexes.get(randIndex);
//            currentScore++;
//        } else {
//            gamePanel.setQuestionTextArea("Nope! ");
//        }
//
//        gamePanel.setQuestionTextArea("Your current score is: " + currentScore + "\n");
//        this.askNextQuestion(option);
//    }
}
