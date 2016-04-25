
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
        trainset=new TrainSet(list);
    }
    public int fetchAndStoreNextPage(int currentPage)
    {
        int nextPage;
        
        nextPage=trainset.prediction.predict(currentPage); //predict class from trainset class
       
        return nextPage;
    }
}
