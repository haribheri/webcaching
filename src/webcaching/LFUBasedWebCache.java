package webcaching;

import java.util.*;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    LFUObject lfuobjecct;
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
    }
    private boolean checkPage(int page)
    {
        if(list.contains(lfuobjecct.pageId))
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
    public void get(int pageId)
    {
        LFUObject o=new LFUObject(pageId);
        
           //boolean value=checkPage(o);     
    }    
    private void deleteCacheEntry()
    {
       Collections.sort(list, new LFUComparator());
       list.removeLast();
    }            
}