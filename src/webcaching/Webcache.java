
package webcaching;
import java.util.*;
import java.io.*;

public class Webcache {
    
    private static Webcache instance=null;
    private Webcache()
    {
        
    }
    public static Webcache getInstance()
    {
        if(instance==null)
        {
            instance = new Webcache(); 
        }
    }
    
    public static void main(String arr[] )
    {
        CacheEntry c1=new CacheEntry(1,true);
        CacheEntry c2=new CacheEntry(2,true);
        CacheEntry c3=new CacheEntry(3,true);
        CacheEntry c4=new CacheEntry(4,false);
        CacheEntry c5=new CacheEntry(5,true);
        
        LinkedList<CacheEntry> list=new LinkedList<CacheEntry>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
       
    }
    
}
