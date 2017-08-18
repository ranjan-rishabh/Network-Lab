
package assignment4;
import java.io.*;
import java.net.*;
public class Assignment4 {

    public static void main(String[] args) {
        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            ServerSocket svr = new ServerSocket(1459);
            Socket svrSocket = svr.accept();
            System.out.println("Connection Established");
            DataOutputStream ou = new DataOutputStream(svrSocket.getOutputStream());
            InputStreamReader in1 = new InputStreamReader(svrSocket.getInputStream());
            BufferedReader inClient = new BufferedReader(in1);
            String Sen = new String("Connection Establised");
            ou.writeBytes(Sen+'\n');
            while(true)
            {
                System.out.println("Waiting For Client Message");
                String senIn = inClient.readLine();
                System.out.println("Client:"+senIn);
                System.out.print("Message:");
                String senOut = br.readLine();
                ou.writeBytes(senOut+'\n');
            }
        }
        catch(Exception e)
        {
            System.out.println("Done!!");
        }
    }
    
}
