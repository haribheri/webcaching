package webcaching;

import java.util.LinkedList;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
        
    }
    public boolean checkPage(LFUObject o)
    {
        if(list.contains(o))
        {
           o.updateCount();
           return true;
        }
        else
        {
            put(o);
            return false;
        }
        
    }
    public void put(LFUObject o)
    {
        if(isCacheAvilable())
        {
            list.add(o);
        }
        else
        {
            deleteCacheEntry(o);
        }
            
    }
    public boolean isCacheAvilable()
    {
        if(list.size()==100)
            return false;
        else
            return true;
    }
    public void get(int pageId)
    {
                
    }    
    public void deleteCacheEntry(LFUObject o)
    {
       if(o.count==1)
       {
           
       }
    }
            
}
