//Sender
package assignment5_1;
import java.net.*;
import java.util.Scanner;
public class Assignment5_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try
        {
            DatagramSocket senSocket = new DatagramSocket();
            byte[] senData = new byte[1024];
            InetAddress IP = InetAddress.getByName("225.15.4.4");
            DatagramPacket senPacket = new DatagramPacket(senData,senData.length,IP,1459);
            while(true)
            {
                System.out.println("Sender Message:");
                String s = in.next();
                senData = s.getBytes();
                senSocket.send(senPacket);
                if()
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
