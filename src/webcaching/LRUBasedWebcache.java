
package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class LRUBasedWebcache {
    TrainSet trainset;
    private LinkedList<LRUObject> list;
    private Map<Integer,LRUObject> map;
    
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        map=new HashMap<Integer,LRUObject>();
    }
    public boolean get(int page,Timestamp time)
    {
        LRUObject o=new LRUObject(page,time);
        boolean value=checkPage(o);
        return value;
    }
    public boolean checkPage(LRUObject o)
    {
        if(map.containsKey(o))
        {
            updateCache();
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
        if(cacheSize()==100)
        {
            trainset=new TrainSet(list);
        }
        if(isCacheAvilable())
        {
            list.add(o);
            map.put(Integer.SIZE, o);
            updateCache();
        }
        
        else
        {
            deleteCacheEntry();
            list.add(o);
            map.put(Integer.SIZE, o);
            
        }
        
    }
    private int cacheSize()
    {
        return list.size();
    }
    private boolean isCacheAvilable()
    {
        if(list.size()==200)
            return false;
        else
            return true;
    }
    private void updateCache()
    {
        
    }
    private void deleteCacheEntry()
    {
        
    }
}
