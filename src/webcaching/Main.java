package webcaching;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class Main extends Thread
{
    public Queue<PageRequestEvent> pageRequestEventsQueue;
    Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
       
    public Main()
    {
       this.pageRequestEventsQueue = new LinkedList<PageRequestEvent>();  
    }
    @Override
    public void run()
    {
           client = new Client(this.pageRequestEventsQueue);           
           for(int i=0;i<client.numberOfPages;i++)
           {
            pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
            this.pageRequestEventsQueue.add(pageRequestEvent);   
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
         webcaching=new Webcaching(this.pageRequestEventsQueue); 
    }
    
    private void initClient()
    {
        this.setName("client-1");
        this.start();
        
    }
    public void display()
    {
        for(PageRequestEvent pre : pageRequestEventsQueue)
        {
            System.out.println(pre.page);
        }
    }
    
    @Override
    public String toString()
    {
     return "page "+ this.pageRequestEvent.page ;   
    }
    public static void main(String[] args)
    {
        Main main=new Main();
        main.initClient();
        main.caching();
     
    }
}