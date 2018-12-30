package cp;

import java.util.Scanner;

// Find the sum of primes less than equal to N
public class P10 {

	public static void main(String[] args) {

		int primes[] = sieve(1000000);
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if(n==1)
            {
            	System.out.println(n);
            	continue;
            }
            long sum = 0;
            int i = 0;
            while(i<primes.length && primes[i] <= n )
            {
            	sum = sum + primes[i++];
            }
            System.out.println(sum);
        }
		
	}
	
	private static int[] sieve(int n)
	{
		int primes[] = new int[78498];
		boolean nums[] = new boolean[n+1];
		for(int i=2;i<=n;i++)
		{
			for(int j=2*i;j<=n;j=j+i)
			{
				nums[j] = true;
			}
		}
		for(int i=2,j=0;i<=n;i++)
		{
			if(nums[i]==false)
			{
				primes[j++]=i;
				System.out.println(i);
			}
		}
				
		return primes;
		
	}

}
