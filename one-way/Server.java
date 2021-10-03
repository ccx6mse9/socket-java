import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) throws Exception{
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.print(ip.getHostAddress());

            ServerSocket ss =new  ServerSocket(8989);
            Socket s = ss.accept();
            System.out.println("Connected . . !");

            DataInputStream din = new DataInputStream(s.getInputStream());
            
            String msg = "";
            while (!msg.equals("close")){
                msg = din.readUTF();
                System.out.print(msg);
            }
            
            din.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}