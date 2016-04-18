package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    LFUObject lfuobjecct;
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
    }
    private boolean checkPage(LFUObject o)
    {
        if(list.contains(o.pageId))
        {
           lfuobjecct.updateCount();
           return true;
        }
        else
        {
            put(lfuobjecct);
            lfuobjecct.updateCount();
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
    public boolean get(int pageId,Timestamp time)
    {
        LFUObject o=new LFUObject(pageId,time);
        
        boolean value=checkPage(o);
        return value;
    }    
    private void deleteCacheEntry()
    {
       Collections.sort(list, new LFUComparator());
       list.removeLast();
    }            
}