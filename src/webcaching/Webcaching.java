package webcaching;

import java.util.*;

public class Webcaching 
{
    int hitCount=0, missCount=0;
    int page;
    
    Queue<PageRequestEvent> pageRequestEventQueue;
    PageRequestEvent pageRequestEvent;
    Webcache webcache;
    CacheEntry e;
    
   public Webcaching(Queue<PageRequestEvent> pageRequestEventQueue)
   {
       this.pageRequestEventQueue=pageRequestEventQueue;
       this.pageRequestEvent=pageRequestEventQueue.remove();
       this.page=pageRequestEvent.page;
   }
   
   public void checkPage()
   {
       boolean value=webcache.checkPage(e);
       if(value)
       {
           hitCount++;           
       }
       else
       {
           missCount++;
       }
   }
   }