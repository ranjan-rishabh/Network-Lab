
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
            String s1 = ip1.getHostAddress();
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
            sb.setLength(0);
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)=='.')
                    break;
                else
                    sb.append(s1.charAt(i));
            }
            String s2 = sb.toString();
            int i = Integer.parseInt(s2);
            if(i>=1&&i<=126)
                System.out.println("A");
            else if(i<192)
                System.out.println("B");
            else if(i<224)
                System.out.println("C");
            else if(i<240)
                System.out.println("D");
            else if(i<256)
                System.out.println("E");
            else
                System.out.println("No Class Found");               
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
