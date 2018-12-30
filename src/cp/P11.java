package cp;

import java.util.Scanner;
//Find max product of four continuous numbers in the grid all directions
public class P11 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = grid_i+grid_j;
            }
        }
        
        long start = System.nanoTime();
        solution(grid);
        System.out.println(System.nanoTime()-start);
        start = System.nanoTime();
        editorialSolution(grid);
        System.out.println(System.nanoTime()-start);
	}
	
	private static void editorialSolution(int[][] grid)
	{
		final int dr[] = {-1,-1,0,1}, dc[] = {0,1,1,1};
		int result = 0;
		for (int i = 0; i < 20; ++i)
			for (int j = 0; j < 20; ++j)
				for (int d = 0; d < 4; ++d) {
					int p = 1;
					for (int n = 0; n < 4; ++n) {
						int r=i+dr[d]*n, c=j+dc[d]*n;
						if (r >= 0 && r < 20 && c >= 0 && c < 20)
							p *= grid[r][c];
						else
							p = 0;
					}
					result = Math.max(result, p);
				}
		System.out.println(result);
	}
	
	private static void solution(int[][] grid)
	{
		int maxPrd = 0;
        for(int i=0;i<20;i++)
        {
        	for(int j=0;j<20;j++)
        	{
        		if(j<17)
        			maxPrd = Math.max(maxPrd, (grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3]));
        		if(i<17) {
        			maxPrd = Math.max(maxPrd, (grid[i][j]*grid[i+1][j]*grid[i+2][j]*grid[i+3][j]));
        			if(j<17)
        				maxPrd = Math.max(maxPrd, (grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3]));
        			if(j>2)
        				maxPrd = Math.max(maxPrd, (grid[i][j]*grid[i+1][j-1]*grid[i+2][j-2]*grid[i+3][j-3]));
        		}
        	}
        }
        System.out.println(maxPrd);
	}

}
