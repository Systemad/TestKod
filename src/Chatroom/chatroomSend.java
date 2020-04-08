package Chatroom;

import java.awt.*;
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
    JTextField textField = new JTextField(10);
    JTextArea textArea = new JTextArea(15, 25);

    JScrollPane scrollPanel = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    // Buttons
    JButton button = new JButton("Send");
    JButton disconnect = new JButton("Disconnect");

    // Variables
    String nickname;
    String message = "";
    String dataToSend = "";

    // Socket config
    int port = 55555;
    String group = "224.0.0.1";
    InetAddress toAdr = InetAddress.getByName(group);
    MulticastSocket socket = new MulticastSocket(port);


    public chatroomSend()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){
            System.exit(0);
        }

        textArea.setFont(new Font("Monospace", Font.PLAIN, 15));
        panel.setLayout(new GridLayout(1,6));
        panel.add(new JLabel("Type something: ", JLabel.RIGHT));

        panel.add(textField);
        panel.add(button);
        panel.add(disconnect);

        button.addActionListener(this);
        textField.addActionListener(this);

        disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    socket.leaveGroup(toAdr);
                }
                catch(IOException ex){
                    System.out.print("Couldn't leave group");
                }
                textArea.append("You have been disconnected");
            }
        });

        textArea.setEditable(false);
        add(panel, BorderLayout.SOUTH);
        add(scrollPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        socket.joinGroup(toAdr);
        ReadThread m = new ReadThread(socket, textArea);
        Thread t = new Thread(m);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        message = textField.getText();
        dataToSend = nickname+": "+message;
        byte[] data = dataToSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, port);
        try{
            socket.send(packet);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        textField.setText("");
    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        chatroomSend ts = new chatroomSend();
    }
}
