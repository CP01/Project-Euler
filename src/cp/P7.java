package cp;

public class P7 {

	// Return nth prime number
	public static void main(String[] args) {

		//10000th prime number is 104729
		//int n = 104729;
		int arr[] = sieve(104729);
		for(int n=2;n<10000;n++)
		{
			if(brute(n) != arr[n-1])
			{
				System.out.println(n+" "+brute(n) +" "+ arr[n]);
			}
		}
	}
	
	
	private static int[] sieve(int n)
	{
		int arr[] = new int[10000];
		boolean notPrime[] = new boolean[n+1];
		for(int i=2;i<n;i++)
		{
			for(int j=i+i;j<n;j=j+i)
			{
				if(!notPrime[j])
					notPrime[j] = true;
			}
		}
		int j=0;
		for(int i=2;i<n+1;i++)
		{
			if(!notPrime[i])
			{
				arr[j++] = i;
			}
		}
		return arr;
	}
	
	private static int brute(int n)
	{
		int ctr = 1;
		int i = 3;
		for(;i<1000000;i++)
		{
			boolean isPrime = true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				ctr++;
				if(ctr==n) {
					//System.out.println(ctr+" "+i);
					break;
				}
			}
		}
		return i;
	}

}
