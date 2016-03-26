package webcaching;

import java.util.*;
import java.io.*;

public class Webcache 
{   
    private LinkedList<CacheEntry> list;
    private static Webcache instance=null;
    
    private Webcache()
    {
        this.list = new LinkedList<CacheEntry>();
    }
    public static Webcache getInstance()
    {
        if(instance==null)
        {
            instance = new Webcache(); 
        }
      return instance;
    }
    
    public void get(int pageId)
    {
                
    }
    public void put(CacheEntry e)
    {
            
    }
    public boolean checkPage(int pageId)
    {
        
    }
    public void delete(CacheEntry e)
    {
       
    }
}