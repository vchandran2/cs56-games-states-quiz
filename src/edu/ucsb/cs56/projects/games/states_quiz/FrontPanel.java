package edu.ucsb.cs56.projects.games.states_quiz;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * FrontPanel displays the game, high score, and difficulty options at the start of the game.
 *
 * @author Zhansaya Abdikarimova
 * @author Jenny Vien
 * @author Nick Eidler
 * @author Ryan Allen
 * @author Ryan Kemper
 */

public class FrontPanel extends JPanel {
	private BufferedImage map;
	private JLabel highScore;
	private JButton stateButton;
	private JButton capitalButton;
	private JButton stateThenCapitalButton;
	private JRadioButton easyButton;
	private JRadioButton hardButton;
	private JRadioButton normalButton;
	private ButtonGroup difficulties;

	public FrontPanel() {

		this.setLayout(null);
		try {
			map = ImageIO.read(getClass().getClassLoader().getResource(
					"image/front.jpg"));
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		assert (map != null);

		JLabel title = new JLabel("Welcome to the Country Quiz!", JLabel.CENTER);
		Font titleFont = new Font("TimesRoman", Font.PLAIN, 50);
		title.setFont(titleFont);

		Font modeFont = new Font("TimesRoman", Font.PLAIN, 25);
		stateButton = new JButton("States");
		stateButton.setFont(modeFont);

		JLabel highScore = createHighScoreLabel();
		highScore.setFont(modeFont);

		capitalButton = new JButton("Capitals");
		capitalButton.setFont(modeFont);

		stateThenCapitalButton = new JButton("States then Capitals");
		stateThenCapitalButton.setFont(modeFont);

		JLabel diffHeader = new JLabel("Select difficulty:", JLabel.CENTER);
		Font diffHeaderFont = new Font("TimesRoman", Font.PLAIN, 20);
		diffHeader.setFont(diffHeaderFont);

		easyButton = new JRadioButton("Easy");
		normalButton = new JRadioButton("Normal");
		hardButton = new JRadioButton("Hard");

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

		title.setBounds(100, 80, 800, 200);
		stateButton.setBounds(340, 280, 300, 100);
		capitalButton.setBounds(340, 400, 300, 100);
		stateThenCapitalButton.setBounds(340, 520, 300, 100);

		highScore.setBounds(
				(GamePanel.SCREEN_WIDTH - highScore.getPreferredSize().width) / 2,
				title.getY() + 140,
				highScore.getPreferredSize().width,
				highScore.getPreferredSize().height
		);

		diffHeader.setBounds(450, 200, 600, 200);
		easyButton.setBounds(700, 300, 80, 80);
		normalButton.setBounds(700, 350, 80, 80);
		hardButton.setBounds(700, 400, 80, 80);

		add(title);
		add(highScore);
		add(stateButton);
		add(capitalButton);
		add(stateThenCapitalButton);

		add(diffHeader);
		add(easyButton);
		add(normalButton);
		add(hardButton);

		setVisible(true);
		repaint();
	}

	private JLabel createHighScoreLabel() {
		File file = new File("high_score.txt");
		JLabel label = new JLabel("High Score: 0");
		try {
			Scanner scanner = new Scanner(file);
			int highScore = scanner.nextInt();
			label.setText("High Score: " + Integer.toString(highScore));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return label;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(map, 0, 0, 980, 680, this);
	}

	/**
	 * @return state game mode button
	 */

	public JButton getStateButton() {
		return this.stateButton;
	}

	/**
	 * @return capital game mode button
	 */

	public JButton getCapitalButton() {
		return this.capitalButton;
	}

	/**
	 * @return stateThenCapital game mode button
	 */

	public JButton getStateThenCapitalButton() {
		return this.stateThenCapitalButton;
	}

	/**
	 * @return JRadioButton representing easy difficulty
	 */

	public JRadioButton getEasyButton() {
		return this.easyButton;
	}

	/**
	 * @return JRadioButton representing normal difficulty
	 */

	public JRadioButton getNormalButton() {
		return this.normalButton;
	}

	/**
	 * @return JRadioButton representing hard difficulty
	 */

	public JRadioButton getHardButton() {
		return this.hardButton;
	}

	/**
	 * @return the buttongroup representing the difficulties
	 */

	public ButtonGroup getDifficultiesGroup() {
		return this.difficulties;
	}
}
