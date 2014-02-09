package edu.ucsb.cs56.projects.games.states_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

/** 
	Geopanel is a class that extends JPanel and implements ActionListener. It prints out the image of the blank map and holds all of the information about each of the 		states. It sets up the buttons for each of the states and sends QManager the user's input.
    	@author Nina Kaufman
*/

public class Geopanel extends JPanel implements ActionListener{

	public JButton[] states;

	private BufferedImage map;
	public int totalscore = 0;
	public JButton answer;
	private QManager qManager;

	public Geopanel(){


		qManager = geomain.getQManager();

		this.setLayout(null);

		try{
			map = ImageIO.read(getClass().getClassLoader().getResource("image/blank-map-of-the-united-states2.jpg"));
		} 
		catch(IOException ie){}

		this.repaint();

//have to create an array of all the buttons with the states
//also have to fill in the array that holds all of the names of the states and which state number they are

		states = new JButton[50];
		
		//Alabama
		states[0] = new JButton();
		this.add(states[0]);
		states[0].setBounds(485,300,25,25);
		states[0].addActionListener(this);
		qManager.setStateName("Alabama", 0);

		//Alaska
		states[1] = new JButton();
		this.add(states[1]);
		states[1].setBounds(90,430, 25, 25);
		states[1].addActionListener(this);
		qManager.setStateName("Alaska", 1);

		//Arizona
		states[2] = new JButton();
		this.add(states[2]);
		states[2].setBounds(160,270, 25, 25);
		states[2].addActionListener(this);
		qManager.setStateName("Arizona", 2);

		//Arkansas
		states[3] = new JButton();
		this.add(states[3]);
		states[3].setBounds(407,275,25,25);
		states[3].addActionListener(this);
		qManager.setStateName("Arkansas", 3);

		//California
		states[4] = new JButton();
		this.add(states[4]); 
		states[4].setBounds(80,220, 25, 25);
		states[4].addActionListener(this);
		qManager.setStateName("California", 4);	

		//Colorado
		states[5] = new JButton();
		this.add(states[5]);
		states[5].setBounds(245,205,25,25);
		states[5].addActionListener(this);
		qManager.setStateName("Colorado", 5);

		//Connecticut
		states[6] = new JButton();
		this.add(states[6]);
		states[6].setBounds(653,159,25,25);
		states[6].addActionListener(this);
		qManager.setStateName("Connecticut", 6);

		//Delaware
		states[7] = new JButton();
		this.add(states[7]);
		states[7].setBounds(653,235,25,25);
		states[7].addActionListener(this);
		qManager.setStateName("Delaware", 7);

		//Florida
		states[8] = new JButton();
		this.add(states[8]);
		states[8].setBounds(563,366,25,25);
		states[8].addActionListener(this);
		qManager.setStateName("Florida", 8);

		//Georgia
		states[9] = new JButton();
		this.add(states[9]);
		states[9].setBounds(530,300,25,25);
		states[9].addActionListener(this);	
		qManager.setStateName("Georgia", 9);

		//Hawaii
		states[10] = new JButton();
		this.add(states[10]);
		states[10].setBounds(250,480,25,25);
		states[10].addActionListener(this);
		qManager.setStateName("Hawaii", 10);

		//Idaho
		states[11] = new JButton();
		this.add(states[11]);
		states[11].setBounds(153,120, 25, 25);
		states[11].addActionListener(this);
		qManager.setStateName("Idaho", 11);

		//Illinois
		states[12] = new JButton();
		this.add(states[12]);
		states[12].setBounds(445,193, 25, 25);
		states[12].addActionListener(this);		
		qManager.setStateName("Illinois", 12);

		//Indiana
		states[13] = new JButton();
		this.add(states[13]);
		states[13].setBounds(482,190, 25, 25);
		states[13].addActionListener(this);
		qManager.setStateName("Indiana", 13);

		//Iowa
		states[14] = new JButton();
		this.add(states[14]);
		states[14].setBounds(390,162, 25, 25);
		states[14].addActionListener(this);
		qManager.setStateName("Iowa", 14);

		//Kansas
		states[15] = new JButton();
		this.add(states[15]);
		states[15].setBounds(330,215,25,25);
		states[15].addActionListener(this);
		qManager.setStateName("Kansas", 15);

		//Kentucky
		states[16] = new JButton();
		this.add(states[16]);
		states[16].setBounds(507,222,25,25);
		states[16].addActionListener(this);
		qManager.setStateName("Kentucky", 16);

		//Louisiana
		states[17] = new JButton();
		this.add(states[17]);
		states[17].setBounds(409,332,25,25);
		states[17].addActionListener(this);	
		qManager.setStateName("Louisiana", 17);

		//Maine
		states[18] = new JButton();
		this.add(states[18]);
		states[18].setBounds(655,70,25,25);
		states[18].addActionListener(this);	
		qManager.setStateName("Maine", 18);

		//Maryland
		states[19] = new JButton();
		this.add(states[19]);
		states[19].setBounds(635,290,25,25);
		states[19].addActionListener(this);
		qManager.setStateName("Maryland", 19);


		//Massachusetts
		states[20] = new JButton();
		this.add(states[20]);
		states[20].setBounds(685,119,25,25);
		states[20].addActionListener(this);
		qManager.setStateName("Massachusetts", 20);


		//Michigan
		states[21] = new JButton();
		this.add(states[21]);
		states[21].setBounds(494,140,25,25);
		states[21].addActionListener(this);
		qManager.setStateName("Michigan", 21);

		//Minnesota
		states[22] = new JButton();
		this.add(states[22]);
		states[22].setBounds(380,100,25,25);
		states[22].addActionListener(this);
		qManager.setStateName("Minnesota", 22);

		//Mississippi
		states[23] = new JButton();
		this.add(states[23]);
		states[23].setBounds(445,310,25,25);
		states[23].addActionListener(this);
		qManager.setStateName("Mississippi", 23);

		//Missouri
		states[24] = new JButton();
		this.add(states[24]);
		states[24].setBounds(405,215,25,25);
		states[24].addActionListener(this);
		qManager.setStateName("Missouri", 24);

		//Montana
		states[25] = new JButton();
		this.add(states[25]);
		states[25].setBounds(220,70,25,25);
		states[25].addActionListener(this);
		qManager.setStateName("Montana", 25);

		//Nebraska
		states[26] = new JButton();
		this.add(states[26]);
		states[26].setBounds(315,167,25,25);
		states[26].addActionListener(this);
		qManager.setStateName("Nebraska", 26);

		//Nevada
		states[27] = new JButton();
		this.add(states[27]);
		states[27].setBounds(115,185,25,25);
		states[27].addActionListener(this);
		qManager.setStateName("Nevada", 27);

		//New Hampshire
		states[28] = new JButton();
		this.add(states[28]);
		states[28].setBounds(625,40,25,25);
		states[28].addActionListener(this);
		qManager.setStateName("New Hampshire", 28);

		//New Jersey
		states[29] = new JButton();
		this.add(states[29]);
		states[29].setBounds(653,189,25,25);
		states[29].addActionListener(this);
		qManager.setStateName("New Jersey", 29);

		//New Mexico
		states[30] = new JButton();
		this.add(states[30]);
		states[30].setBounds(230,280,25,25);
		states[30].addActionListener(this);
		qManager.setStateName("New Mexico", 30);

		//New York
		states[31] = new JButton();
		this.add(states[31]);
		states[31].setBounds(603,121,25,25);
		states[31].addActionListener(this);
		qManager.setStateName("New York", 31);
	
		//North Carolina
		states[32] = new JButton();
		this.add(states[32]);
		states[32].setBounds(580,245,25,25);
		states[32].addActionListener(this);
		qManager.setStateName("North Carolina", 32);

		//North Dakota
		states[33] = new JButton();
		this.add(states[33]);
		states[33].setBounds(315,73,25,25);
		states[33].addActionListener(this);
		qManager.setStateName("North Dakota", 33);

		//Ohio
		states[34] = new JButton();
		this.add(states[34]);
		states[34].setBounds(520,180,25,25);
		states[34].addActionListener(this);	
		qManager.setStateName("Ohio", 34);

		//Oklahoma
		states[35] = new JButton();
		this.add(states[35]);
		states[35].setBounds(345,265,25,25);
		states[35].addActionListener(this);
		qManager.setStateName("Oklahoma", 35);

		//Oregon
		states[36] = new JButton();
		this.add(states[36]);
		states[36].setBounds(80,100,25,25);
		states[36].addActionListener(this);
		qManager.setStateName("Oregon", 36);

		//Pennsylvania
		states[37] = new JButton();
		this.add(states[37]);
		states[37].setBounds(580,158,25,25);
		states[37].addActionListener(this);
		qManager.setStateName("Pennsylvania", 37);	

		//Rhode Island
		states[38] = new JButton();
		this.add(states[38]);
		states[38].setBounds(678,145,25,25);
		states[38].addActionListener(this);
		qManager.setStateName("Rhode Island", 38);

		//South Carolina
		states[39] = new JButton();
		this.add(states[39]);
		states[39].setBounds(563,275,25,25);
		states[39].addActionListener(this);
		qManager.setStateName("South Carolina", 39);

		//South Dakota
		states[40] = new JButton();
		this.add(states[40]);
		states[40].setBounds(315,123,25,25);
		states[40].addActionListener(this);
		qManager.setStateName("South Dakota", 40);

		//Tennessee
		states[41] = new JButton();
		this.add(states[41]);
		states[41].setBounds(483,255,25,25);
		states[41].addActionListener(this);
		qManager.setStateName("Tennessee", 41);		

		//Texas
		states[42] = new JButton();
		this.add(states[42]);
		states[42].setBounds(320,330,25,25);
		states[42].addActionListener(this);
		qManager.setStateName("Texas", 42);
		
		//Utah
		states[43] = new JButton();
		this.add(states[43]);
		states[43].setBounds(175,190,25,25);	
		states[43].addActionListener(this);	
		qManager.setStateName("Utah", 43);

		//Vermont
		states[44] = new JButton();
		this.add(states[44]);
		states[44].setBounds(580,30,25,25);	
		states[44].addActionListener(this);	
		qManager.setStateName("Vermont", 44);

		//Virginia
		states[45] = new JButton();
		this.add(states[45]);
		states[45].setBounds(580,213,25,25);	
		states[45].addActionListener(this);	
		qManager.setStateName("Virginia", 45);

		//Washington
		states[46] = new JButton();
		this.add(states[46]);
		states[46].setBounds(110,50,25,25);
		states[46].addActionListener(this);
		qManager.setStateName("Washington", 46);

		//West Virginia
		states[47] = new JButton();
		this.add(states[47]);
		states[47].setBounds(548,200,25,25);
		states[47].addActionListener(this);
		qManager.setStateName("West Virginia", 47);
	
		//Wisconsin
		states[48] = new JButton();
		this.add(states[48]);
		states[48].setBounds(433,120,25,25);
		states[48].addActionListener(this);
		qManager.setStateName("Wisconsin", 48);

		//Wyoming
		states[49] = new JButton();
		this.add(states[49]);
		states[49].setBounds(230,137,25,25);
		states[49].addActionListener(this);
		qManager.setStateName("Wyoming", 49);

	}
/**
	Prints the image of the blank map.
*/

	public void paintComponent(Graphics g){

		g.drawImage(map, 0, 0, this);
	}

/**
	Sets the answer to a.
*/

	public void setAnswer(JButton a){
		this.answer = a;
	}

/**
	Sends the button clicked to qManager. 
*/

	public void actionPerformed(ActionEvent e){
		qManager.receiveAnswer(e.getSource());
	}
}
