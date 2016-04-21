
package webcaching;

import java.util.*;

public class Prediction 
{
    int numberOfPages;
    int [] trainset;
    int [][] arr;
    public Prediction(int pages)
    {
        int i;
        this.numberOfPages=pages;
        this.arr=new int[numberOfPages][];
        for(i=0;i<this.numberOfPages;i++)
            arr[i]=new int[numberOfPages];
        
    }
    public Prediction(int a[])
    {
        this.trainset=new int [100];
        int i;
        for(i=0;i<trainset.length;i++)
            trainset[i]=a[i];
    }
    public int predict(int page)
    {
        int i,max_prob_page;
        max_prob_page=findMax(arr[page]);
        return max_prob_page;
    }
    private int findMax(int aux[])
    {
        int i,max=aux[0];
        for(i=1;i<aux.length;i++)
        {
            if(aux[i]>=max)
                max=aux[i];
        }
        return max;
     }
    private void costructPredictionTable(int numberOfpages)
    {
        int i,j,k;
        for(i=0;i<numberOfpages;i++)
        {
            for(j=0;j<numberOfpages;j++)
            {
                arr[i][j]=0;
            }
        }
        for(i=0;i<numberOfpages;i++)
        {
            for(j=0;j<numberOfpages;j++)
            {
                if(i!=j)
                {
                    for(k=0;k<trainset.length;k++)
                    {
                        if(trainset[k]==i)
                        {
                            arr[i][k+1]++;                            
                        }                                                             
                        else
                        {
                            continue;
                        }
                                
                    }
                }
            }
        }
    }        
}