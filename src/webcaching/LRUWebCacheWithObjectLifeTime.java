package webcaching;

import java.sql.Timestamp;
import java.util.*;
import java.io.*;

public class LRUWebCacheWithObjectLifeTime 
{
    public LinkedList<LRUObject> list;
    public Map<Integer,LRUObject> map;
    int cacheSize;    
    LRUWebCacheWithObjectLifeTime()
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
        if(list.size()>=cacheSize/3)
            updataCacheBasedOnObjectTime();
        
        LRUObject o=new LRUObject(page,time);
        
        if(map.containsKey(o.pageId))
        {
            boolean value=list.remove(o);
            if(value)
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
            //list.add(o);
            map.put(o.pageId, o);
            updateCache(o);
            
        }
        else
        {
            deleteCacheEntry();
           // list.add(o);
            updateCache(o);
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
    private void updataCacheBasedOnObjectTime()
    {
        java.util.Date date= new java.util.Date();
        Timestamp currentTime=new Timestamp(date.getTime());
        
        long currenttime=currentTime.getTime(); //change current time in to long
        
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
        { 
            long pageTime=itr.next().time.getTime(); //change page time into long
            pageTime+=30000;         //30 sec
            if(currenttime>=pageTime) //pagetime > 2min delete it
            {
                list.remove(itr.next());
            }
        }
    }
    
    public void displayCache()
    {
        System.out.println("Elements present in LRU-with-TIME-CACHE are");
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next().pageId+"\t");
        System.out.println();
    }    
}
