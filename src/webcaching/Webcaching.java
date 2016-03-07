
package webcaching;
import java.io.*;
import java.util.*;

public class Webcaching {
    int hitCount=0, missCount=0,page;
    PageRequestEvent pageRequestEvent;
    Webcache webcache;
   public Webcaching(PageRequestEvent pageRequestEvent)
   {
       this.page=pageRequestEvent.PageRequestEvent();
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
    
