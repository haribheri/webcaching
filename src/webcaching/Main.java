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
       Scanner file=null;
       try
       {
           file=new Scanner(new FileInputStream("G:\\Java\\Webcaching\\src\\input.txt"));           
       }
       catch(FileNotFoundException e)
       {
           System.out.println("unable to locate file");
           System.exit(0);      
       }
       this.numberOfClients=file.nextInt();
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
    private void initClient(String name)
    {
        this.setName("name");
        this.start();  
    }
    public static void main(String[] args)throws InterruptedException
    {
        int i;
        for(i=1;i<=5;i++)
        {
            Main main=new Main();
            main.initClient("Client -i");
        }
        Thread mt=Thread.currentThread();
        
        Main obj=new Main();
        
        obj.join(); //waits main thread until to complete child thread 
        obj.caching();            
        
        
        
    }
}