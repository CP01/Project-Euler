package cp;

import java.util.ArrayList;

// Find Pythagorean Tripplet - with given N (=a+b+c), to maximize a*b*c
public class P9 {

	public static void main(String[] args) {

		// Please note - Brute() is faster than solution()
		Long strt = System.currentTimeMillis();
		for(int i = 1;i<=3000;i++)
			System.out.println(brute(i) + " "+ i);// abc = 40260 79860
		System.out.println("Time taken - "+ (System.currentTimeMillis()-strt));
		/*System.out.println(solution(12));// abc = 60
		System.out.println(solution(30));// abc = 780
		System.out.println(solution(380));//abc = 619020
		System.out.println(solution(992));
		System.out.println(solution(1000));
		System.out.println();
		System.out.println(solution(3000));
		brute(3000);
*/
	}
	
	public static long solution(int n)
	{
		long maxABC = -1;
		if(n<12)
			return maxABC;
		//long sqN = n*n;
		int halfN = n/2;
		Long aPlusB[] = new Long[halfN-2];
		Long possibleCs[] = new Long[halfN-2];
		int k = 0;
		for(long i=2;i<halfN;i++,k++)
		{
			aPlusB[k] = n-i;
			possibleCs[k] = i;
		}
		//Evaluating equation n^2 - 2nc = (a+b)^2 - c^2 (both equals to 2ab)
		for(int i=0;i<possibleCs.length;i++)
		{
			//long twoNc = 2*n*possibleCs[i];
			//long sqC = possibleCs[i] * possibleCs[i];
			long lhs = n*n - 2*n*possibleCs[i];
			for(int j=0;j<aPlusB.length;j++)
			{
				if(possibleCs[i]+possibleCs[i] <= aPlusB[j]) {
					continue;
				}
				//long rhs = aPlusB[j] * aPlusB[j] - sqC;
				if(lhs==aPlusB[j] * aPlusB[j] - possibleCs[i] * possibleCs[i])
				{
					//long ab = lhs/2;
					//long maxAB = ;
					if(lhs>2*(halfN-1) * (halfN-1)) {
						continue;
					}
					else {
						if(!validate(lhs/2, aPlusB[j], possibleCs[i]))
							continue;
						//long abc = lhs*possibleCs[i]/2;
						if(lhs*possibleCs[i]>2*maxABC)
							return lhs*possibleCs[i]/2;// = abc;
					}
				}
			}
		}
		return maxABC;
	}

	private static boolean validate(long ab, Long aPlusB, Long c) {

		//find all the factors of "ab" and check does they less than c or their sum is equal to aPlusB[j]
		// if we have x=a+b and y=ab then a,b = (x +- sqRoot of (x^2 - 4y))/2
		double sqRoot = Math.sqrt(aPlusB*aPlusB - 4*ab);
		if(sqRoot%1 != 0 && (aPlusB+sqRoot)%2==0 )
			return false;
		else {
			//long longRoot = (long)sqRoot;
			long a = (aPlusB + (long)sqRoot)/2;
			long b = (aPlusB - (long)sqRoot)/2;
			//if(a<c && b<c && a!=b) {
			if(a*a + b*b == c*c ) {
				//System.out.println("sol abc - "+(a*b*c)+ " a+b+c - "+ (a+b+c)+ " a - "+a + " b - "+b+ " c - "+c);
				return true;
			}
		}
		return false;

	}
	
	private static int brute(int s)
	{
		int a = 0, b = 0, c = 0;
		//int s = 1000;
		int maxProd = -1;
		int A=0,B=0,C=0;
		boolean found = false;
		for (a = 1; a < s / 3; a++) {
		    for (b = a; b < s / 2; b++) {
		        c = s - a - b;
		        if (a * a + b * b == c * c) {
		            /*found = true;
		            break*/;
		            int prod = a*b*c;
		            if(maxProd < prod) {
		            	maxProd = prod;
		            	A = a;
		            	B = b;
		            	C = c;
		            }
		        }
		    }
		 
		    /*if (found) {
		        break;
		    }*/
		}
		//System.out.println("abc - "+(maxProd)+ " a+b+c - "+ (a+b+c)+ " a - "+A + " b - "+B+ " c - "+C);
		return maxProd;
	}
	
	private static void bruteOrig(int s)
	{
		int a = 0, b = 0, c = 0;
		//int s = 1000;
		boolean found = false;
		for (a = 1; a < s / 3; a++) {
		    for (b = a; b < s / 2; b++) {
		        c = s - a - b;
		 
		        if (a * a + b * b == c * c) {
		            found = true;
		            break;
		        }
		    }
		 
		    if (found) {
		        break;
		    }
		}
		System.out.println("abc - "+(a*b*c)+ " a+b+c - "+ (a+b+c)+ " a - "+a + " b - "+b+ " c - "+c);
	}

}
