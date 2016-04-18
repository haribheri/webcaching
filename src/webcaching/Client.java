package webcaching;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
        
public class Client extends Thread
{    
    public int numberOfPages, i;
    Queue<PageRequestEvent> pageRequestEventQueue;
    public Client(Queue<PageRequestEvent> pageRequestEventQueue)
    {
       this.pageRequestEventQueue=pageRequestEventQueue;
       Scanner file=null;
       try
       {
           file=new Scanner(new FileInputStream("G:\\Java\\Webcaching\\src\\input.txt"));           
       }
       catch(FileNotFoundException e)
       {
           System.out.println("unable to locate file");
           System.exit(0);      
       }
       this.numberOfPages=file.nextInt();
    }
    
   private int generatePage()
   {
       int page;
       Random rand=new Random();
       page=rand.nextInt(100);
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
