import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.print("IP Address is " + ip.getHostAddress());

            ServerSocket ss = new ServerSocket(5555);
            Socket s = ss.accept();
            System.out.println("Connected.");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

            String str="",str2="";
            while(!str.equals("Bye")){
                str = dis.readUTF();
                System.out.print("\nClient :" +str);
                System.out.print("\nME:");
                str2 = buff.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }  
            dis.close();
            dout.close();
            buff.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}