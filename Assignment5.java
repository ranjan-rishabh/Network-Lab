//Sender
package assignment5;
import java.net.*;
import java.io.*;
public class Assignment5 {
    public static void main(String[] args) {
        try
        {
            MulticastSocket mu1 = new MulticastSocket(1459);
            mu1.joinGroup(InetAddress.getByName("225.15.4.4"));
            byte[] recData = new byte[1024];
            DatagramPacket recPacket = new DatagramPacket(recData,recData.length);
            while(true)
            {
                mu1.receive(recPacket);
                String s = new String("GetOut1");
                byte[] b = s.getBytes();
                if(recPacket.getData()==b)
                {
                    mu1.leaveGroup(InetAddress.getByName("225.15.4.4"));
                    break;
                }
                System.out.println("From Sender:"+recPacket.getData());
            }
            System.out.println("Group Left");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
