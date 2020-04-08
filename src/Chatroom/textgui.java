package Chatroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.nio.ByteOrder;

public class textgui extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JTextField textField = new JTextField();

    JButton button = new JButton("Send");
    JButton disconnect = new JButton("Disconnect");

    JTextArea textArea = new JTextArea(10, 60);
    JScrollPane scrollPanel = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    String nickname;
    String message = "";
    String dataToSend = "";

    int port = 55555;
    String group = "224.0.0.1";
    InetAddress toAdr = InetAddress.getByName(group);
    MulticastSocket socket = new MulticastSocket(port);


    public textgui()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){
            System.exit(0);
        }

        textArea.setFont(new Font("Monospace", Font.PLAIN, 12));
        panel.setLayout(new GridLayout(1,6));
        panel.add(new JLabel("Type something", JLabel.RIGHT));
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



        add(panel, BorderLayout.NORTH);
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
        textgui ts = new textgui();
    }
}
