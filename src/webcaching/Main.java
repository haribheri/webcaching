package webcaching;


import java.util.*;

public class Main{

    public Queue<PageRequestEvent> pageRequestEventsQueue;
    Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
   
    public Main()
    {
        pageRequestEventsQueue = new LinkedList<PageRequestEvent>();
        client = new Client(pageRequestEventsQueue);
        for(int i=0;i<client.numberOfPages;i++)
        {
        pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
        pageRequestEventsQueue.add(pageRequestEvent);
        
        }       
	webcaching=new Webcaching(pageRequestEventsQueue);
    
    }
    public static void main(String[] args)
    {
        Main main=new Main();
    }
}