package webcaching;

import java.io.*;
import java.awt.*;
import java.util.*;
        
public class Client {
 
    int numberOfPages ,i;
    Queue pageRequestEvent;
    public Client(Queue pageRequestEvent)
    {
        this.pageRequestEvent=pageRequestEvent;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of pages");
        this.numberOfPages=sc.nextInt();
    }
   public int generatePage()
   {
       int page;
       int i=100;
       Random rand=new Random();
       while(i!=0)
       {
       page=rand.nextInt(numberOfPages);
       i--;
       }
       return page;
   }
   public int sendPageRequest()
   {   
       int page;
       page=generatePage();
       pageRequestEvent.add(page);
       return page;
   }
   public void receiveRequestedPage()
   {
       
   }
}
