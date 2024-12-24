package projct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEventHandling {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Button Event Handling");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create two buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Create ActionListener for Button 1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 1 clicked!");
            }
        });

        // Create ActionListener for Button 2
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 2 clicked!");
            }
        });

        // Set up layout and add buttons to the frame
        frame.setLayout(new FlowLayout()); // Use FlowLayout for simple arrangement
        frame.add(button1);
        frame.add(button2);

        // Make the frame visible
        frame.setVisible(true);
    }
}

