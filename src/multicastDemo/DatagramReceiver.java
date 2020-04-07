package multicastDemo;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.time.LocalDateTime;

public class DatagramReceiver {
    public static void main(String[] args) throws SocketException, IOException {


        // net ip
        //InetAddress ip1 = InetAddress.getLocalHost();
        //System.out.println(ip1);

        // local
        //InetAddress ip2 = InetAddress.getLoopbackAddress();
        //System.out.println(ip2);

        int minPort = 5555;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];

        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Meddelande från "+packet.getAddress().getHostAddress() + " " +LocalDateTime.now());
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }

    }
}
