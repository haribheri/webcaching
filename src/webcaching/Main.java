package webcaching;
import java.sql.Timestamp;
import java.util.Date;

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
        pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.generateTimestamp());
        pageRequestEventsQueue.add(pageRequestEvent);
        }       
	//client = new Client(pageRequestEventsQueue);
        webcaching=new Webcaching(pageRequestEventsQueue);
    
    }
    public static void main(String[] args)
    {
        Main main=new Main();
    }
}