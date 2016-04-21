package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class LRUBasedWebcache {
    
    public LinkedList<LRUObject> list;
    public Map<Integer,LRUObject> map;
    Prefetch prefetch;
    
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        this.map=new HashMap<Integer,LRUObject>();
    }
   
    public boolean checkPage(int page,Timestamp time)
    {
        LRUObject o=new LRUObject(page,time);
        if(map.containsKey(o.pageId))
        {
            updateCache(o);
            return true;
        }
        else
        {
            put(o);
            return false;
        }
    }
            
    public void put(LRUObject o)
    {
        if(cacheSize()==100) // for prefetching
        {
            
        }
        if(isCacheAvilable())
        {
            list.add(o);
            map.put(o.pageId, o);
            updateCache(o);
        }
        
        else
        {
            deleteCacheEntry();
            list.add(o);
            map.put(o.pageId,o);
        }
        
    }
    private boolean isCacheAvilable()
    {
        if(list.size()==200)
            return false;
        else
            return true;
    }
    
    private void deleteCacheEntry()
    {
        list.removeLast();
        map.remove(list.getLast().pageId);
    }
    private void updateCache(LRUObject o)
    {
        list.addFirst(o);
    }
    private int cacheSize()
    {
        return list.size();
    }
}
