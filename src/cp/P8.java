package cp;

import java.util.Scanner;

public class P8 {
/*Max. Product of k consecutive digits*/
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			String num = in.next();
			if(!num.contains("0")) {
				int ini = 0, last = ini+k-1, prod = 1;
				for(int i=0;i<k;i++)
				{
					prod = prod * Integer.valueOf(num.substring(i,i+1));
				}
				int newProd = prod;
				for(int j=1;j<=n-k;j++,last++)
				{
					newProd = (newProd/Integer.valueOf(num.substring(j-1,j))) 
							* Integer.valueOf(num.substring(last+1,last+2));
					if(newProd>prod)
						prod = newProd;
				}
				System.out.println(prod);
			}
			else
			{
				int prod = 1;
				for(int i=0;i<k;i++)
				{
					prod = prod * Integer.valueOf(num.substring(i,i+1));
				}
				for(int i=1;i<n-k;i++)
				{
					int newProd = 1;
					for(int j=i;j<k+i;j++)
					{
						newProd = newProd * Integer.valueOf(num.substring(j,j+1));
					}
					if(newProd>prod)
						prod = newProd;
				}
				System.out.println(prod);
			}
		}
	}

}
