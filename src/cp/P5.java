package cp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P5 {
// Smallest num which is multiple of all the numbers from 1 to N
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int prod = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=2;i<=n;i++)
            {
            	int ctr = 1;
            	int num = i;
            	for(int j=2;j<=i;)
            	{
            		if(num%j==0)
            		{
            			ctr*=j;
            			num/=j;
            		}
            		else
            		{
            			if(map.containsKey(j))
            			{
            				if(map.get(j)<ctr)
            				{
            					map.replace(j, ctr);
            				}
            			}
            			else
            			{
            				if(ctr!=1)
            					map.put(j, ctr);
            			}
            			ctr=1;
            			j++;
            		}
            	}
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
            	prod = prod * entry.getValue();
            }
            System.out.println(prod);
        }	
	}

}
