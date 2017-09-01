
package assignment6_1;
import java.io.IOException;
import java.net.*;
public class Assignment6_1 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        boolean[] rec = {false,false,false,false,false,false,false,false};
        byte[] recData = new byte[1024];
        byte[] senData = new byte[1024];
        InetAddress IP = InetAddress.getByName("localhost");
        DatagramSocket recSocket = new DatagramSocket(1459);
        int c = 0;
        for(;;)
        {
            for(int i=0;i<2;i++)
            {
                DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
                String sen = new String(recPacket.getData());
                System.out.println("From Sender:" + sen);
                Integer k = Integer.parseInt(""+sen.charAt(sen.length()-1));
                rec[k] = true;
                if(c!=k)
                    break;
                while(rec[c] == false)
                    c = (c+1)%8;
                String s = new String("Ack_8");
                senData = s.getBytes();
                DatagramPacket senPacket1 = new DatagramPacket(senData, senData.length, IP, 1459);
            }
            String s = new String("Ack_" + Integer.toString(c));
            senData = s.getBytes();
            DatagramPacket senPacket = new DatagramPacket(senData, senData.length, IP, 1459);
            recSocket.send(senPacket);
            System.out.println("Ack Sent");
        }
    }    
}
