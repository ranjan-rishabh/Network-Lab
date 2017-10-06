package assignment8;
import java.io.*;
import java.net.*;
public class Assignment8 {
    public static void main(String[] args) {
        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);            
            ServerSocket svr = new ServerSocket(1459);
            Socket svrSocket = svr.accept();
            System.out.println("Connection Established With Proxy Server");
            while(true)
            {
                DataOutputStream ouPr = new DataOutputStream(svrSocket.getOutputStream());
                BufferedReader inPr = new BufferedReader(new InputStreamReader(svrSocket.getInputStream()));
                String recSen = inPr.readLine();
                System.out.println(recSen);
                String senSen = br.readLine();
                ouPr.writeBytes(senSen+"\n");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
