package webcaching;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main extends Thread
{
    public Queue<PageRequestEvent> pageRequestEventsQueue;
    Webcaching webcaching;
    PageRequestEvent pageRequestEvent;
    Client client;
    int numberOfClients;
   
    public Main()
    {
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
       pageRequestEventsQueue = new LinkedList<PageRequestEvent>();
       
      
           client = new Client(pageRequestEventsQueue);           
           for(int j=0;j<client.numberOfPages;j++)
           {
            pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
            pageRequestEventsQueue.add(pageRequestEvent);            
        }  
        webcaching=new Webcaching(pageRequestEventsQueue);
    }
    @Override
    public void run()
    {
           client = new Client(pageRequestEventsQueue);           
           for(int j=0;j<client.numberOfPages;j++)
           {
            pageRequestEvent=new PageRequestEvent(client.sendPageRequest(),client.timestampForCurrentPage());
            pageRequestEventsQueue.add(pageRequestEvent);   
            try
            {
            Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                
            }
        }  
       
    }
    
    public static void main(String[] args)
    {
        Main main=new Main();
        main.start();
    }
}