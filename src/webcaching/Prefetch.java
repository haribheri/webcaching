
package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class Prefetch 
{
    Prediction predict;
    TrainSet trainset;
    LinkedList<LRUObject> list;
    Map<Integer,LRUObject> map;
    public Prefetch( LinkedList<LRUObject> list, Map<Integer,LRUObject> map)
    {
        this.list=list;
        this.map=map;
        if(list.size()==20)
        trainset=new TrainSet(list);
    }
    public void fetchAndStoreNextPage(int currentPage)
    {
        int nextPage;
        
        nextPage=predict.predict(currentPage);//predict class
        java.util.Date date= new java.util.Date();
        Timestamp time=new Timestamp(date.getTime());
        LRUObject o=new LRUObject(nextPage,time);
        list.add(o);
        map.put(o.pageId,o);
    }
}
