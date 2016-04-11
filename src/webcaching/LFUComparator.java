package webcaching;

import java.util.*;
public class LFUComparator implements Comparator<LFUObject> 
{
    public int comparator(LFUObject o1, LFUObject o2)
    {
        if(o1.getPage()<o2.getPage())
        {
            return 1;
         }
        else
            return -1;
    }
}
