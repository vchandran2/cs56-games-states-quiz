package edu.ucsb.cs56.projects.games.states_quiz;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class DifficultyPanel extends JPanel{
    private BufferedImage map;
    private JLabel title;
    private JButton easyButton;
    private JButton normalButton;
    private JButton hardButton;

    public DifficultyPanel(){

        this.setLayout(null);
        try {
            map = ImageIO.read(getClass().getClassLoader().getResource(
                    "image/front.jpg"));
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        assert (map != null);

        title = new JLabel("Select Difficulty",JLabel.CENTER);
        Font titleFont = new Font("TimesRoman",Font.PLAIN,50);
        title.setFont(titleFont);


        easyButton = new JButton("Easy");
        easyButton.setFont(new Font("TimesRoman",Font.PLAIN,30));

        normalButton = new JButton("Normal");
        normalButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        hardButton = new JButton("Hard");
        hardButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        title.setBounds(100,80,800,200);
        easyButton.setBounds(340,280,300,100);
        normalButton.setBounds(340, 400, 300, 100);
        hardButton.setBounds(340, 520, 300, 100);

        this.add(title);
        this.add(easyButton);
        this.add(normalButton);
        this.add(hardButton);

        this.setVisible(true);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(map, 0, 0,980,680, this);

    }

    public JButton getEasyButton(){
        return this.easyButton;
    }
    public JButton getNormalButton(){
        return this.normalButton;
    }
    public JButton getHardButton() { return this.hardButton; }
}
