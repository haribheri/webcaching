package webcaching;

import java.util.*;
import java.sql.Timestamp;
import java.util.Date;
import java.io.*;
public class Webcaching 
{
    int hitCountOfLru=0, missCountOfLru=0;
    int hitCountOfLfu=0, missCountOfLfu=0;
    int page;
    Timestamp time;
    Queue<PageRequestEvent> pageRequestEventQueue;
    PageRequestEvent pageRequestEvent;
    LFUBasedWebCache lfu;
    LRUBasedWebcache lru;
        
   public Webcaching(Queue<PageRequestEvent> pageRequestEventQueue)
   {
       this.pageRequestEventQueue=pageRequestEventQueue;
       this.pageRequestEvent=pageRequestEventQueue.remove();
       this.page=pageRequestEvent.page;
       this.time=pageRequestEvent.time;
   }
   
   public int checkPage()
   {
       Scanner file=null;
       try
       {
           file=new Scanner(new FileInputStream("C:\\Users\\Srihari\\Desktop\\om.txt"));           
       }
       catch(FileNotFoundException e)
       {
           System.out.println("unable to locate file");
           System.exit(0);      
       }
       int ch=file.nextInt();      
       switch(ch)
       {
           case 1:
              
               
       }
       return 0;
   }
   }