package assignment8_1;
import java.io.*;
import java.net.*;
public class Assignment8_1 {
    public static void main(String[] args) throws Exception {
        Socket toSvr = new Socket("localhost", 1459);
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Responder h = new Responder();
        int i=1;
        while (true) 
        {
            Socket connectionSocket = welcomeSocket.accept();
            Thread t = new Thread(new MyServer(h, connectionSocket, i++, toSvr));
            t.start();
        }
    }
}
 
class MyServer implements Runnable 
{
 
    Responder h;
    Socket connectionSocket,toSvr;
    int na;
    public MyServer(Responder h, Socket connectionSocket, int na, Socket toSvr) 
    {
        this.h = h;
        this.connectionSocket = connectionSocket;
        this.na = na;
        this.toSvr = toSvr;
    }
 
    @Override
    public void run() 
    {
 
        while (h.responderMethod(connectionSocket, toSvr, na)) 
        {
            try 
            {
                Thread.sleep(5000);
            } 
            catch (InterruptedException ex) 
            {
                ex.printStackTrace();
            }
        }
 
        try 
        {
            connectionSocket.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    } 
} 

class Responder 
{ 
    String serverSentence;
    synchronized public boolean responderMethod(Socket connectionSocket, Socket toSvr, int na) 
    {
        try 
        {
            BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient =new DataOutputStream(connectionSocket.getOutputStream());
            DataOutputStream outToSvr =new DataOutputStream(toSvr.getOutputStream());
            BufferedReader inFromSvr =new BufferedReader(new InputStreamReader(toSvr.getInputStream()));
            String clientSentence = inFromClient.readLine(); 
            if (clientSentence == null || clientSentence.equals("EXIT")) 
            {
                return false;
            } 
            if (clientSentence != null) 
            {
                System.out.println("Client:"+na+" sent to server");
                clientSentence = "Client"+Integer.toString(na)+": "+clientSentence;
                outToSvr.writeBytes(clientSentence+"\n");
            }
            String inSvr = inFromSvr.readLine();
            serverSentence = inSvr + "\n"; 
            outToClient.writeBytes(serverSentence+"\n");
            System.out.println("Server Sent To Client:"+na);
            return true; 
        } 
        catch (SocketException e) 
        {
            System.out.println("Disconnected");
            return false;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }
 }
