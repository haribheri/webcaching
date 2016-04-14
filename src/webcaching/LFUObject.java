
package webcaching;

public class LFUObject {
    int pageId;
    int count;
    int time;
    LFUObject(int pageId)
    {
        this.pageId=pageId;
        this.count=0;
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
