
package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class LRUObject {
    int pageId;
    Timestamp time;
    LRUObject(int pageId,Timestamp time)
    {
        this.pageId=pageId;
        this.time=time;
    }
    public int getPage()
    {
        return pageId;
    }
    public Timestamp getTime()
    {
        return time;
    }
}
