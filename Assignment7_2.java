package assignment7_2;
import java.net.*;
public class Assignment7_2 {
    static char[] pl = new char[9]; 
    static boolean check()
    {
        boolean b=false;
        if(pl[0]!='_'&&pl[4]!='_'&&pl[8]!='_'&&pl[0]==pl[4]&&pl[8]==pl[0])
            b=true;
        if(pl[4]!='_'&&pl[2]!='_'&&pl[6]!='_'&&pl[4]==pl[2]&&pl[2]==pl[6])
            b=true;
        if(b==false)
            for(int i=0;i<9;i++)
            {
                
                
                    if(i%3==0)
                    {
                        if((pl[i]!='_'&&pl[i+1]!='_'&&pl[i+2]!='_')&&pl[i]==pl[i+1]&&pl[i]==pl[i+2])
                        {
                            b=true;
                            break;
                        }
                    }
                    if(i%3==1)
                    {
                        if(pl[i]!='_'&&pl[i-1]!='_'&&pl[i+1]!='_'&&pl[i]==pl[i-1]&&pl[i]==pl[i+1])
                        {
                            b=true;
                            break;
                        }
                    }
                    if(i%3==2)
                    {
                        if(pl[i]!='_'&&pl[i-1]!='_'&&pl[i-2]!='_'&&pl[i]==pl[i-1]&&pl[i]==pl[i-2])
                        {
                            b=true;
                            break;
                        }
                    }            
                    if(i/3==0)
                    {
                        if(pl[i]!='_'&&pl[i+3]!='_'&&pl[i+6]!='_'&&pl[i]==pl[i+3]&&pl[i]==pl[i+6])
                        {
                            b=true;
                            break;
                        }
                    }
                    if(i/3==1)
                    {
                        if(pl[i]!='_'&&pl[i-3]!='_'&&pl[i+3]!='_'&&pl[i]==pl[i-3]&&pl[i]==pl[i+3])
                        {
                            b=true;
                            break;
                        }
                    }
                    if(i/3==2)
                    {   
                        if(pl[i]!='_'&&pl[i-3]!='_'&&pl[i-6]!='_'&&pl[i]==pl[i-3]&&pl[i]==pl[i-6])
                        {
                            b=true;
                            break;
                        }
                    }
                
            }
        return b;
    }
    public static void main(String[] args) {
        try
        {
            DatagramSocket senSocket = new DatagramSocket();
            InetAddress Ip = InetAddress.getByName("localhost");
            byte[] rec = new byte[1024];
            byte[] sen = new byte[1024];
            boolean[] game = {false,false,false,false,false,false,false,false,false};
            for(int i=0;i<9;i++)
                pl[i]='_';
            while(true)
            {
                String bo;
                boolean b;
                String s;
                s= new String("BoardG:");
                for(int i=0;i<9;i++)
                    if(!game[i])
                        s+='_';
                    else
                        s+=pl[i];
                sen = s.getBytes();
                DatagramPacket senPacket = new DatagramPacket(sen,sen.length,Ip,1459);
                senSocket.send(senPacket);
                DatagramPacket recPacket = new DatagramPacket(rec,rec.length,Ip,1459);
                senSocket.receive(recPacket);
                String re = new String(recPacket.getData());
                int r = (int)re.charAt(0)-48;
                game[r]=true;
                pl[r]='X';               
                b = check();
                if(b)
                {  
                    s = new String("Winner:");
                    for(int i=0;i<9;i++)
                        if(!game[i])
                            s+='_';
                        else
                            s+=pl[i];
                    sen = s.getBytes();
                    senPacket = new DatagramPacket(sen,sen.length,Ip,1459);
                    senSocket.send(senPacket);
                    String t = new String("LoserG:");
                    t+=s.substring(7,16);
                    sen = t.getBytes();
                    DatagramPacket sen1 = new DatagramPacket(sen,sen.length,Ip,5636);
                    senSocket.send(sen1);
                }
                s= new String("BoardG:");
                for(int i=0;i<9;i++)
                    if(!game[i])
                        s+='_';
                    else
                        s+=pl[i];
                bo = s.substring(7, 16);
                sen = s.getBytes();
                DatagramPacket senPacket1 = new DatagramPacket(sen,sen.length,Ip,5636);
                senSocket.send(senPacket1);
                DatagramPacket recPacket1 = new DatagramPacket(rec,rec.length,Ip,5636);
                senSocket.receive(recPacket1);
                re = new String(recPacket1.getData());
                r = (int)re.charAt(0)-48;
                game[r]=true;
                pl[r]='O';
                b = check();
                if(b)
                {  
                    s = new String("Winner:");
                    for(int i=0;i<9;i++)
                        if(!game[i])
                            s+='_';
                        else
                            s+=pl[i];
                    bo = s.substring(7, 16);
                    sen = s.getBytes();
                    senPacket1 = new DatagramPacket(sen,sen.length,Ip,5636);
                    senSocket.send(senPacket1);
                    String t = new String("LoserG:");
                    t+=s.substring(7,16);
                    sen = t.getBytes();
                    DatagramPacket sen1 = new DatagramPacket(sen,sen.length,Ip,1459);
                    senSocket.send(sen1);
                }
                boolean l=true;
                for(int i=0;i<9;i++)
                    if(!game[i])
                        l=false;
                if(l)
                    System.out.println("Drawn Game:");
                else
                    System.out.println("Board:");
                for(int i=0; i<9; i++)
                {
                    System.out.print(bo.charAt(i));
                    if(i%3==2)
                        System.out.println();
                }
            }       
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
}
