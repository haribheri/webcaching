package webcaching;

import java.io.*;
import java.util.*;

public class Main{

    private Queue<PageRequestEvent> pageRequestEventsQueue;
    private Client client;  
    private Webcache wcache;
    public static void main(String[] args)
    {
        pageRequestEventsQueue = new Queue<PageRequestEvent>();
	client = new Client(pageRequestEventsQueue);
    }
}