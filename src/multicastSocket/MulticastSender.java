package multicastSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MulticastSender {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String ip = "239.0.1.2";
    InetAddress iadr = InetAddress.getByName(ip);
    int port = 20480;
    MulticastSocket socket = new MulticastSocket(port);

    DatagramPacket packet;
    byte[] data;
    String prompt = "What do you want to send? ";
    String message;

    public MulticastSender() throws UnknownHostException, SocketException, IOException{
        // socket.joinGroup(iadr);
        System.out.println(prompt);
        while((message = in.readLine()) != null){
            if (message.equals("bye"))  System.exit(0);
            data = message.getBytes();
            packet = new DatagramPacket(data, data.length, iadr, port);
            socket.send(packet);
            System.out.println(prompt);
        } System.exit(0);
    }

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
        MulticastSender dgs = new MulticastSender();
    }
}
