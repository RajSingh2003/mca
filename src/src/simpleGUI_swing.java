import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class simpleGUI_swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter text and click the button:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Display Text");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("You entered: " + textField.getText());
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setVisible(true);
    }
}
