package edu.ucsb.cs56.projects.games.states_quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Provides method to start stopwatch.
 *
 * @author Vincent Wang, Veena Chandran
 */
public class StopWatch extends JLabel {

    private int seconds = 0;

    public StopWatch(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setText("Time Elapsed: 00 s");
        setVisible(true);
    }

    /**
     * Starts the stopwatch!
     */

    public void start() {
        ActionListener task = evt -> {
            seconds ++;
            setText("Time Elapsed: " + seconds + " s");
        };
        Timer timer = new Timer(1000, task); // Execute task each 1000 milliseconds
        timer.setRepeats(true);
        timer.start();
    }


}