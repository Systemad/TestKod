package weatherReport;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDateTime;

public class weatherReceive extends JFrame {

    int minPort = 5555;
    DatagramSocket socket = new DatagramSocket(minPort);
    byte[] data = new byte[256];

    public weatherReceive() throws SocketException, IOException {
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Message from: " +packet.getAddress().getHostAddress() + " " + LocalDateTime.now());
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }
    }


    public static void main(String[] args) throws SocketException, IOException {
        weatherReceive test = new weatherReceive();
    }
}
