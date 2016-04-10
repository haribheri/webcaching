
package webcaching;

public class LFUObject {
    int pageId;
    int count;
    int time;
    LFUObject(int pageId)
    {
        this.pageId=pageId;
    }
    void updateCount()
    {
        count++;
    }
}
