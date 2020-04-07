package UiTest;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class uitest extends JFrame implements ActionListener {

    private static final JPanel panel1 = new JPanel();
    private static final JPanel buttonPanel = new JPanel();

    private static final  JLabel label = new JLabel("Demo");
    private static final  JButton doubleButton = new JButton("double");
    private static final  JButton clearButton = new JButton("clear");

    private static final JTextField t = new JTextField();
    private static final String txt = t.getText();

    private final JTextArea area = new JTextArea(10, 60);


    uitest(){
        area.setFont(new Font("Monospace", Font.PLAIN, 12));
        panel1.setLayout(new BorderLayout());
        panel1.add(area, BorderLayout.CENTER);

        buttonPanel.add(doubleButton);
        buttonPanel.add(clearButton);

        panel1.add(buttonPanel, BorderLayout.SOUTH);

        doubleButton.addActionListener(this);
        clearButton.addActionListener(this);
        add(panel1);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

        uitest g = new uitest();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            area.setText("");
        }
        else if (e.getSource() == doubleButton){
            String newText = area.getText() + area.getText();
            area.setText(newText);
        }
    }
}

