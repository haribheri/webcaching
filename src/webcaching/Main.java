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
            Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                
            }
        }
        webcaching=new Webcaching(pageRequestEventsQueue);
       
    }
    
    public static void main(String[] args)
    {
        Main client1=new Main();
        Main client2=new Main();
        Main client3=new Main();
        Main client4=new Main();
        Main client5=new Main();
        Main client6=new Main();
        Main client7=new Main();
        Main client8=new Main();
        Main client9=new Main();
        Main client10=new Main();
        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();
        client6.start();
        client7.start();
        client8.start();
        client9.start();
        client10.start();
    }
}