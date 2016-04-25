package webcaching;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
        
public class Client
{    
    public int numberOfPages, i;
    public int rangeOfpages;
    
    public Client()
    {
       
       String temp1,temp2; //dummy values to store string input from files
       try
       {
       FileReader file=new FileReader("G:/Java/Webcaching/src/input.txt");
       BufferedReader reader=new BufferedReader(file);
       for(int i=0;i<1;i++)
       reader.readLine(); //reads 2rd line
       temp1=reader.readLine();
       this.numberOfPages=Integer.parseInt(temp1);
       temp2=reader.readLine(); //reads 3rd line
       this.rangeOfpages=Integer.parseInt(temp2);     
       }catch(Exception e)
       {
           System.out.println(e);
           
       }
    }
    
   private int generatePage()
   {
       int page;
       Random rand=new Random();
       page=rand.nextInt(rangeOfpages);
       if(page==0)
           page+=1;
       return page;
    }
   
   public int sendPageRequest()
   {
       int page;
       page=generatePage();
       return page;    
   }
   public Timestamp timestampForCurrentPage()
   {
       Timestamp time=generateTimestamp();
       return time;
   }
   public Timestamp generateTimestamp()
   {
       java.util.Date date= new java.util.Date();
       Timestamp time=new Timestamp(date.getTime());
       return time;
   }
   
   public void receiveRequestedPage()
   {
       System.out.println("reccieved succesfully");       
   }
}
