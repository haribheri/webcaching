package webcaching;

import java.util.*;

public class Webcache 
{   
    private LinkedList<CacheEntry> list;
    private static Webcache instance=null;
    CacheEntry e;
    /*private Webcache()
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
    }*/
    public Webcache()
    {
        this.list=new LinkedList<CacheEntry>();
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
    }
}