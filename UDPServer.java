
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(65432);

            byte[] buffer = new byte[1024];
            System.out.println("port 65432");
            while (true) { 
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(),0,packet.getLength());
                System.out.println("Recieved: "+ message);
                String res = "Ack: "+ message;
                byte[] resData = res.getBytes();
                InetAddress clientAddress = packet.getAddress();
                int port = packet.getPort();
                DatagramPacket resPacket = new DatagramPacket(resData,resData.length,clientAddress, port);
                socket.send(resPacket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
