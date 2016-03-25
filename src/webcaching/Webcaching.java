
package webcaching;
import java.io.*;
import java.util.*;

public class Webcaching {
    int hitCount=0, missCount=0,page;
    Webcache webcache;
    Queue pageRequestEventQueue;
    PageRequestEvent pageRequestEvent;
   public Webcaching(Queue pageRequestEventQueue)
   {
       this.pageRequestEventQueue=pageRequestEventQueue;
       this.pageRequestEvent=pageRequestEventQueue.remove();
       
   }
   public void checkPage()
   {
       boolean value=webcache.checkPage(page);
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