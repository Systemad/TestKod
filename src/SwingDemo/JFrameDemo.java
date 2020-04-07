package SwingDemo;
import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JFrameDemo extends JFrame {

    JPanel panel = new JPanel();

    JLabel label = new JLabel("Demo");
    JButton button = new JButton("Click me1");
    JButton button2 = new JButton("Click me2");
    JButton button3 = new JButton("Click me3");
    JButton button4 = new JButton("Click me4");



    JFrameDemo(){
        this.add(panel);
        panel.add(label);
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        this.pack();
        //setSize(500,500);
        setLocation(500, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrameDemo g = new JFrameDemo();
    }


}
