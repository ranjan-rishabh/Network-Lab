
package assignment2;
import java.net.*;

public class Assignment2 {
  
    public static void main(String[] args) {
        try
        {
            URL u = new URL("https://www.google.co.in/search?"
                    + "q=url+class+in+java&ie=utf-8&oe=utf-8&client=firefox-b-ab&"
                    + "gfe_rd=cr&ei=CLB6WZLTNYzT8gfwnqHgCw");
            System.out.println("Different Components of URL:");
            System.out.println("Hostname:"+u.getHost());
            System.out.println("Protocol:"+u.getProtocol());
            System.out.println("Path:"+u.getPath());
            System.out.println("Query:"+u.getQuery());
            System.out.println("Reference:"+u.getRef());
            System.out.println("Default Port:"+u.getDefaultPort());
            System.out.println("Authority:"+u.getAuthority());
            System.out.println("File:"+u.getFile());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
