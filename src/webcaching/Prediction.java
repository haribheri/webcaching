
package webcaching;

import java.util.*;

public class Prediction 
{
    int numberOfPages;
    int [] trainset;
    public Prediction(int pages)
    {
        this.numberOfPages=pages;
    }
    public Prediction(int a[])
    {
        this.trainset=new int [100];
        int i;
        for(i=0;i<trainset.length;i++)
            trainset[i]=a[i];
    }
    private void predict(int numberOfpages)
    {
        int [][] arr=new int[numberOfpages][];
        int i,j,k;
        for(i=0;i<numberOfpages;i++)
            arr[i]=new int[numberOfpages];
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