package webcaching;

import java.util.*;
import java.sql.Timestamp;
import java.io.*;

public final class Webcaching extends Thread 
{
    int hitCountOfLru=0, missCountOfLru=0;
    int hitCountOfLrupref=0, missCountOfLrupref=0;
    int hitCountOfLfu=0, missCountOfLfu=0;
    Queue<PageRequestEvent> pageRequestEventQueue;
    PageRequestEvent pageRequestEvent;
    LFUBasedWebCache lfu;
    LRUBasedWebcache lru;
    LRUWebCacheWithPrefetch lrupref;
    
   public Webcaching(Queue<PageRequestEvent> pageRequestEventQueue)
   {
       
       
       this.pageRequestEventQueue=pageRequestEventQueue;
       
       this.lru=new LRUBasedWebcache();
       
       this.lfu=new LFUBasedWebCache();
       
       this.lrupref=new LRUWebCacheWithPrefetch();
       
       int ch;
       System.out.println("Enter value between 1-2 :");
       System.out.println("1 for LRU implementation");
       System.out.println("2 for LFU implementation");
       System.out.println("3 for LFU implementation with prefetching");
       Scanner sc=new Scanner(System.in);
       ch=sc.nextInt();
       switch(ch)
       {
           case 1:
               checkPageInLRUCache();
               System.out.println("hit count while using LRU is  "+this.hitCountOfLru+" and \nmiss count while using LRU is "+this.missCountOfLru);
               break;
           case 2:
               checkPageInLFUCache();
               System.out.println("hit count while using LFU is  "+this.hitCountOfLfu+" and \nmiss count while using LFU is "+this.missCountOfLfu);
               break;
           case 3:
               checkPageInLRUCachewithPrefetching();
               checkPageInLRUCachewithPrefetching();
               System.out.println("hit count while using LRU with prefetching is  "+this.hitCountOfLrupref +" and \nmiss count while using LRU with prefetching is "+this.missCountOfLrupref);
               break;
        }
            
       //printPageRequestQueue();    
   }
     
   public void checkPageInLRUCache()
   {
       
       int page;
       Timestamp time;
       boolean lruvalue;
       while(!pageRequestEventQueue.isEmpty())
       {
       pageRequestEvent=pageRequestEventQueue.remove();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       
       lruvalue=lru.checkPage(page, time);
       if(lruvalue)
               {
                   hitCountOfLru++;
               }
               else
               {
                    missCountOfLru++;
               }
        }
   }
   public void checkPageInLRUCachewithPrefetching()
   {
       int page;
       Timestamp time;
       boolean lruvalue;
       while(!pageRequestEventQueue.isEmpty())
       {
       pageRequestEvent=pageRequestEventQueue.remove();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       
       lruvalue=lrupref.checkPage(page, time);
       if(lruvalue)
               {
                   hitCountOfLrupref++;
               }
               else
               {
                   missCountOfLrupref++;
               }
        }
   }
   public void checkPageInLFUCache()
   {
       int page;
       Timestamp time;
       boolean lruprefvalue;
       while(!pageRequestEventQueue.isEmpty())
       {
       pageRequestEvent=pageRequestEventQueue.remove();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       try
       {
       lruprefvalue=lrupref.checkPage(page, time);
       if(lruprefvalue)
               {
                   hitCountOfLfu++;
               }
               else
               {
                    missCountOfLfu++;
               }
       }catch(Exception e){
           System.out.println(e);
       }
       
       }
   }
   
   public void printPageRequestQueue()
   {
        int page;
        Timestamp time;
        while(!pageRequestEventQueue.isEmpty())
        {
            pageRequestEvent=pageRequestEventQueue.remove();
            page=pageRequestEvent.page;
            time=pageRequestEvent.time;
            System.out.println("page is"+ page);
            System.out.println("page is"+ time);
        }
   }
}