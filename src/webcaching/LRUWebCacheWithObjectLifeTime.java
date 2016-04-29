package webcaching;

import java.sql.Timestamp;
import java.util.*;
import java.io.*;

public class LRUWebCacheWithObjectLifeTime 
{
    public LinkedList<LRUObject> list;
    public Map<Integer,LRUObject> map;
    int cacheSize;    
    LRUWebCacheWithObjectLifeTime()
    {
        this.list=new LinkedList<LRUObject>();
        this.map=new HashMap<Integer,LRUObject>();
        try
        {
        FileReader file=new FileReader("G:/Java/Webcaching/src/input.txt");
        BufferedReader reader=new BufferedReader(file);
        for(int i=0;i<3;i++)
        reader.readLine(); //reads 4th line
        String temp=reader.readLine();
        this.cacheSize=Integer.parseInt(temp);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
   
    public boolean checkPage(int page,Timestamp time)
    {
                 
         LRUObject o=new LRUObject(page,time);
        
        if((map.containsKey(o.pageId))&&isValid(o))
        {  
            Iterator<LRUObject> itr=list.iterator();
            try
            {
            while(itr.hasNext())
            {
                if(itr.next().pageId==o.pageId)
                    itr.remove();
            }
            }catch(Exception e)
                {
                    System.out.println(e);
                }
            
            list.addFirst(o);
            return true;
            
        }
        else
        {
            put(o);
            return false;
        }
    }
    
    private void put(LRUObject o)
    {
        if(isCacheAvilable())
        {
            list.addFirst(o);
            map.put(o.pageId, o);
        }
        else
        {
            deleteCacheEntry();
            list.addFirst(o);
            map.put(o.pageId,o);
        }
        
    }
    private boolean isValid(LRUObject o)
    {
        java.util.Date date= new java.util.Date();
        Timestamp currentTime=new Timestamp(date.getTime());
        
        long currenttime=currentTime.getTime(); //change current time in to long
        
        long pageTime=o.time.getTime();
        pageTime+=120000;                  //20 sec->lifetime
        if(pageTime>=currenttime)
        {
            return true;            
        }
        else
        {
            Iterator<LRUObject> itr=list.iterator();
            try
            {
            while(itr.hasNext())
            {
                if(itr.next().pageId==o.pageId)
                    itr.remove();
            }
            }catch(Exception e)
                {
                    System.out.println(e);
                }
            return false;
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
        map.remove(list.getLast().pageId);
        list.removeLast();
        
    }
    
    private void updataCacheBasedOnObjectTime()
    {
        java.util.Date date= new java.util.Date();
        Timestamp currentTime=new Timestamp(date.getTime());
        
        long currenttime=currentTime.getTime(); //change current time in to long
        
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
        { 
            long pageTime=itr.next().time.getTime(); //change page time into long
            pageTime+=20000;         //60 sec
            if(currenttime>=pageTime) //pagetime > 2min from the creation, delete it
            {
                list.remove(itr.next());
            }
        }
    }
    
    public void displayCache()
    {
        System.out.println("Size of Cache is: \t"+cacheSize());
        System.out.println("Elements present in LRU-with-TIME-CACHE are");
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next().pageId+"\t");
        System.out.println();
    }
    
    private int cacheSize()
    {
        return list.size();
    }
}
