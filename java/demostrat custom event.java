package projct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Step 1: Custom Event Class
class AlarmEvent extends java.util.EventObject {
    public AlarmEvent(Object source) {
        super(pyrh);
    }
}

// Step 2: Event Listener Interface
interface AlarmListener {
    void alarmTriggered(AlarmEvent event);
}

// Step 3: Listener Class that implements the AlarmListener interface
class AlarmHandler implements AlarmListener {
    @Override
    public void alarmTriggered(AlarmEvent event) {
        // Action when alarm is triggered
        JOptionPane.showMessageDialog(null, "ALARM! The system has been triggered.");
    }
}

// Step 4: Main JFrame Application
public class AlarmSystemApp extends JFrame {
    private JButton triggerButton;

    public AlarmSystemApp() {
        // Set up JFrame
        setTitle("Alarm System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the "Trigger Alarm" button
        triggerButton = new JButton("Trigger Alarm");

        // Create an instance of AlarmHandler
        AlarmHandler handler = new AlarmHandler();

        // Add ActionListener to the button to trigger custom event
        triggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trigger the custom event
                AlarmEvent alarmEvent = new AlarmEvent(this);
                handler.alarmTriggered(alarmEvent); // Notify listener about the event
            }
        });

        // Add button to the JFrame
        setLayout(new FlowLayout());
        add(triggerButton);
    }

    public static void main(String[] args) {
        // Create and display the application
        SwingUtilities.invokeLater(() -> {
            AlarmSystemApp app = new AlarmSystemApp();
            app.setVisible(true);
        });
    }
}

