package Chatroom;
import java.io.IOException;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class chatroomReceive implements Runnable {

    private String textArea;


    public chatroomReceive(String textArea, MulticastSocket mSocket) throws SocketException, IOException{

        this.textArea = textArea;

        //int minPort = 55555;
        String ip = "224.0.0.1";
        InetAddress iadr = InetAddress.getByName(ip);
        //MulticastSocket socket = new MulticastSocket(minPort);

        //MulticastSocket multicastSocket = new MulticastSocket(mSocket);

        mSocket.joinGroup(iadr);
        byte[] data = new byte[256];

        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            mSocket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        }
    }

    @Override
    public void run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
}
