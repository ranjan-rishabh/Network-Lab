
package assignment2;
import java.net.*;
import java.util.Scanner;
public class Assignment2_2 {
    
    public static void main(String[] args) {
        try
        {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            InetAddress ip = InetAddress.getByName(s);
            Socket s2 = new Socket(ip.getHostAddress(),80);
            System.out.println(s2.getLocalSocketAddress()+" "+s2.getInetAddress());
            for(int i=1;i<1024;i++)
            {
                try 
                {
                    Socket s1 = new Socket(ip.getHostAddress(),i);
                    System.out.println("Port: "+i+" Listening");
                    System.out.println("Local Port Number: "+s1.getLocalPort());
                }
                catch(Exception e)
                {
                    System.out.println("Port: "+i+" Not Listening");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
