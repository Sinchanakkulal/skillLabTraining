import java.util.Arrays;
import java.util.Scanner;

public class MinCoinChange {
    public static int CoinChange(int[] coins,int amt){
        int[] dp=new int[amt+1];
         Arrays.fill(dp, amt + 1);
        dp[0]=0;

        for(int i=1;i<=amt;i++)
        {
            for(int coin:coins)
            {
                if(i>=coin)
                {
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amt]==amt+1?-1:dp[amt];
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of the coins given: ");
        int n=sc.nextInt();
        int[] coins=new int[n];

        System.out.println("enter the coins you have");
        for(int index=0;index<n;index++)
        {
            coins[index]=sc.nextInt();

        }
        System.out.println("enter the targeted amount ");
        int amt=sc.nextInt();

        int result=CoinChange(coins,amt);
        System.out.println("number of coins have to reach the targetted amount"+result);

        sc.close();

    }
} 