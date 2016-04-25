
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
    public Map<Integer,LRUObject> map;
    Prefetch prefetch;
    int cacheSize;    
    LRUWebCacheWithPrefetch()
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
        int predictionPage;
        LRUObject o=new LRUObject(page,time);
        
       if(list.size()>=(cacheSize/2))
        {
        prefetch=new Prefetch(list,map);
        
        predictionPage=prefetch.fetchAndStoreNextPage(page);//fetching the prediction page
        java.util.Date date= new java.util.Date();
        Timestamp timeForPredictionPage=new Timestamp(date.getTime());
        
        o=new LRUObject(predictionPage,timeForPredictionPage);
        put(o);
        }
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
    public void displayCache()
    {
        System.out.println("Elements present in LRU-with-PREF-CACHE are");
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
