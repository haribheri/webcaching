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
       this.lru=new LRUBasedWebcache();
       this.lfu=new LFUBasedWebCache();
   }
   public int checkPageInLRUCache()
   {
       boolean lruvalue=lru.checkPage(page, time);
       if(lruvalue)
               {
                   hitCountOfLru++;
               }
               else
               {
                    missCountOfLru++;
               }
       return hitCountOfLru;
   }
   public int checkPageInLFUCache()
   {
       boolean lfuvalue=lfu.checkPage(page, time);
       if(lfuvalue)
               {
                   hitCountOfLfu++;
               }
               else
               {
                    missCountOfLfu++;
               }
       return hitCountOfLfu;
   }
}