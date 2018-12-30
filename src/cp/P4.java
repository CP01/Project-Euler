package cp;

public class P4 {
/*Product of two 3-digit numbers is a palindrome or not*/
	public static void main(String[] args) {

		/*for(int i=101101; i<1000000;i++)
			System.out.println(listPalindromes(i) + " "+i);*/
		int arr[] = listPalindromes(1000000);
		for(int i=101101;i<=1000000;i++)
		{
			int n = i;
			while(!isPallindrome(n) || !isProduct(n))
	        {
	            n--;
	        }
			if(searchPLtEt(i, arr)!=n)
			System.out.println(i+" "+searchPLtEt(i, arr)+" "+n);
		}
	}
	
	private static boolean isRequiredProd(int num)
	{
		for(int i=100;i<=999;i++)
		{
			if(num%i==0)
			{
				int tmp = num/i;
				int j = 0;
				while(tmp>0)
				{
					tmp/=10;
					j++;
				}
				if(j==3) {
					//System.out.println(i+" "+num/i);
					return true;
				}
			}
		}
		return false;
	}

	private static int searchPLtEt(int i, int arr[]) {
		
		int k = 0;
		while(i<=arr[k])
		{
			k++;
		}
		return arr[k];
	}

	public static int[] listPalindromes(int n)
	{
		int arr[] = new int[280];
		int ctr=0;
		for(int i=n;i>=101101;i--)
		{
			StringBuilder sb = new StringBuilder(String.valueOf(i));
			
			/*int ini = i/1000;
			int tail = i%1000;
			int revTail = 0;
			while(tail>0)
			{
				revTail = revTail*10 + tail%10;
				tail = tail/10;
			}
			if(ini%10==0)
				ini = ini/10;*/
			if(sb.charAt(0)==sb.charAt(5) && sb.charAt(1)==sb.charAt(4) && sb.charAt(2)==sb.charAt(3))
			{
				if(isRequiredProd(i)) {
					arr[ctr] = i;
					ctr++;
				}
			}
		}
		if(isRequiredProd(99999))
			arr[279] = 99999;
		System.out.println("count is "+ ++ctr);
		return arr;
	}
	
	public static boolean isPallindrome(int n)
    {
        int temp = n,r=0,d;
        while(temp>0)
        {
            d = temp%10;
            r=r*10+d;
            temp/=10;
        }
        if(n==r)
            return true;
        else
            return false;
    }
    public static boolean isProduct(int n)
    {
        int i;
        for(i=(int)Math.sqrt(n);i>=100;i--)
            if(n%i==0 && n/(i*1000)==0)
                return true;
        return false;
    }
	
}
