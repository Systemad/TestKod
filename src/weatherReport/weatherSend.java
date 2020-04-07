package weatherReport;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class weatherSend extends JFrame {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    InetAddress toAdr = InetAddress.getLocalHost();
    int toPort = 5555;
    DatagramSocket socket = new DatagramSocket();
    String message;

    private JPanel panel = new JPanel();
    //private JButton open = new JButton("Send Message");
    //String g_sendMessage = JOptionPane.showInputDialog(null, "Message to send");


    public weatherSend() throws UnknownHostException, SocketException, IOException{
        while((message = in.readLine()) != null ){
            if(message.equals("bye")) System.exit(0);

            byte[] data = message.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);

            socket.send(packet);
            System.out.println("?: ");

        } System.exit(0);
    }


    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        weatherSend test = new weatherSend();
    }
}
