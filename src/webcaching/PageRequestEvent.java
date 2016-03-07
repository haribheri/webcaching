package webcaching;

import java.io.*;
import java.util.*;

public class PageRequestEvent
{
    Client client;
    int page;
    public void PageRequestEvent()
    {
        this.page=client.sendPageRequest();
        //return page;
    }
    
}