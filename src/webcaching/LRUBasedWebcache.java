
package webcaching;

import java.util.*;

public class LRUBasedWebcache {
    private LinkedList<LRUObject> list;
    private Map<Integer,LRUObject> map;
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        map=new HashMap<Integer,LRUObject>();
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
            
    private void put(LRUObject o)
    {
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
    private boolean isCacheAvilable()
    {
        if(list.size()==100)
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
