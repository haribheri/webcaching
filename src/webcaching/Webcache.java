package webcaching;

import java.util.*;
import java.io.*;

public class Webcache 
{   
    int hitCount=0;
    
    LinkedList<CacheEntry> list=new LinkedList<CacheEntry>();
    private static Webcache instance=null;
    
    private Webcache()
    {
        CacheEntry c1=new CacheEntry(1,true);
        CacheEntry c2=new CacheEntry(2,true);
        CacheEntry c3=new CacheEntry(3,true);
        CacheEntry c4=new CacheEntry(4,false);
        CacheEntry c5=new CacheEntry(5,true);
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
    }
    public static Webcache getInstance()
    {
        if(instance==null)
        {
            instance = new Webcache(); 
        }
      return instance;
    }
    
    public void get()
    {
        if(cache!=full&&page=!found)
            send the requested page to server and update the cache while receiving it from cache ;
            
        if(page==found)
        {
            hitCount++;
            serve the page to client;
        }
        else
            put();
    }
    public void put()
    {
        send the request to the server && meanwhile clear the cache entry-->delete();
        update cache and serve it to client;
            
    }
    public void delete()
    {
        based on cache algorithm like LRU delete entry in cache;
    }
}