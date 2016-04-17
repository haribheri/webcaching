package webcaching;
import java.sql.Timestamp;
import java.util.Date;

import java.util.*;
        
public class Client extends Thread
{    
    public int numberOfPages, i;
    Queue<PageRequestEvent> pageRequestEventQueue;
    public Client(Queue<PageRequestEvent> pageRequestEventQueue)
    {
        this.pageRequestEventQueue=pageRequestEventQueue;
       /* Scanner sc=new Scanner(System.in);
        System.out.println("enter number of pages");
        this.numberOfPages=sc.nextInt();*/
    }
    
   private int generatePage()
   {
       int page;
       Random rand=new Random();
       page=rand.nextInt(numberOfPages);
       return page;
    }
   
   public int sendPageRequest()
   { 
     int page;
     page=generatePage();
     return page;
   }
   public Timestamp timestampForCurrentPage()
   {
       Timestamp time=generateTimestamp();
       return time;
   }
   public Timestamp generateTimestamp()
   {
       java.util.Date date= new java.util.Date();
       Timestamp time=new Timestamp(date.getTime());
       return time;
   }
   
   public void receiveRequestedPage()
   {
       
   }
}
