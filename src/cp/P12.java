package cp;

public class P12 {

	public static void main(String[] args) {

		int direct[] = triangleNumsDirect();
		int tricky[] = triangleNumTricky();
		for(int i=0;i<1000;i++)
		{
			if(direct[i]!=tricky[i])
				System.out.println(direct[i]+" "+tricky[i]+" "+i);
		}
		
	}
	
	private static int[] triangleNumsDirect()
	{
		int[] arr = new int[1000];
		arr[0] = 1;
		for(int i=1;i<1000;i++)
		{
			arr[i] = (i+1) * (i+2) / 2;
		}
		return arr;
	}
	
	private static int[] triangleNumTricky()
	{
		int[] arr = new int[1000];
		arr[0] = 1;
		int k = 3,j = 1;
		for(int i=1;i<1000;i++,k+=2)
		{
			arr[i] = k*j;
			System.out.println(k+" * "+j+" = "+arr[i]);
			i++;j++;
			if(i<1000) {
				arr[i] = k*j;
				System.out.println(k+" * "+j+" = "+arr[i]);
			}
			
		}
		return arr;
	}
	
	private static int[] triangleNumFactors()
	{
		int[] arr = new int[1001];
		int num = 1, ctr=2;
		arr[0] = 1;
		arr[1] = 3;
		for(int i=2;i<1001;i++)
		{
			
			num = num+i;
			for(int j=2;j<Math.sqrt(num)+1;j++)
			{
				if(num%j==0)
				{
					ctr+=2;
				}
			}
		}
		return arr;
	}

}
