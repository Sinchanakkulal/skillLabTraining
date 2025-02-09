import java.util.Scanner;

public class fuel{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("number of fuel integer");
        int m=sc.nextInt();
        System.out.println("fuel consumed at each delivery point is ");
        int[] Fuel=new int[m];
        for(int i=0;i<m;i++)
        {
            Fuel[i]=sc.nextInt();
        }
        int[] PostfixSum=new int[m];
        PostfixSum[0]=0;
        
        for(int i=0;i<m;i++)
        {
            int Sum=0;
            for(int j=i;j<m;j++)
            {
                Sum+=Fuel[j];
            }
            PostfixSum[i]=Sum;
        }
        System.out.print("PostfixSum[]:");
        System.out.print("[");
        for(int i=0;i<m;i++)
        {
            System.out.print(PostfixSum[i]+",");
        }
         System.out.print("]");
    }
}