import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception{
        try {
            String ip = "192.168.43.234";
            Socket s = new Socket(ip,8989);
            System.out.println("Connected!");

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            
            String msg = "";
            while (!msg.equals("close")){
            msg = buff.readLine();
            dout.writeUTF(msg);
        }
            
            buff.close();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }        
    }
}
