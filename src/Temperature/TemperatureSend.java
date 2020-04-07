package Temperature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.*;


public class TemperatureSend extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JTextField text = new JTextField(10);


    JButton button = new JButton("Send");
    String nickname;
    String message = "";
    String dataToSend = "";
    InetAddress toAdr = InetAddress.getLocalHost();
    int toPort = 55555;
    DatagramSocket socket = new DatagramSocket();

    public TemperatureSend()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){  //tar hand om Cancel-tryck
            System.exit(0);
        }


        this.add(panel);
        panel.add(text);
        panel.add(button);

        button.addActionListener(this);
        text.addActionListener(this);

        this.pack();
        this.setLocation(800, 300);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        message = text.getText();
        dataToSend = nickname+", "+message;
        byte[] data = dataToSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
        try{
            socket.send(packet);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        text.setText("");
    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        TemperatureSend ts = new TemperatureSend();
    }
}