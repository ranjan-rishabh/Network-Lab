
package assignment6;
import java.net.*;
import java.util.Scanner;
public class Assignment6 {
    public static void main(String[] args) {
        try
        {
            Scanner in = new Scanner(System.in);
            String[] strIn = {"ris","rah","pra","kan","san","shl","bha","dex"};
            boolean[] sent = {false,false,false,false,false,false,false,false};
            DatagramSocket senSocket = new DatagramSocket();
            InetAddress IP = InetAddress.getByName("localhost");
            byte[] senData = new byte[1024];
            byte[] recData = new byte[1024];
            int k=0, oack=-1;
            for(;;)
            {
                String sen = strIn[k] + "_" + Integer.toString(k);
                senData = sen.getBytes();
                sent[k] = true;
                DatagramPacket senPacket = new DatagramPacket(senData, senData.length, IP, 1459);
                senSocket.send(senPacket);
                DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
                String recSent = new String(recPacket.getData());
                int ack = Integer.parseInt(recSent.charAt(4));                
                if(ack == 8)
                {
                    int a = in.nextInt();
                    k = a;
                }
                else
                {
                    System.out.println("From Receiver:"+recSent);
                    if(oack == ack)
                        k = ack;
                    else 
                    {
                        while(sent[k] == true)
                            k = (k+1)%8;
                    }
                    oack = ack;                  
                }
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
