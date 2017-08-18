
package assignment3_1;
import java.net.*;
import java.util.Scanner;
public class Assignment3_1 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        try
        {
            DatagramSocket cliSocket = new DatagramSocket();
            byte[] recData = new byte[2048];
            byte[] senData = new byte[2048];
            InetAddress IP = InetAddress.getByName("localhost");
            senData = s.getBytes();
            DatagramPacket senPacket = new DatagramPacket(senData,senData.length,IP,5636);
            cliSocket.send(senPacket);
            DatagramPacket recPacket = new DatagramPacket(recData,recData.length);
            cliSocket.receive(recPacket);
            String s1 = new String(recPacket.getData());
            System.out.println("From Server:"+s1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
