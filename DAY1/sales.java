import java.util.Scanner;

public class sales{
    public static void main(String[] args)
    {
        int i,maxDay,maxSale;
        Scanner sc=new Scanner(System.in);
        int days=sc.nextInt();
        int[] sales=new int[days];

        for(i=0;i<days;i++)
        {
            
            System.out.println("enter the sales for the day"+(i+1));
            sales[i]=sc.nextInt();
           
        }
        maxSale=sales[0];
        maxDay=1;
        for(i=1;i< days;i++)
        {
            if(sales[i]>maxSale)
            {
                maxSale=sales[i];
                maxDay=i+1;
            }
        }
        System.out.println("the day with the highest sales:"+ maxSale +"is"+maxDay );
        sc.close();
    }
}