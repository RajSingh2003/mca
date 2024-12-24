package projct;

import java.awt.*;
import javax.swing.*;

public class LayoutManagerExperiment {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Layout Manager Experiment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Set BorderLayout as the layout for the frame
        frame.setLayout(new BorderLayout());

        // Create JButtons with different labels
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");

        // Add buttons to the frame using BorderLayout
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.add(button3, BorderLayout.WEST);
        frame.add(button4, BorderLayout.EAST);
        frame.add(button5, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}

