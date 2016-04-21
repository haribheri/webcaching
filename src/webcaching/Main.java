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
        webcaching=new Webcaching(pageRequestEventsQueue);
    }
    public void result()
    {
        int hitCountOfLRU=webcaching.checkPageInLRUCache();
        int hitCountOfLFU=webcaching.checkPageInLFUCache();
        System.out.println("hit ratio through LRU is : "+hitCountOfLRU);
        System.out.println("hit ratio through LFU is : "+hitCountOfLFU);
    }
    private void initClient()
    {
        Main client1=new Main();
        /*Main client2=new Main();
        Main client3=new Main();
        Main client4=new Main();
        Main client5=new Main();
        Main client6=new Main();
        Main client7=new Main();
        Main client8=new Main();
        Main client9=new Main();
        Main client10=new Main();
        */client1.setName("client-1");
        client1.start();
        /*client2.setName("client-2");
        client2.start();
        client3.setName("client-3");
        client3.start();
        client4.setName("client-1");
        client4.start();
        client5.setName("client-5");
        client5.start();
        client6.setName("client-6");
        client6.start();
        client7.setName("client-7");
        client7.start();
        client8.setName("client-8");
        client8.start();
        client9.setName("client-9");
        client9.start();
        client10.setName("client-10");
        client10.start();
        */
    }
    
    public static void main(String[] args)
    {
        Main main=new Main();
        try{
            main.initClient();
            main.result();            
           }catch(NullPointerException e)
            {
            System.out.println(e);
        }
        
    }
}