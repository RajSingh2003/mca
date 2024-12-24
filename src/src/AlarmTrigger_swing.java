import javax.swing.*;
import java.awt.event.*;
import java.util.EventObject;

class AlarmEvent extends EventObject {
    public AlarmEvent(Object source) {
        super(source);
    }
}

interface AlarmListener {
    void alarmTriggered(AlarmEvent event);
}

class AlarmHandler implements AlarmListener {
    @Override
    public void alarmTriggered(AlarmEvent event) {
        System.out.println("ALARM TRIGGERED: The alarm has been activated!");
        JOptionPane.showMessageDialog(null, "Please Stop the Alarm");
    }
}

public class AlarmTrigger_swing extends JFrame {
    private JButton triggerButton;
    private AlarmListener alarmListener;

    public AlarmTrigger_swing() {
        setTitle("Alarm System");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new java.awt.FlowLayout());
        triggerButton = new JButton("Trigger Alarm");
        triggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alarmListener != null) {
                    alarmListener.alarmTriggered(new AlarmEvent(this));
                }
            }
        });
        add(triggerButton);
    }

    public void addAlarmListener(AlarmListener listener) {
        this.alarmListener = listener;
    }

    public static void main(String[] args) {
        AlarmTrigger_swing frame = new AlarmTrigger_swing();
        frame.addAlarmListener(new AlarmHandler());
        frame.setVisible(true);
    }
}
