package cp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P2 {
/*Sum of even numbers of Fibonacci Series*/
	public static void main(String[] args) {
		try {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        LinkedHashMap<BigInteger, BigInteger> orderedMap = new LinkedHashMap<>();
        ArrayList<BigInteger> orderedLi = new ArrayList<>();
        ArrayList<BigInteger> evenNos = new ArrayList<>();
        for(int a0 = 0; a0 < t; a0++){
        	BigInteger curVal = in.nextBigInteger();
            orderedLi.add(curVal);
            orderedMap.put(curVal, BigInteger.ZERO);
        }
        BigInteger[] sortedLi = (BigInteger[]) orderedLi.toArray(new BigInteger[orderedLi.size()]);
        Arrays.sort(sortedLi);
        long max = sortedLi[sortedLi.length-1].longValue();
        long first = 1, sec = 1, tmp;
        while(sec<max)
        {
        	tmp = sec;
        	sec = first + sec;
        	first = tmp;
        	if(sec%2==0) {
        		evenNos.add(BigInteger.valueOf(sec));
        	}
        	
        }
        System.out.println(evenNos);
        BigInteger sum = new BigInteger("0");
        for(int i=0,j=0;i<sortedLi.length;i++)
        {
        	while(j<evenNos.size() && sortedLi[i].compareTo(evenNos.get(j))!=-1)
        	{
        		sum = sum.add(evenNos.get(j));
        		j++;
        	}
        	orderedMap.replace(sortedLi[i], sum);
        }
        for(BigInteger val : orderedLi)
        {
        	System.out.println(orderedMap.get(val));
        }
        /*for(Map.Entry<BigInteger, BigInteger> entry : orderedMap.entrySet())
        {
        	System.out.println(entry.getValue());
        }*/
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
