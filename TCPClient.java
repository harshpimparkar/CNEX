
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",65432);

            OutputStream op = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(op,true);

            InputStream inp = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inp));
            
            String message = "Hello";
            System.out.println("Sending: "+message);

            pw.println(message);
            String res = br.readLine();
            System.out.println("Recieved: "+res);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
