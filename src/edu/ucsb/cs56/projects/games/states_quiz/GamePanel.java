package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GamePanel sets up the GamePanel with the frame that holds the text for questions and answers and the scrollbar.
 *
 * @author Nina Kaufman
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */


public class GamePanel extends JPanel implements ActionListener {

    private MapPanel mapPanel; // mapPanel is a MapPanel reference
    private JPanel panel;
    private JTextArea questionTextArea; // text area on bottom where question displays
    private JScrollPane questionScrollPane;
    private JTextArea answerTextArea; // text area on right for correct answers
    private JScrollPane answerScrollPane;
    private JButton hintButton;
    private Font ourFont;
    static final int SCREEN_WIDTH  = 980;
    static final int SCREEN_HEIGHT = 680;
    static final int MAP_X_BOUND   = (int) (.75 * SCREEN_WIDTH);
    static final int MAP_Y_BOUND   = (int) (.7 * SCREEN_HEIGHT);


    public GamePanel() {
	
        ourFont = new Font("Arial", Font.PLAIN, 24);
        mapPanel = new MapPanel();

        //Setting up the text area to display questions
        questionTextArea = new JTextArea(4, 20);
        questionTextArea.setLineWrap(true);

        questionScrollPane = new JScrollPane(questionTextArea);
        questionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        questionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        questionScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        questionTextArea.setFont(ourFont);
        questionTextArea.append("Welcome to the USA map quiz!\n");
        questionTextArea.setEditable(false);

        //Set up text area to display answers
		
        answerTextArea = new JTextArea(20,10);
        answerTextArea.setLineWrap(true);
        answerScrollPane = new JScrollPane(answerTextArea);
        answerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        answerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        answerTextArea.setFont(ourFont);
        answerTextArea.append("Correct Answers:\n");
        answerTextArea.setEditable(false);

	int hintX = (int) (.57 * SCREEN_WIDTH);
	int hintY = (int) (.7 * SCREEN_HEIGHT);
	hintButton = this.generateHintButton(hintX, hintY, 150, 50, "Click For Hint");
	
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	mapPanel.add(hintButton);
	
        mapPanel.repaint();

        this.setLayout(new BorderLayout());
        this.add(mapPanel,BorderLayout.CENTER);
        this.add(questionScrollPane,BorderLayout.SOUTH);
        this.add(answerScrollPane,BorderLayout.EAST);

        this.setVisible(false);
        this.repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
	State state = mapPanel.getQuestionManager().getCorrectState();
	hintButton.setText(this.getStateQuadrant(state.getXCoord(), state.getYCoord()));
    }

    /**
     * @param x x coord of hintButton
     * @param y y coord of hintButton
     * @param w width of hintButton
     * @param h height of hintButton
     * @param text hintButton display text
     * @return a newly generated hintButton with the specified x/y/text values
     */
    
    private JButton generateHintButton(int x, int y, int w, int h, String text){
        JButton hintButton = new JButton(text);
	hintButton.setEnabled(true);
	hintButton.setVisible(false);
	hintButton.setBounds(x, y, w, h);
	hintButton.addActionListener(this);

	return hintButton;
    }
    
    public void setHintButtonVisible(Boolean b) {
	if (!b)
	    hintButton.setText("Click For Hint");
	hintButton.setVisible(b);
    }
    
    /**
     * @return questionTextArea the Text Area with questions
     */
    public JTextArea getQuestionTextArea() {
        return this.questionTextArea;
    }
    
    /**
     * Adds text to the questionTextArea.
     * @param text the text to append to the question area
     */
    public void setQuestionTextArea(String text) {
        this.questionTextArea.append(text);
    }

    /**
     * @return answerTextArea the Text Area with correct answers
     */
    public JTextArea getAnswerTextArea() {
        return this.answerTextArea;
    }

    /**
     * @param txt answer that goes into answerTextAres
     */
    public void setAnswerTextArea(String txt) {
        this.answerTextArea.append(txt + "\n");
    }

    /**
     * @return mapPanel panel of the map 
     */
    public MapPanel getMapPanel() {
        return this.mapPanel;
    }

    /**
     * @param x x value of state
     * @param y y value of state
     * @return String with quadrant (north-south/east-west) of state
     */
    public String getStateQuadrant(int x, int y){
	String quadrant = "";
	//Decide north or south
	if (y <= MAP_Y_BOUND/2){
	    quadrant += "North";
	}
	else{
	    quadrant += "South";
	}
	//Decide east or west
	if (x <= MAP_X_BOUND/2){
	    quadrant += "west";
	}
	else{
	    quadrant += "east";
	}
	return quadrant;
    }
}
