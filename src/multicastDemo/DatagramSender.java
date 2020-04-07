package multicastDemo;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DatagramSender {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 5555;
        DatagramSocket socket = new DatagramSocket();
        String message;

        System.out.println("?: ");

        while((message = in.readLine()) != null ){
            if(message.equals("bye")) System.exit(0);

            byte[] data = message.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);

            socket.send(packet);
            System.out.println("?: ");

        } System.exit(0);

    }
}
