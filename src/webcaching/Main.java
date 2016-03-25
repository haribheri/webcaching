package webcaching;

import java.io.*;
import java.util.*;

public class Main{

    public Queue<PageRequestEvent> pageRequestEventsQueue;
    private Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
    public Main()
    {
        pageRequestEventsQueue = new LinkedList<PageRequestEvent>();
        pageRequestEvent
        pageRequestEventsQueue.add(pageRequestEvent);
        
	client = new Client(pageRequestEventsQueue);
        webcaching=new Webcaching(pageRequestEventsQueue);
    
    }
    public static void main(String[] args)
    {
        Main main=new Main();
    }
}