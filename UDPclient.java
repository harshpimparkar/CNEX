
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPclient {
    public static void main(String[] args) {
        try {
            
            DatagramSocket socket = new DatagramSocket();
            InetAddress server = InetAddress.getByName("localhost");

            String message = "hello";
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, server,65432);
            socket.send(packet);
            System.out.println("Sent: "+message);
            
            byte[] buffer =new byte[1024];
            DatagramPacket resPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(resPacket);
            String res = new String(resPacket.getData(),0,resPacket.getLength());
            System.out.println("Recived: "+res);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
