package webcaching;

import java.util.*;
import java.sql.Timestamp;
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
   
   public int checkPageInCache()
   {
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
       int ch=file.nextInt();      
       switch(ch)
       {
           case 1:
               boolean lfuvalue=lfu.get(page, time);
               if(lfuvalue)
               {
                   hitCountOfLfu++;
               }                   
               else
               {
                   missCountOfLfu++;
               }
               
           break;
               
           case 2:
               boolean lruvalue=lru.get(page, time);
               if(lruvalue)
               {
                   hitCountOfLru++;
               }
               else
               {
                    missCountOfLru++;
               }
           break;              
        }
       return 0;
   }
   }