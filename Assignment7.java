package assignment7;
import java.net.*;
import java.math.*;
public class Assignment7 {

    public static void main(String[] args) {
        try
        {
            boolean[] game = {false,false,false,false,false,false,false,false,false};
            DatagramSocket recSocket = new DatagramSocket(1459);
            byte[] rec = new byte[1024];
            byte[] sen = new byte[1024];
            while(true)
            {
                DatagramPacket recPacket = new DatagramPacket(rec,rec.length);
                recSocket.receive(recPacket);
                String recData = new String(recPacket.getData());
                InetAddress Ip = recPacket.getAddress();
                String sh = recData.substring(0, 7);
                System.out.println(sh);
                for(int i=7; i<16; i++)
                {
                    if(recData.charAt(i)=='X'||recData.charAt(i)=='O')
                        game[i-7]=true;
                    System.out.print(recData.charAt(i));
                    if(i%3==0)
                        System.out.println();
                }
                if(sh.equalsIgnoreCase("Winner:")||sh.equalsIgnoreCase("LoserG:"))
                    break;
                int r;
                while(true)
                {
                    r = (int)(Math.random()*9);
                    System.out.println("Move:"+ r);
                    if(game[r])
                        System.out.println("Invalid Move");
                    else
                        break;
                }
                String s = Integer.toString(r);
                sen = s.getBytes();
                DatagramPacket senPacket = new DatagramPacket(sen,sen.length,Ip,recPacket.getPort());
                recSocket.send(senPacket);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
