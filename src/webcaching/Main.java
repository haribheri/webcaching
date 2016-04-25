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
    static int numberOfClients;   
    public Main()
    {
       this.pageRequestEventsQueue = new LinkedList<PageRequestEvent>(); 
       try
        {
        FileReader file=new FileReader("G:/Java/Webcaching/src/input.txt");
        BufferedReader reader=new BufferedReader(file);
        String temp=reader.readLine();
        this.numberOfClients=Integer.parseInt(temp);
        }catch(Exception e)
        {
            System.out.println(e);
        }
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
    
    public void caching()
    {
         webcaching=new Webcaching(this.pageRequestEventsQueue); 
    }
    
    @Override
    public void run()
    {
           client = new Client();           
           for(int i=0;i<client.numberOfPages;i++)
           {
            pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
            this.pageRequestEventsQueue.add(pageRequestEvent);   
            try
            {
             Thread.sleep(5000);
            }
             catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }           
    }
    private void initClient(String name)
    {
        this.setName("name");
        this.start();  
    }
    public static void main(String[] args)throws InterruptedException
    {
        
        Main main=new Main();
                
        main.initClient("Client-1");
       
        main.join(); //waits main thread until to complete child thread 
        main.caching();                    
    }
}