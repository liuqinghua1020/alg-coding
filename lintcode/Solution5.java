package alg;

//LeetCode Unique Paths
public class Solution5 {
	
	/*public int uniquePaths(int m, int n) {
        int x = 1, y = 1;
        int pathNum = paths(x, y, m, n);
		return pathNum;
    }
	
	private int paths(int x, int y ,int m, int n){
		if(x > m || y > n) return 0;
		if(x == m && y == n) return 1;
		return paths(x+1, y, m, n) + paths(x, y+1, m, n);
	}*/
	
	private int[][] paths = new int[101][101];
	{
		for(int i=0; i<101; i++){
			for(int j=0; j<101; j++)
				paths[i][j] = -1;
		}
	}
	public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1 ) return 0;
        if(m == 1 && n == 1) return 1;
        
        int right = paths[m-1][n];
        if(right == -1){
        	right = uniquePaths(m-1, n);
        	paths[m-1][n] = right;
        }
        
        int down = paths[m][n-1];
        if(down == -1){
        	down = uniquePaths(m, n-1);
        	paths[m][n-1] = down;
        }
        
		return right + down;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Solution5 solution5 = new Solution5();
		 int m = 23, n = 12;
		 int count = solution5.uniquePaths(m, n);
		 System.out.println(count);
	}

}
