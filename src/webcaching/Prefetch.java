
package webcaching;

import java.util.*;
import java.sql.Timestamp;

public class Prefetch 
{
    Prediction predict;
    TrainSet trainset;
   
    public Prefetch( LinkedList<LRUObject> list, Map<Integer,LRUObject> map, int currentPage)
    {
        int nextPage;
        trainset=new TrainSet(list);
        nextPage=predict.predict(currentPage);
        java.util.Date date= new java.util.Date();
        Timestamp time=new Timestamp(date.getTime());
        LRUObject o=new LRUObject(nextPage,time);
        list.add(o);
    }
}
