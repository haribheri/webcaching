
package webcaching;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.sql.Timestamp;


public class LRUWebCacheWithPrefetch 
{       
    public LinkedList<LRUObject> list;
    public LinkedList<LRUObject> preflist;
    public Map<Integer,LRUObject> map;
    public Map<Integer,LRUObject> prefmap;
    Prefetch prefetch;
    int cacheSize;    
    int prefCacheSize;
    LRUWebCacheWithPrefetch()
    {
        this.list=new LinkedList<LRUObject>();
        this.map=new HashMap<Integer,LRUObject>();
        this.preflist=new LinkedList<LRUObject>();
        this.prefmap=new HashMap<Integer,LRUObject>();
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
        try
        {
        FileReader file=new FileReader("G:/Java/Webcaching/src/input.txt");
        BufferedReader reader=new BufferedReader(file);
        for(int i=0;i<5;i++)
        reader.readLine(); //reads 4th line
        String temp=reader.readLine();
        this.prefCacheSize=Integer.parseInt(temp);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
   
    public boolean checkPage(int page,Timestamp time)
    {
        LRUObject o=new LRUObject(page,time);
        
        prefetchPage(page); //prefetching
        
        if(map.containsKey(o.pageId))
        {
            this.updataCache(o);            
            return true;
        }
        else if(chackPageInPrefetchCache(o))
        {
            this.updatePrefCache(o);
            return true;
        }
        else
        {
            put(o);
            return false;
        }
    }
    public boolean chackPageInPrefetchCache(LRUObject o)
    {
        if(prefmap.containsKey(o.pageId))
        {
            updatePrefCache(o);
            return true;
        }
        else
            return false;
    }
    public void updataCache(LRUObject o)
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
    }
    public void updatePrefCache(LRUObject o)
    {
        Iterator<LRUObject> itr=preflist.iterator();
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
            preflist.addFirst(o);
    }
    public void prefetchPage(int page)
    {
        int predictionPage;
        LRUObject o;
        if(list.size()>=(cacheSize/2))
        {
        prefetch=new Prefetch(list,map);
        
        predictionPage=prefetch.fetchAndStoreNextPage(page);//fetching the prediction page
        
        java.util.Date date= new java.util.Date();
        Timestamp timeForPredictionPage=new Timestamp(date.getTime());
        
        o=new LRUObject(predictionPage,timeForPredictionPage);
        
        if((!prefmap.containsKey(o.pageId))&&(!map.containsKey(o.pageId)))
        {
        prefPut(o);
        }
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
    public void prefPut(LRUObject o)
    {
        if(isPrefCacheAvilable())
        {
            preflist.addFirst(o);
            prefmap.put(o.pageId, o);
        }
        
        else
        {
            prefDeleteCacheEntry();
            preflist.addFirst(o);
            prefmap.put(o.pageId,o);
        }
        
    }
    private boolean isCacheAvilable()
    {
        if(list.size()>=this.cacheSize)
            return false;
        else
            return true;
    }
    private boolean isPrefCacheAvilable()
    {
        if(preflist.size()>=this.prefCacheSize)
            return false;
        else
            return true;
    }
    private void prefDeleteCacheEntry()
    {
        prefmap.remove(preflist.getLast().pageId);
        preflist.removeLast();  
    }
    private void deleteCacheEntry()
    {
        map.remove(list.getLast().pageId);
        list.removeLast();
    }
    
    public void displayCache()
    {
        System.out.println("Size of Cache is: \t"+cacheSize());
        System.out.println("Elements present in LRU-with-PREF-CACHE are");
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next().pageId+"\t");
        System.out.println();
    }
    public void displayPrefCache()
    {
        System.out.println("Size of Cache is: \t"+prefCacheSize());
        System.out.println("Elements present in PREFETCHING-CACHE are");
        Iterator<LRUObject> itr=preflist.iterator();
        while(itr.hasNext())
            System.out.print(itr.next().pageId+"\t");
        System.out.println();
    }
    private int cacheSize()
    {
        return list.size();
    }
    private int prefCacheSize()
    {
        return list.size();
    }
}
