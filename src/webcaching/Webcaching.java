package webcaching;

import java.util.*;
import java.sql.Timestamp;
import java.io.*;

public final class Webcaching extends Thread 
{
    int hitCountOfLfu=0, missCountOfLfu=0;
    int hitCountOfLru=0, missCountOfLru=0;
    int hitCountOfLruTime=0, missCountOfLruTime=0;
    int hitCountOfLrupref=0, missCountOfLrupref=0;
    
    Queue<PageRequestEvent> pageRequestEventQueue;
    PageRequestEvent pageRequestEvent;
    LFUBasedWebCache lfu;
    LRUBasedWebcache lru;
    LRUWebCacheWithPrefetch lrupref;
    LRUWebCacheWithObjectLifeTime lrutime;
    
   public Webcaching(Queue<PageRequestEvent> pageRequestEventQueue)
   {      
       this.pageRequestEventQueue=pageRequestEventQueue;
       
       this.lru=new LRUBasedWebcache();
       
       this.lfu=new LFUBasedWebCache();
       
       this.lrutime=new LRUWebCacheWithObjectLifeTime();
       
       this.lrupref=new LRUWebCacheWithPrefetch();
       
               printPageRequestQueue(); //print requested pages
               System.out.println();
               checkPageInLFUCache();  //LFU ALOGORITHM
               System.out.println("hit count while using LFU is  "+this.hitCountOfLfu+" and \nmiss count while using LFU is "+this.missCountOfLfu);
               lfu.displayCache();
               System.out.println();
               checkPageInLRUCache();  //LRU ALGORITHM
               System.out.println("hit count while using LRU is  "+this.hitCountOfLru+" and \nmiss count while using LRU is "+this.missCountOfLru);
               lru.displayCache();
               System.out.println();
               checkPageInLRUCacheWithObjectLifeTime(); //LRU-WITH-OBJECT LIFE TIME
               System.out.println("hit count while using LRU-with-TIME is  "+this.hitCountOfLruTime+" and \nmiss count while using LRU-with-TIME is "+this.missCountOfLruTime);
               lrutime.displayCache();
               System.out.println();
               checkPageInLRUCachewithPrefetching(); //LRU WITH PREFETCHING
               System.out.println("hit count while using LRU with prefetching is  "+this.hitCountOfLrupref +" and \nmiss count while using LRU with prefetching is "+this.missCountOfLrupref);
               lrupref.displayCache();
               lrupref.displayPrefCache();
       
   }
   
   public void printPageRequestQueue()
   {
        int page;
        Timestamp time;
        Iterator<PageRequestEvent> itr=pageRequestEventQueue.iterator();
        try
        {
            while(itr.hasNext())
        {
            pageRequestEvent=itr.next();
            page=pageRequestEvent.page;
            time=pageRequestEvent.time;
            System.out.print(page+"\t");
            //System.out.println("page is"+ time);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println();
   }
  
   public void checkPageInLFUCache()
   {
       int page;
       Timestamp time;
       boolean lfuvalue;
       try
       {
       Iterator<PageRequestEvent> itr=pageRequestEventQueue.iterator();      
       while(itr.hasNext())
       {
       pageRequestEvent=itr.next();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       
       lfuvalue=lfu.checkPage(page, time);
       if(lfuvalue)
               {
                   hitCountOfLfu++;
               }
               else
               {
                    missCountOfLfu++;
               }             
       }
       }catch(Exception e)
       {
           System.out.println(e);
       }
       
   }
  
   public void checkPageInLRUCache()
   {
       int page;
       Timestamp time;
       boolean lruvalue;
       Iterator<PageRequestEvent> itr=pageRequestEventQueue.iterator();
       try
       {
       while(itr.hasNext())
       {
       pageRequestEvent=itr.next();
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
       }catch(Exception e)
       {
           System.out.println(e);
       }
       
   }
   
   public void checkPageInLRUCacheWithObjectLifeTime()
   {
       int page;
       Timestamp time;
       boolean lrutimevalue;
       Iterator<PageRequestEvent> itr=pageRequestEventQueue.iterator();
       try
       {
       while(itr.hasNext())
       {
       pageRequestEvent=itr.next();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       
       lrutimevalue=lrutime.checkPage(page, time);
       if(lrutimevalue)
               {
                   hitCountOfLruTime++; 
               }
               else
               {
                    missCountOfLruTime++;
               }
        }
       }catch(Exception e)
       {
           System.out.println(e);
       }       
   }
   
   public void checkPageInLRUCachewithPrefetching()
   {
       int page;
       Timestamp time;
       boolean lruprefvalue;
       Iterator<PageRequestEvent> itr=pageRequestEventQueue.iterator();
       try
       {
       while(itr.hasNext())
       {
       pageRequestEvent=itr.next();
       page=pageRequestEvent.page;
       time=pageRequestEvent.time;
       
       lruprefvalue=lrupref.checkPage(page, time);
       if(lruprefvalue)
               {
                   hitCountOfLrupref++;
               }
               else
               {
                   missCountOfLrupref++;
               } 
       }
       }catch(Exception e)
       {
           System.out.println(e);
       }
   }
}   