package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
    }
    private boolean checkPage(LFUObject o)
    {
        if(list.contains(o.pageId))
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
            java.util.Date date= new java.util.Date();
            Timestamp t=new Timestamp(date.getTime());
            o.time=t;
            list.add(o);
            o.updateCount();
        }
        else
        {
            deleteCacheEntry();
            java.util.Date date= new java.util.Date();
            Timestamp t=new Timestamp(date.getTime());
            o.time=t;
            list.add(o);
            o.updateCount();
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
    private void updataCacheBasedOnLifeTime()
    {
        
    }
}