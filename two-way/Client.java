import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scn =new Scanner(System.in);
            System.out.println("Enter the IP Address: ");
            String ipaddr = scn.nextLine();

            Socket soc = new Socket(ipaddr,5555);
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

            String str="",str2="";
            while(!str.equals("Bye")){
                System.out.print("\nME:");
                str = buff.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = dis.readUTF();
                System.out.print("\nServer: "+str2);                
            }
            
            dis.close();
            dout.close();
            buff.close();
            soc.close();
            scn.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}