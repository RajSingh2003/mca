import javax.swing.*; 
import java.awt.*; 
public class differentLayout_swing 
{ 
public static void main(String[] args) 
{ 
JFrame frame = new JFrame("Layout Manager Experiment"); 
frame.setSize(500, 400); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setLayout(new BorderLayout()); 
JButton button1 = new JButton("BorderLayout - North"); 
JButton button2 = new JButton("BorderLayout - South"); 
JButton button3 = new JButton("FlowLayout"); 
JButton button4 = new JButton("GridLayout"); 
JButton button5 = new JButton("BoxLayout - Horizontal"); 
JButton button6 = new JButton("BoxLayout - Vertical"); 
frame.add(button1, BorderLayout.NORTH); 
frame.add(button2, BorderLayout.SOUTH); 
JPanel flowPanel = new JPanel(); 
flowPanel.setLayout(new FlowLayout()); 
flowPanel.add(button3); 
frame.add(flowPanel, BorderLayout.CENTER); 
JPanel gridPanel = new JPanel(); 
gridPanel.setLayout(new GridLayout(1, 1)); 
gridPanel.add(button4); 
frame.add(gridPanel, BorderLayout.EAST); 
JPanel boxPanelHorizontal = new JPanel(); 
boxPanelHorizontal.setLayout(new BoxLayout(boxPanelHorizontal, BoxLayout.X_AXIS)); 
boxPanelHorizontal.add(button5); 
frame.add(boxPanelHorizontal, BorderLayout.WEST); 
JPanel boxPanelVertical = new JPanel(); 
boxPanelVertical.setLayout(new BoxLayout(boxPanelVertical, BoxLayout.Y_AXIS)); 
boxPanelVertical.add(button6); 
frame.add(boxPanelVertical, BorderLayout.CENTER); 
frame.setVisible(true); 
} 
}