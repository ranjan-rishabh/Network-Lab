package assignment6_1;
import java.io.IOException;
import java.net.*;
public class Assignment6_1 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        boolean[] rec = {false,false,false,false,false,false,false,false};
        byte[] recData = new byte[1024];
        byte[] senData = new byte[1024];
        //InetAddress IP = InetAddress.getByName("localhost");
        DatagramSocket recSocket = new DatagramSocket(1459);
        int c = 0;
        for(int i=0;;i++)
        {
            DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
            recSocket.receive(recPacket);
            InetAddress IP = recPacket.getAddress();
            String sen = new String(recPacket.getData());
            System.out.println("From Sender:" + sen);
            int k = (int)sen.charAt(4) - 48;
            rec[k] = true;
            if(c!=k||(i%2!=0))
            {
                if(i%2!=0&&c==k)
                    while(rec[c] != false)
                        c = (c+1)%8;
                String s = new String("Ack_" + Integer.toString(c));
                senData = s.getBytes();
                DatagramPacket senPacket = new DatagramPacket(senData, senData.length, IP, recPacket.getPort());
                recSocket.send(senPacket);
                System.out.println("Ack Sent");
            }
            else
            {
                while(rec[c] != false)
                    c = (c+1)%8;
                String s = new String("Ack_8");
                senData = s.getBytes();
                DatagramPacket senPacket1 = new DatagramPacket(senData, senData.length, IP, recPacket.getPort());
                recSocket.send(senPacket1);
            }
            int t = 0;
            while(rec[t++]!=false&&t<8);
            if(t>=8)
            {
                System.out.println("All Packets Received");
                String s = new String("All Packets Received");
                senData = s.getBytes();
                DatagramPacket senf = new DatagramPacket(senData, senData.length, IP, recPacket.getPort());
                recSocket.send(senf);
                break;
            }
        }
    }    
}
