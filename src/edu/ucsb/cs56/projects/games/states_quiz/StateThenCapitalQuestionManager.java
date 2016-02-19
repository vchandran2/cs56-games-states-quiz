package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;

/**
 * Created by Nick on 3/5/2015.
 */
public class StateThenCapitalQuestionManager extends QuestionManager {
    int guesses = 0;
    
    @Override
    public void askNextQuestion() {
        if(!randStateIndexes.isEmpty()) {
            gamePanel.setQuestionTextArea("Click on: " + states.get(currentQuestion).getName() + "\n");
            mapPanel.setAnswer(mapPanel.stateButtons[currentQuestion]);
        }
        else {
            gamePanel.setQuestionTextArea("You're finished! Yay!");
        }
    }

    public StateThenCapitalQuestionManager(GamePanel parent) {
        super(parent);
    }

    private boolean askCapital() {
        String s = JOptionPane.showInputDialog(gamePanel.getParent(), "Enter the capital of " + states.get(currentQuestion).getName() + ":", "Capital Input", JOptionPane.PLAIN_MESSAGE);
        if (s.equals(states.get(currentQuestion).getCapital()))
            return true;
        else
            return false;
    }

    @Override
    public void receiveAnswer(JButton answerButton) {
        if (answerButton == mapPanel.stateButtons[currentQuestion]) {
            if (askCapital()) {
                gamePanel.setQuestionTextArea("Congrats! ");
                gamePanel.setAnswerTextArea(states.get(currentQuestion).getCapital());

                correctStates.add(states.get(currentQuestion));

                randStateIndexes.remove(randIndex);
                randIndex = (int) (Math.random() * (randStateIndexes.size() - 1));
                currentQuestion = randStateIndexes.get(randIndex);

		gamePanel.setHintButtonVisible(false);
		
		if (this.guesses == 0)
                    currentScore++;
                else
                    this.guesses = 0;
            } else {
                this.guesses++;
		if (guesses == 3)
		    gamePanel.setHintButtonVisible(true);
		
                gamePanel.setQuestionTextArea("Capital is incorrect!  Try again!");
            }

        } else {
            this.guesses++;
            gamePanel.setQuestionTextArea("Nope! ");
        }

        gamePanel.setQuestionTextArea("Your current score is: " + currentScore + "\n");
        this.askNextQuestion();
    }
}
