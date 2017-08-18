
package assignment4_1;
import java.io.*;
import java.net.*;
public class Assignment4_1 {
    public static void main(String[] args) {
        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            Socket cliSocket = new Socket("localhost",1459);
            DataOutputStream ou = new DataOutputStream(cliSocket.getOutputStream());
            InputStreamReader in1 = new InputStreamReader(cliSocket.getInputStream());
            BufferedReader inServer = new BufferedReader(in1);
            String Sen = inServer.readLine();
            System.out.println("From Server:"+Sen);
            while(true)
            {
                System.out.print("Message:");
                String senOut = br.readLine();
                ou.writeBytes(senOut+'\n');
                System.out.println("Waiting For Server Reply");
                String senIn = inServer.readLine();
                System.out.println("From Server:"+senIn);
            }
        }
        catch(Exception e)
        {
            System.out.println("Done!!");
        }
    }
}
