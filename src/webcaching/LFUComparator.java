package webcaching;

import java.util.Comparator;

class LFUComparator implements Comparator<LFUObject> 
{
    public int compare(LFUObject o1, LFUObject o2)
    {
        if(o1.getPage()<o2.getPage())
        {
            return 1;
         }
        else
            return -1;
    }
}
