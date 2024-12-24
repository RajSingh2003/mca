import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class EventHandling_TwoButton_swing 
{ 
public static void main(String[] args) 
{ 
JFrame frame = new JFrame("Button Event Handling"); 
frame.setSize(300, 200); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setLayout(new FlowLayout()); 
JButton button1 = new JButton("Button 1"); 
JButton button2 = new JButton("Button 2"); 
button1.addActionListener (new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JOptionPane.showMessageDialog(frame, "Button 1 clicked!"); 
} 
}); 
button2.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
JOptionPane.showMessageDialog(frame, "Button 2 clicked!"); 
} 
}); 
frame.add(button1); 
frame.add(button2); 
frame.setVisible(true); 
} 
}