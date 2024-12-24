import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class menuDriveOne_swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu-Driven GUI Application");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        // Add ActionListeners for menu items
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "New File Created!"));
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Open File Dialog!"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "File Saved!"));
        saveAsItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Save As Dialog!"));
        exitItem.addActionListener(e -> System.exit(0));

        cutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Cut Action!"));
        copyItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Copy Action!"));
        pasteItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Paste Action!"));

        frame.setVisible(true);
    }
}
