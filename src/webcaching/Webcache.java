package webcaching;

import java.util.*;
import java.io.*;

public class Webcache 
{   
    int hitCount=0;
    
    private LinkedList<CacheEntry> list;
    private static Webcache instance=null;
    
    private Webcache()
    {
        this.list = new LinkedList<CacheEntry>()
    }
    public static Webcache getInstance()
    {
        if(instance==null)
        {
            instance = new Webcache(); 
        }
      return instance;
    }
    
    public void get(int pageId)
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
    public void put(CacheEntry e)
    {
        send the request to the server && meanwhile clear the cache entry-->delete();
        update cache and serve it to client;
            
    }
    public void delete(CacheEntry e)
    {
        based on cache algorithm like LRU delete entry in cache;
    }
}