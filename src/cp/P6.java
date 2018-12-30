package cp;

import java.util.Scanner;

public class P6 {
/*Difference of (1^2 + 2^2 +...+ n^2) from square of (1+2+...+n) */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sq = (n * (n+1))/2;
            sq*=sq;
            long indSq = n*(n+1)*(2*n+1)/6;
            System.out.println(Math.subtractExact(sq, indSq));
        }
		
	}

}
