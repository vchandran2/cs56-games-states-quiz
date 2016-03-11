package edu.ucsb.cs56.projects.games.states_quiz;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * FrontPanel displays the game and difficulty options at game startup
 * @author Zhansaya Abdikarimova
 * @author Jenny Vien
 * @author Nick Eidler
 * @author Ryan Allen
 * @author Ryan Kemper
 */

public class FrontPanel extends JPanel{
    private BufferedImage map;
    private JLabel title;
    private JLabel diffHeader;
    private JButton stateButton;
    private JButton capitalButton;
    private JButton stateThenCapitalButton;
    private JRadioButton easyButton;
    private JRadioButton hardButton;
    private JRadioButton normalButton;
    private ButtonGroup difficulties;

    public FrontPanel(){
	
        this.setLayout(null);
        try {
            map = ImageIO.read(getClass().getClassLoader().getResource(
                    "image/front.jpg"));
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        assert (map != null);

        title = new JLabel("Welcome to the Country Quiz!",JLabel.CENTER);
        Font titleFont = new Font("TimesRoman",Font.PLAIN,50);
        title.setFont(titleFont);

	Font modeFont = new Font("TimesRoman", Font.PLAIN, 25);
        stateButton = new JButton("States");
        stateButton.setFont(modeFont);
	
        capitalButton = new JButton("Capitals");
        capitalButton.setFont(modeFont);
	
        stateThenCapitalButton = new JButton("State then Capitals");
	stateThenCapitalButton.setFont(modeFont);

	diffHeader = new JLabel("Select difficulty:", JLabel.CENTER);
	Font diffHeaderFont = new Font("TimesRoman", Font.PLAIN, 20);
	diffHeader.setFont(diffHeaderFont);
	
	easyButton   = new JRadioButton("Easy");
	normalButton = new JRadioButton("Normal");
	hardButton   = new JRadioButton("Hard");

	easyButton.setActionCommand("Easy");
	normalButton.setActionCommand("Normal");
	hardButton.setActionCommand("Hard");
	
	normalButton.setSelected(true);
	easyButton.setOpaque(false);
	normalButton.setOpaque(false);
	hardButton.setOpaque(false);
	
	difficulties = new ButtonGroup();
	difficulties.add(easyButton);
	difficulties.add(normalButton);
	difficulties.add(hardButton);

        title.setBounds(100,80,800,200);
        stateButton.setBounds(340,280,300,100);
        capitalButton.setBounds(340, 400, 300, 100);
        stateThenCapitalButton.setBounds(340, 520, 300, 100);

	diffHeader.setBounds(450, 200, 600, 200);
	easyButton.setBounds(700, 300, 80, 80);
	normalButton.setBounds(700, 350, 80, 80);
	hardButton.setBounds(700, 400, 80, 80);
	
        this.add(title);
        this.add(stateButton);
        this.add(capitalButton);
        this.add(stateThenCapitalButton);

	this.add(diffHeader);
	this.add(easyButton);
	this.add(normalButton);
	this.add(hardButton);

        this.setVisible(true);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(map, 0, 0, 980, 680, this);
    }
    
    /**
     * @return state game mode button
     */
    
    public JButton getStateButton(){
        return this.stateButton;
    }

    /**
    * @return capital game mode button
    */
  
    public JButton getCapitalButton(){
        return this.capitalButton;
    }
    
    /**
     * @return stateThenCapital game mode button
     */

    public JButton getStateThenCapitalButton() { return this.stateThenCapitalButton; }

    /**
     * @return JRadioButton representing easy difficulty
     */
    
    public JRadioButton getEasyButton(){
	return this.easyButton;
    }
    
    /**
     * @return JRadioButton representing normal difficulty
     */
    
    public JRadioButton getNormalButton(){
	return this.normalButton;
    }

    /**
     * @return JRadioButton representing hard difficulty
     */
    
    public JRadioButton getHardButton(){
	return this.hardButton;
    }
    
    /**
     * @return the buttongroup representing the difficulties 
     */
    
    public ButtonGroup getDifficultiesGroup(){
	return this.difficulties;
    }
}
