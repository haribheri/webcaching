
package webcaching;

import java.io.*;
import java.util.*;

public class TrainSet 
{
    LinkedList<LRUObject> list;
    Prediction prediction;
    int trainsetPages;
    int [] a;
    public TrainSet(LinkedList<LRUObject> list)
    {
        Scanner file=null;
        try
        {
            file=new Scanner(new FileInputStream("G:\\Java\\Webcaching\\src\\input.txt"));
        }catch(Exception e)
        {
            System.out.println(e);
        }
        for(int i=0;i<4;i++)
            file.nextLine();
        this.trainsetPages=file.nextInt();
        
        this.list=list;
        this.a=new int[this.trainsetPages];        
        constructTrainSet();
    }
    
    public final void constructTrainSet()
    {        
        int i=0;
        LinkedList<LRUObject> newlist=(LinkedList<LRUObject>)list.clone();
        Collections.reverse(newlist);
        Iterator<LRUObject> itr=newlist.iterator();
        while(itr.hasNext()&&i<this.trainsetPages)
        {
         a[i]=itr.next().getPage();
         i++;
        }
        prediction=new Prediction(a);
               
    }
}
