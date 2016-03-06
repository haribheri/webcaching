
package webcaching;

import java.io.*;
import java.awt.*;
import java.util.*;
        
public class Client {
 
    int numberOfClients, numberOfPages ,i;
    Client()
{
 
 int clientId[] , pages[];

Scanner sc=new Scanner(System.in);

System.out.println("enter number of clients");
numberOfClients=sc.nextInt();

System.out.println("enter number of pages");
numberOfPages=sc.nextInt();

clientId=new int[numberOfClients];

}	
   int generatePage()
   {
       int page;     
       Random rand=new Random();
       page=rand.nextInt(20);
       return page;
   }
   int sendPageRequest(int page)
   {
       return 0;
   }
   void receiveRequestedPage()
   {
       
   }
}
