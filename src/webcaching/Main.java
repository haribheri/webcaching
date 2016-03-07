package webcaching;

import java.io.*;
import java.util.*;

public class Main{

    public Queue<PageRequestEvent> pageRequestEventsQueue;
    private Client client;  
    private Webcaching wcaching;
    public static void main(String[] args)
    {
        pageRequestEventsQueue = new Queue<PageRequestEvent>();
        //pageRequestEventsQueue.add(client.sendPageRequest());
	client = new Client(pageRequestEventsQueue);
        wcaching=new Webcaching(pageRequestEventsQueue.remove());
    }
}