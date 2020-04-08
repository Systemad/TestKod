package Chatroom;
import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.net.*;

/*
public class chatroomReceive implements Runnable {

    public chatroomReceive(String messageFrom) throws SocketException, IOException{
        int minPort = 55555;
        String ip = "224.0.0.1";
        InetAddress iadr = InetAddress.getByName(ip);
        MulticastSocket socket = new MulticastSocket(minPort);


        socket.joinGroup(iadr);
        byte[] data = new byte[256];

        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            //System.out.println(message);
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
*/

public class ReadThread implements Runnable {
    private MulticastSocket socket;
    private  InetAddress adr;
    private int port;
    private String ip;

    public ReadThread(MulticastSocket socket, InetAddress adr, int port) {
        this.socket = socket;
        this.adr = adr;
        this.port = port;
    }

    @Override
    public void run(){
        while(!Thread.interrupted()){
            byte[] data = new byte[256];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            String message;

            try{

                socket.receive(packet);
                message = new String(packet.getData(), 0, packet.getLength());
                System.out.print(message);
            }
            catch(IOException e){
                System.out.print("Connection Closed");
                break;
            }
        }
    }
}
