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
            Iterator<LRUObject> itr=list.iterator();
            try
            {
            while(itr.hasNext())
            {
                if(itr.next().pageId==o.pageId)
                    itr.remove();
            }
            }catch(Exception e)
                {
                    System.out.println(e);
                }
            list.addFirst(o);
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
            list.addFirst(o);
            map.put(o.pageId, o);           
        }
        else
        {
            deleteCacheEntry();
            list.addFirst(o);
            map.put(o.pageId,o);
        }
        
    }
    private boolean isCacheAvilable()
    {
        if(list.size()>=this.cacheSize)
            return false;
        else
            return true;
    }
    
    private void deleteCacheEntry()
    {
        map.remove(list.getLast().pageId);
        list.removeLast();
        
    }
        
    public void displayCache()
    {
        System.out.println("Size of Cache is: \t"+cacheSize());
        System.out.println("Elements present in LRU-CACHE are");
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next().pageId+"\t");
        System.out.println();
    }
    private int cacheSize()
    {
        return list.size();
    }
}
