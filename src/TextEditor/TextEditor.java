package TextEditor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.annotation.processing.Filer;
import javax.swing.*;

public class TextEditor extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JTextField name = new JTextField();

    private JButton open = new JButton("Open File");
    private JButton save = new JButton("Save File");
    /*
    private JButton write = new JButton("Write File");
    private JButton exit = new JButton("Exit");
    private JButton delete = new JButton("Delete");
    */
    private JTextArea area = new JTextArea(10,60);
    private JScrollPane scrollPanel = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    public TextEditor(){
        area.setFont(new Font("Monospace", Font.PLAIN, 12));
        panel.setLayout(new GridLayout(1,6));
        panel.add(new JLabel("Filename", JLabel.RIGHT));
        panel.add(name); panel.add(open); panel.add(save);
        //panel.add(write); panel.add(delete); panel.add(exit);

        name.addActionListener(this);;
        open.addActionListener(this);
        save.addActionListener(this);
        //write.addActionListener(this);
        //delete.addActionListener(this);

        //exit.addActionListener(this);

        add(panel, BorderLayout.NORTH);
        add(scrollPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == open)
            readFile(name.getText());
        else if (e.getSource() == save)
            saveFile(name.getText());
        /*
        else if (e.getSource() == write)
            try{
                area.print();
            }
            catch(Exception ex) {}
        else if(e.getSource() == delete){
            deletefile(name.getText());
        }
        else if (e.getSource() == exit)
            System.exit(0);

         */
    }
    private void readFile(String filename){
        String filepath = "C:\\Users\\Dan\\IdeaProjects\\TestKod\\src\\";
        String fileComplete = filepath + filename + ".txt";

        try{
            FileReader r = new FileReader(fileComplete);
            area.read(r, null);
        }
        catch(IOException e) {e.printStackTrace();}
    }

    public void deletefile(String filename){
        String filepath = "C:\\Users\\Dan\\IdeaProjects\\TestKod\\src\\";
        String fileComplete = filepath + filename + ".txt";
        File f = new File(fileComplete);

        try{
            f.delete();
        }
        catch(Exception e) {e.printStackTrace();}

    }

    private void saveFile(String filename){
        try {
            String filepath = "C:\\Users\\Dan\\IdeaProjects\\TestKod\\src\\";
            String fileComplete = filepath + filename + ".txt";

            FileWriter w = new FileWriter(fileComplete);
            area.write(w);
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
    }
}


