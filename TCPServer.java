
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(65432);
            System.out.println("port:" + 65432);
            Socket socket = server.accept();

            InputStream inp = socket.getInputStream();
            OutputStream op = socket.getOutputStream();
            BufferedReader br =  new BufferedReader(new InputStreamReader(inp));
            PrintWriter pw = new PrintWriter(op,true);

            String message;
            while((message=br.readLine()) != null){
                System.out.println("Message: "+message);
                pw.println("Ack: "+message);
            }
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
