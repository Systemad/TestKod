package Temperature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;


public class TemperatureSend extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JTextField text = new JTextField(10);


    JButton button = new JButton("Send");
    String nickname;
    String message = "";
    String dataToSend = "";
    //InetAddress toAdr = InetAddress.getLocalHost();
    int port = 55555;
    String group = "224.0.0.1";
    InetAddress toAdr = InetAddress.getByName(group);
    MulticastSocket mSocket = new MulticastSocket(port);

    public TemperatureSend()throws UnknownHostException, SocketException, IOException, InterruptedException{

        nickname = JOptionPane.showInputDialog(null, "Nickname: ");
        if (nickname == null || nickname.length() == 0){
            System.exit(0);
        }

        // JOIN GROUP
        mSocket.joinGroup(toAdr);
        byte[] data = new byte[256];


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
        dataToSend = nickname+": "+message;
        byte[] data = dataToSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, port);
        try{
            mSocket.send(packet);
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