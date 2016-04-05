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
    public boolean checkPage(CacheEntry e)
    {
        if(list.contains(e))
        {
            return true;
        }
        else
        {
            put(e);
            return false;
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
       char ch=2;
       System.out.println("enter ch value");
       switch(ch)
       {
           case 1: lru(e);
               break;
           case 2: extendedSegmentedLru(e);
               break;
           case 3: lfu(e);
               break;       
       }
    }
    public void lru(CacheEntry e)
    {
        
    }
    public void extendedSegmentedLru(CacheEntry e)//my approach for caching
    {
                
    }
    public void lfu(CacheEntry e)
    {
        
    }
}