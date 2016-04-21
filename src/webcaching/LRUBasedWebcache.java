package webcaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.sql.Timestamp;

public class LRUBasedWebcache {
    
    public LinkedList<LRUObject> list;
    public Map<Integer,LRUObject> map;
    Prefetch prefetch;
    int size;    
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        this.map=new HashMap<Integer,LRUObject>();
        if(list.size()>=(size/2))
        prefetch=new Prefetch(list,map);
    }
   
    public boolean checkPage(int page,Timestamp time)
    {
        LRUObject o=new LRUObject(page,time);
        
        if(list.size()>=(size/2))
        prefetch.fetchAndStoreNextPage(page);
        
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
        Scanner file=null;
       try
       {
           file=new Scanner(new FileInputStream("G:\\Java\\Webcaching\\src\\input.txt"));           
       }
       catch(FileNotFoundException e)
       {
           System.out.println("unable to locate file");
           System.exit(0);      
       }
       size=file.nextInt();
        if(list.size()==size)
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
