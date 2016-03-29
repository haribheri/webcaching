package webcaching;

import java.util.*;

public class Webcache 
{   
    private LinkedList<CacheEntry> list;
    private static Webcache instance=null;
    CacheEntry e;
    private Webcache()
    {
        this.list = new LinkedList<CacheEntry>();
    }
    public static Webcache getInstance()
    {
        if(instance==null)
        {
            instance = new Webcache(); 
        }
      return instance;
    }
    public void checkPage(CacheEntry e)
    {
        if(list.contains(e))
        {
        }
        else
        {
            put(e);
        }
        
    }
    public void put(CacheEntry e)
    {
        if(isCacheAvilable())
        {
            list.add(e);
        }
        else
        {
            deleteCacheEntry(e);
        }
            
    }
    public boolean isCacheAvilable()
    {
        if(list.size()==100)
            return false;
        else
            return true;
    }
    public void get(int pageId)
    {
                
    }    
    public void deleteCacheEntry(CacheEntry e)
    {
       char ch;
       System.out.println("enter ch value");
       switch(ch)
       {
           case 1: lru(e);
               break;
           case 2: segmentedLru(e);
               break;
           case 3: lfu(e);
               break;
               
           
       }
    }
    public void lru(CacheEntry e)
    {
        
    }
    public void segmentedLru(CacheEntry e)
    {
        
    }
    public void lfu(CacheEntry e)
    {
        
    }
}
