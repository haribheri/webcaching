
package webcaching;
import java.util.*;
import java.sql.Timestamp;

public class LFUObject {
    int pageId;
    int count;
    Timestamp time;
    LFUObject(int pageId,Timestamp time)
    {
        this.pageId=pageId;
        this.count=0;
        this.time=time;
    }
    void updateCount()
    {
        count++;
    }
    public int getPage()
    {
        return pageId;
    }
    public int getCount()
    {
        return count;
    }
}
