import java.io.*;
import java.net.*;  // Networking chya Conccept

class Server
{
    public static void main(String Arg[]) throws Exception
    {
        System.out.println("Server of Chat messanger is running...");

        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server is in the listening mode at port no : 2100");

        Socket sobj = ssobj.accept();//client request accept.
        System.out.println("Client and Server connection is succesful...");

        PrintStream ps = new PrintStream(sobj.getOutputStream());//maouth

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" Chat Messanger started...");

        String str1, str2;

        while((str1 = br1.readLine())!= null)
        {
            System.out.println("Client says : "+str1);
            System.out.println("Enter message for client : ");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("Thank you for using the chat messanger..");
        ssobj.close();
        sobj.close();
        ps.close();
        br1.close();
        br2.close();
    }
}