package webcaching;

import java.io.*;
import java.util.*;

public class Main extends Thread
{
    public Queue<PageRequestEvent> pageRequestEventsQueue;
    Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
       
    public Main()
    {
       pageRequestEventsQueue = new LinkedList<PageRequestEvent>();  
          
    }
    @Override
    public void run()
    {
           client = new Client(pageRequestEventsQueue);           
           for(int i=0;i<client.numberOfPages;i++)
           {
            pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
            pageRequestEventsQueue.add(pageRequestEvent);   
            try
            {
            Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        
    }
    public void caching()
    {
        if(!pageRequestEventsQueue.isEmpty())
       webcaching=new Webcaching(pageRequestEventsQueue); 
    }
   /* public void result()
    {
        int hitCountOfLRU=webcaching.checkPageInLRUCache();
        int hitCountOfLFU=webcaching.checkPageInLFUCache();
        System.out.println("hit ratio through LRU is : "+hitCountOfLRU);
        System.out.println("hit ratio through LFU is : "+hitCountOfLFU);
    }*/
    private void initClient()
    {
        Main client1=new Main();
        client1.setName("client-1");
        client1.start();
        
    }
    
    public static void main(String[] args)
    {
        Main main=new Main();
        try{
            main.initClient();
                        
           }catch(NullPointerException e)
            {
            System.out.println(e);
        }
        main.caching();
    }
}