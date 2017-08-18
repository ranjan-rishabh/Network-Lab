
package assignment3;
import java.net.*;
import java.util.Scanner;
public class Assignment3 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        try
        {
            DatagramSocket svrSocket = new DatagramSocket(5636);
            byte[] recData = new byte[2048];
            byte[] senData = new byte[2048];
            DatagramPacket recPacket = new DatagramPacket(recData,recData.length);
            svrSocket.receive(recPacket);
            String s1 = new String(recPacket.getData());
            System.out.println("Messege:"+s1);
            InetAddress ip = recPacket.getAddress();
            System.out.println("IP:"+ip.getHostAddress());
            int port = recPacket.getPort();
            String s = in.next();
            senData = s.getBytes();
            DatagramPacket senPacket = new DatagramPacket(senData,senData.length,ip,port);
            svrSocket.send(senPacket);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
