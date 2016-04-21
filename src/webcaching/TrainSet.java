
package webcaching;

import java.util.*;

public class TrainSet 
{
    LinkedList<LRUObject> list;
    Prediction prediction;
    int [] a;
    public TrainSet(LinkedList<LRUObject> list)
    {
        this.list=list;
        this.a=new int[100];        
    }
    
    public void costructTrainSet()
    {        
        int i=0;
        Iterator<LRUObject> itr=list.iterator();
        while(itr.hasNext()&&i<100)
        {
         a[i]=itr.next().getPage();
        }
        prediction=new Prediction(a);
    }
}
