
package webcaching;

public class LRUObject {
    int pageId;
    int time;
    LRUObject(int pageId)
    {
        this.pageId=pageId;
    }
    public int getPage()
    {
        return pageId;
    }
    public int getTime()
    {
        return time;
    }
}
