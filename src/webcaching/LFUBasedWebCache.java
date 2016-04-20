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
    
    public boolean checkPage(int pageId, Timestamp time)
    {
        int flag=0;
        LFUObject o=new LFUObject(pageId,time) ;
        Iterator<LFUObject> itr=list.iterator();
        while(itr.hasNext())
        {
            if(o.pageId==itr.next().pageId)
            {
               itr.next().count++;
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            return true;
        }          
        else
        {
            put(o);
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
        
    private void deleteCacheEntry()
    {
       Collections.sort(list, new LFUComparator());
       list.removeLast();
    }
    private void updataCacheBasedOnLifeTime()
    {
        
    }
}