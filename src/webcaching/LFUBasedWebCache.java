package webcaching;

import java.util.Collections;
import java.util.LinkedList;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
        
    }
    private boolean checkPage(LFUObject o)
    {
        if(list.contains(o))
        {
           o.updateCount();
           return true;
        }
        else
        {
            put(o);
            o.updateCount();
            return false;
        }
    }
    private void put(LFUObject o)
    {
        if(isCacheAvilable())
        {
            list.add(o);
        }
        else
        {
            deleteCacheEntry();
            list.add(o);
         }
            
    }
    private boolean isCacheAvilable()
    {
        if(list.size()==100)
            return false;
        else
            return true;
    }
    public void get(int pageId)
    {
        LFUObject o=new LFUObject(pageId);
        
           boolean value=checkPage(o);     
    }    
    private void deleteCacheEntry()
    {
       Collections.sort(list, new LFUComparator());
       list.removeLast();
    }
            
}
