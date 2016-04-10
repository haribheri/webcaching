package webcaching;

import java.util.LinkedList;

public class LFUBasedWebCache 
{
    LinkedList<LFUObject> list;
    LFUBasedWebCache()
    {
        this.list=new LinkedList<LFUObject>();
        
    }
            
}
