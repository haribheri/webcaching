
package webcaching;

import java.io.*;
import java.awt.*;
import java.util.*;
        
public class Client {
 
    int numberOfPages ,i;
    Client()
{
 
 int pages[];

Scanner sc=new Scanner(System.in);


System.out.println("enter number of pages");
numberOfPages=sc.nextInt();



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
