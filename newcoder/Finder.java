
public class Finder {

    public boolean findX(int[][] mat, int n, int m, int x) {
    	int i = 0;
    	while(i<n && mat[i][m-1] < x){
    		 i++;
    	}
    	
    	
    	if(i>=n){
    		return false;
    	}
    	
    	if(mat[i][m-1] == x){
    		return true;
    	}

    	int j=0;
    	while(j<m&&mat[i][j]<x){
    		j++;
    	}
    	
       	
    	if(j>=m){
    		return false;
    	}
    	
    	if(mat[i][j] == x){
    		return true;
    	}
 
    	return false;
    }
	public static void main(String[] args) {
		Finder finder = new Finder();
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println( finder.findX(arr, 3,3, 9));
	}

}
