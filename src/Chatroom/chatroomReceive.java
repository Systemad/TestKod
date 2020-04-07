package Chatroom;
import java.io.IOException;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class chatroomReceive extends JFrame  {

    JPanel panel = new JPanel();
    JTextArea text = new JTextArea(30, 20);

    public chatroomReceive() throws SocketException, IOException{
        this.add(panel);
        panel.add(text);
        this.pack();
        this.setLocation(500, 300);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
            text.setText(text.getText()+" "+message+ "\n");
            //System.out.println(message);
        }
    }

    public static void main(String[] args) throws SocketException, IOException{
        chatroomReceive tc = new chatroomReceive();
    }


}
