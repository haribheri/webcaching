package webcaching;

import java.util.*;

public class Main{

    public Queue<PageRequestEvent> pageRequestEventsQueue;
    Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
   
    public Main()
    {
        int i;
        pageRequestEventsQueue = new LinkedList<PageRequestEvent>();
                
        for(i=0;i<client.numberOfPages;i++)
        {
        pageRequestEvent=new PageRequestEvent(client.sendPageRequest());
        pageRequestEventsQueue.add(pageRequestEvent);
        }       
	client = new Client(pageRequestEventsQueue);
        webcaching=new Webcaching(pageRequestEventsQueue);
    
    }
    public static void main(String[] args)
    {
        Main main=new Main();
    }
}