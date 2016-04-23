package webcaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.sql.Timestamp;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    int cacheSize;
    LFUBasedWebCache()
    {
       this.list=new LinkedList<LFUObject>();
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
       this.cacheSize=file.nextInt();
    }
    
    public boolean checkPage(int pageId, Timestamp time)
    {
        updataCacheBasedOnObjectTime();
        int flag=0;                     //to check page is in cache
        LFUObject o=new LFUObject(pageId,time) ;
        Iterator<LFUObject> itr=list.iterator();
        while(itr.hasNext())
        {
            if(o.pageId==itr.next().pageId)
            {
               itr.next().count++;
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            return true;
        }          
        else
        {
            put(o);
            return false;
        }        
    }
    private void put(LFUObject o)
    {
        if(isCacheAvilable())
        {
            java.util.Date date= new java.util.Date();
            Timestamp t=new Timestamp(date.getTime());
            o.time=t;
            list.add(o);
            o.updateCount();
        }
        else
        {
            deleteCacheEntry();
            java.util.Date date= new java.util.Date();
            Timestamp t=new Timestamp(date.getTime());
            o.time=t;
            list.add(o);
            o.updateCount();
         }
            
    }
    private boolean isCacheAvilable()
    {
        if(list.size()>=cacheSize)
            return false;
        else
            return true;
    }
        
    private void deleteCacheEntry()
    {
       Collections.sort(list, new LFUComparator());
       list.removeLast();
    }
    private void updataCacheBasedOnObjectTime()
    {
        java.util.Date date= new java.util.Date();
        Timestamp currentTime=new Timestamp(date.getTime());
        
        long currenttime=currentTime.getTime(); //change current time in to long
        
        Iterator<LFUObject> itr=list.iterator();
        while(itr.hasNext())
        { 
            long pageTime=itr.next().time.getTime(); //change page time into long
            pageTime+=120000;         //2 min
            if(currenttime>=pageTime) //pagetime > 2min delete it
            {
                list.remove(itr.next());
            }
        }
    }
}