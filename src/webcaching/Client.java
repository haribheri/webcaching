package webcaching;

import java.lang.*;
import java.io.*;
import java.awt.*;
import java.util.*;
        
public class Client {
 
    int numberOfPages ,i;
    PageRequestEvent pageRequestEvent;
    public Client(PageRequestEvent pageRequestEvent)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of pages");
        this.numberOfPages=sc.nextInt();
    }
   public int generatePage()
   {
       int page;
       Random rand=new Random();
       while(cond)
       {
       page=rand.nextInt(numberOfPages);
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
