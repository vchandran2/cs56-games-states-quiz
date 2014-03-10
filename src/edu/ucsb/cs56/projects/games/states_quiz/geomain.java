package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

/** Geomain sets and initializes the frame and QuestionManager.
    @author Nina Kaufman
    @author Jenny Vien
    @author Zhansaya Abdikarimova
*/

public class geomain{

	private static GUI frame;
	private static QuestionManager questionManager;

	public static void main (String[] args){
		questionManager = new QuestionManager();		
		frame = new GUI();
		questionManager.init();
	}

	/**
	 * @return GUI frame the whole window of the game
	 */
	public static GUI getGUI(){
		return frame;
	}
	/**
	 * @return questionManager  
	 */

	public static QuestionManager getQuestionManager()
	{
		return questionManager;
	}


}
