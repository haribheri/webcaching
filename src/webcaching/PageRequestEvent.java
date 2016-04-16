package webcaching;
import java.sql.Timestamp;
import java.util.Date;

public class PageRequestEvent
{
    int page;
    Timestamp time;
    public PageRequestEvent(int page,Timestamp time)
    {
        this.page=page;
        this.time=time;
    }
    
}