package cp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P3 {
/*Largest Prime Factor of a given number*/
	public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
        }*/
		long st = System.currentTimeMillis();
		for(long i=33104;i<=3311100;i++)
		{
			long l=123456781240L;
			if(brute(i)!=finalSol(i))
				System.out.println(i+" "+brute(i) + " "+finalSol(i));
			//System.out.println(i+" "+brute(l) + " "+finalSol(l));
		}
		System.out.println("time - "+(System.currentTimeMillis()-st));
		

	}
	
	public static long brute(long n)
	{
		long num = n, div = 2, result;
        ArrayList<Long> factors = new ArrayList<>();
        while(num>1)
        {
        	if(num%div==0)
        	{
        		num = num/div;
        		factors.add(div);
        		
        	}
        	else
        	{
        		div++;
        	}
        }
        if(factors.isEmpty())
        {
        	result = n;
        }
        else
        {
        	result = factors.get(factors.size()-1);
        }
		return result;
	}
	
	public static long solution(long n)
	{
		long num = n, div = 2, result;
        ArrayList<Long> factors = new ArrayList<>();
        long limit = Math.floorDiv(n, 2) + 1;
        while(div <= limit && num>1)
        {
        	if(num%div==0)
        	{
        		num = num/div;
        		factors.add(div);
        		
        	}
        	else
        	{
        		div++;
        	}
        }
        if(factors.isEmpty())
        {
        	result = n;
        }
        else
        {
        	result = factors.get(factors.size()-1);
        }
		return result;
	}
	
	public static long efficientSolution(long n)
	{
		long num = n, div = 3, result;
        ArrayList<Long> factors = new ArrayList<>();
        long limit = Math.floorDiv(n, 2) + 1;
        
        while(num%2==0)
        {
        	num/=2;
        }
        if(num==1)
        	return 2;
        while(div <= limit && num>1)
        {
        	if(num%div==0)
        	{
        		num = num/div;
        		factors.add(div);
        		
        	}
        	else
        	{
        		div+=2;
        	}
        }
        
        if(factors.isEmpty())
        {
        	result = n;
        }
        else
        {
        	result = factors.get(factors.size()-1);
        }
		return result;
	}
	
	public static long finalSol(long n)
	{
		long num = n, div = 2, result=1;
        ArrayList<Long> factors = new ArrayList<>();
        long limit = (long) Math.sqrt(n)+1;
        while(div<=limit)
        {
        	if(n%div==0)
        	{
        		num = n/div;
        		factors.add(div);
        		factors.add(num);
        	}
    		div++;
        }
        if(factors.isEmpty())
        {
        	result = n;
        }
        else
        {
        	Long arr[] = (Long[]) factors.toArray(new Long[factors.size()]);
        	Arrays.sort(arr);
        	for(int i=arr.length-1;i>=0;i--)
        	{
        		if(isPrime(arr[i]))
        		{
                	result = arr[i];
                	break;
        		}
        	}
        }
		return result;
	}
	
	public static boolean isPrime(long n)
	{
		long num = (long) (Math.sqrt(n)+1);
		if(n==2 || n==3)
			return true;
		if(n%2==0)
			return false;
		for(int i=3;i<num;i+=2)
		{
			if(n%i==0)
			{
				return false;
			}
		}
		return true;
	}

}
