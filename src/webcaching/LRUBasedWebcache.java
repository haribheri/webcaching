package webcaching;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class LRUBasedWebcache {
    
    public LinkedList<LRUObject> list;
    public Map<Integer,LRUObject> map;
    int cacheSize;    
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        this.map=new HashMap<Integer,LRUObject>();
        try
        {
        FileReader file=new FileReader("G:/Java/Webcaching/src/input.txt");
        BufferedReader reader=new BufferedReader(file);
        for(int i=0;i<3;i++)
        reader.readLine(); //reads 4th line
        String temp=reader.readLine();
        this.cacheSize=Integer.parseInt(temp);
        }catch(Exception e)
        {
            System.out.println(e);
        }
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
        if(list.size()>=cacheSize)
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
