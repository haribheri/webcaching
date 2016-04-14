
package webcaching;

import java.util.*;

public class LRUBasedWebcache {
    private LinkedList<LRUObject> list;
    private Map<Integer,LRUObject> map;
    LRUBasedWebcache()
    {
        this.list=new LinkedList<LRUObject>();
        map=new HashMap<Integer,LRUObject>();
    }
    public void put()
    {
        
    }
    
}
