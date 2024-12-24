package projct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pract10 {
    public static void main(String[] args) {
        // Create a JFrame (main window)
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create a JLabel to display instructions
        JLabel label = new JLabel("Enter text below:");
        frame.add(label);

        // Create a JTextField for user input
        JTextField textField = new JTextField(20);  // 20 columns wide
        frame.add(textField);

        // Create a JButton to trigger the action
        JButton button = new JButton("Display Text");
        frame.add(button);

        // ActionListener for the button to update the label with the text from the text field
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field and set it to the label
                String text = textField.getText();
                label.setText("You entered: " + text);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

