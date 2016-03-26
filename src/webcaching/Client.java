package webcaching;

import java.util.*;
        
public class Client {
 
    
    public int numberOfPages, i;
    Queue pageRequestEvent;
    public Client(Queue pageRequestEvent)
    {
        this.pageRequestEvent=pageRequestEvent;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of pages");
        this.numberOfPages=sc.nextInt();
        
    }
    
   public int generatePage()
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
       pageRequestEvent.add(page);
       return page;
   }
   
   public void receiveRequestedPage()
   {
       
   }
}
