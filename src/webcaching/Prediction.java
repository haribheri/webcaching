
package webcaching;

import java.util.*;
import java.io.*;

public class Prediction 
{
    int rangeOfPages;//generated by client
    int [] trainset;
    int trainsetPages;
    int [][] arr;
    Client client;
    
    public Prediction(int a[])//called by trainset
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
        
        this.trainset=new int [this.trainsetPages];
        int i,j;
        for(i=0;i<trainset.length;i++)
            trainset[i]=a[i];
    
        client=new Client();
        this.rangeOfPages=client.rangeOfpages;
        this.arr=new int[rangeOfPages][];
        for(j=0;j<this.rangeOfPages;j++)
        {
            arr[j]=new int[rangeOfPages];
        }
        costruct1stOrderPredictionTable(rangeOfPages);
        //orderOfPrediction();

    }
    public void orderOfPrediction()
    {
        int ch;
        System.out.println("Enter value between 1-3 :");
        System.out.println("1 for 1st order prediction");
        System.out.println("2 for 2nd order prediction");
        System.out.println("3 for 3rd order prediction");
       
        Scanner sc=new Scanner(System.in);
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                costruct1stOrderPredictionTable(rangeOfPages);
                break;
            case 2:
                costruct2ndOrderPredictionTable(rangeOfPages);
                break;
            case 3:
                costruct2ndOrderPredictionTable(rangeOfPages);
                break;
        }
    }
    public int predict(int page)//called by prefetch
    {
        int i,max_prob_page,max_value;
        
        max_value=findMax(arr[page]); //finding maximum value of array -> arr[i]
        for(i=0;i<arr[page].length;i++)
            if(arr[page][i]==max_value)//corresponding j value for maximum value
                break;
        max_prob_page=i;
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
    private void costruct1stOrderPredictionTable(int rangeOfpages)
    {
        int i,j,k;
        for(i=0;i<rangeOfpages;i++)
        {
            for(j=0;j<rangeOfpages;j++)
            {
                arr[i][j]=0;
            }
        }
        for(i=0;i<rangeOfpages;i++)
        {
                    for(k=0;k<trainset.length-1;k++)
                    {
                        if(trainset[k]==i)
                        {
                            if((trainset[k]==0)&&(trainset[k+1]==0))
                            {
                                continue;                                
                            }
                            else
                            {
                            arr[i][trainset[k+1]]++;
                            }
                        }                                                             
                        else
                        {
                            continue;
                        }
                                
                    }
        }
    }
   /* class Order2Node
    {
	public:
		int i,j;
	Order2Node(int i,int j)
	{
		this.i=i;
		this.j=j;
	}
    }
    */
    private void costruct2ndOrderPredictionTable(int rangeOfpages)
    {
        /*
	int i,j,k;
	Order2Node 2ndord;
	int index=(rangeOfpages*(rangeOfpages-1))/2;
	2ndord arr[index];
	for(i=0;i<index;i++)
	{
		for(j=0;j<index;j++)
		{
			arr.i.j=0;
			arr.j.i=0;	
		}
	}
        */
        
    }
    private void costruct3rdOrderPredictionTable(int numberOfpages)
    {
        
    }
}
