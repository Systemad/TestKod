package Chatroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

/*
public class chatroomSend extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JTextField text = new JTextField(10);
    JTextArea textArea = new JTextArea(30, 20);


    JButton button = new JButton("Send");
    String nickname;
    String message = "";
    String dataToSend = "";

    String messageFrom = "";

    int toPort = 55555;
    String group = "224.0.0.1";
    InetAddress toAdr = InetAddress.getByName(group);
    MulticastSocket mSocket = new MulticastSocket();


    public chatroomSend()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){
            System.exit(0);
        }
        this.add(panel);
        panel.add(text);
        panel.add(button);
        panel.add(textArea);

        button.addActionListener(this);
        text.addActionListener(this);

        this.pack();
        this.setLocation(800, 300);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatroomReceive m = new chatroomReceive(messageFrom);
        Thread t = new Thread(m);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        message = text.getText();
        dataToSend = nickname+": "+message;
        byte[] data = dataToSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
        try{
            mSocket.send(packet);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //textArea.setText(nickname + ": " + message);
        text.setText("");
        textArea.setText(messageFrom);
        //System.out.println(messageFrom);

    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        chatroomSend ts = new chatroomSend();

    }
}
*/

public class chatroomSend extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JTextField text = new JTextField(10);
    JTextArea textArea = new JTextArea(30, 20);


    JButton button = new JButton("Send");
    String nickname;
    String message = "";
    String dataToSend = "";

    int toPort = 55555;
    String group = "224.0.0.1";
    InetAddress toAdr = InetAddress.getByName(group);
    MulticastSocket mSocket = new MulticastSocket();


    public chatroomSend()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){
            System.exit(0);
        }
        this.add(panel);
        panel.add(text);
        panel.add(button);
        panel.add(textArea);

        button.addActionListener(this);
        text.addActionListener(this);

        this.pack();
        this.setLocation(800, 300);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mSocket.joinGroup(toAdr);
        ReadThread m = new ReadThread(mSocket, toAdr, toPort);
        Thread t = new Thread(m);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        message = text.getText();
        dataToSend = nickname+": "+message;
        byte[] data = dataToSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
        try{
            mSocket.send(packet);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //textArea.setText(nickname + ": " + message);
        text.setText("");
        //System.out.println(messageFrom);


    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        chatroomSend ts = new chatroomSend();


    }
}
