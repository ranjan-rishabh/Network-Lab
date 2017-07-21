
package assignment1;
import java.util.Scanner;
import java.net.*;

public class Assignment1 {

    public static void main(String[] args) {
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("1)Local Hostname:"+ip.getHostName());
            System.out.println("2)Local HostAddress:"+ip.getHostAddress());
            Scanner in =new Scanner(System.in);
            System.out.println("Enter Remote Hostname:");
            String s = in.next();
            InetAddress ip1 = InetAddress.getByName(s);
            System.out.println("3)IP Address Remote Host:"+ip1.getHostAddress());
            System.out.println("Enter Remote IP Address:");
            s = in.next();
            ip1 = InetAddress.getByName(s);
            System.out.println("Remote HostAddress:"+ip1.getHostName());
            NetworkInterface ni = NetworkInterface.getByInetAddress(ip);
            byte macAddress[] = ni.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < macAddress.length; i++) 
            {
		sb.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }
            System.out.println("4)Local Mac Address:"+sb.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
