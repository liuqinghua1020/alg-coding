package alg;
//Search a 2D Matrix II
public class Solution22 {
    
	/**
	 * 矩阵递归的方式进行处理
	 * @param matrix
	 * @param target
	 * @return
	 */
	 public boolean searchMatrix(int[][] matrix, int target) {
		    if(matrix == null) return false;
		    int row = matrix.length;
		    int column = matrix[0].length;
		    boolean result = this.search(matrix, target, 0, 0, row-1, column-1);
	        return result;
	 }
    
	 /**
	  * 
	  * @param matrix  搜索的子矩阵
	  * @param target  目标数
	  * @param left   左上角元素的行索引
	  * @param top   左上角元素的列索引
	  * @param right  右下角元素的行索引
	  * @param down 右下角元素的列索引
	  * @return
	  */
	 private boolean search(int[][] matrix, int target, int left, int top,  int right, int down){
		   if(left > right || top > down){  //递归终止条件
			     return false;
		   }
		   
		   boolean result1 = false;
		   boolean result2 = false;
		   boolean result3 = false;
		   boolean result4 = false;
		   boolean result5 = false;
		   
           int rowMiddle = left + (right - left)/2;
           int colMiddle = top + (down-top)/2;
           if(matrix[rowMiddle][colMiddle] == target){
        	     return true;
           }
           
           if(matrix[rowMiddle][colMiddle] > target){
        	   result1 = this.search(matrix, target, left, top, rowMiddle-1, colMiddle-1);
        	   result2 = this.search(matrix, target, left, colMiddle, rowMiddle-1, colMiddle);
        	   result3 = this.search(matrix, target, left, colMiddle+1, rowMiddle-1, down);
        	   result4 = this.search(matrix, target, rowMiddle, top, rowMiddle, colMiddle-1);
        	   result5 = this.search(matrix, target, rowMiddle+1, top, right, colMiddle-1);
           }else{
        	   result1 = this.search(matrix, target, rowMiddle+1, colMiddle+1, right, down);
        	   result2 = this.search(matrix, target, left, colMiddle+1, rowMiddle-1, down);
        	   result3 = this.search(matrix, target, rowMiddle, colMiddle+1, rowMiddle, down);
        	   result4 = this.search(matrix, target, rowMiddle+1, top, right, colMiddle-1);
        	   result5 = this.search(matrix, target, rowMiddle+1, colMiddle, right, colMiddle);
           }
 
		   return result1 || result2 || result3 || result4 || result5;
	 }


	public static void main(String[] args) {
		  Solution22  solution22 = new Solution22();
		  /*int[][] matrix = {
				  {1,   4,  7, 11, 15},
                  {2,   5,  8, 12, 19},
                  {3,   6,  9, 16, 22},
                  {10, 13, 14, 17, 24},
                  {18, 21, 23, 26, 30}
		  };*/
		  
		  int[][] matrix = {
				  {1,   4,  7},
                  {2,   5,  8},
                  {3,   6,  9},
		  };
		  
		  int[][] matrix2 = {
				  {1,   4},
                  {2,   5}
		  };
		  
		  int[][] matrix3 = {
				  {1,   4,  7, 11},
                  {2,   5,  8, 12},
                  {3,   6,  9, 16},
                  {10, 13, 14, 17},
		  };
		  
		  int[][] matrix4 = {
				  {1},
		  };
		  
		  System.out.println(solution22.searchMatrix(matrix2, 5));
		  
		  /*System.out.println(solution22.searchMatrix(matrix, 20));
		  
		  System.out.println(solution22.searchMatrix(matrix, 0));
		  
		  System.out.println(solution22.searchMatrix(matrix, 100));*/
	}

}


/* 
int targetRow = this.search(matrix, target, row, column-1, true);

if(targetRow < 0 || targetRow > row-1) return false;

int targeIndex = this.search(matrix, target, targetRow, column, false);

if(targeIndex < 0 || targeIndex>column-1 || matrix[targetRow][targeIndex] != target) return false;

	 
	 /**
	  * 
	  * @param matrix
	  * @param target
	  * @param row          每一行最后那个元素的行索引
	  * @param column  每一列最后那个元素的列索引
	  * @param searchOnRow 表明对列进行二分查找还是对行进行二分查找
	  * @return
	  */
/*
	private int search(int[][] matrix, int target, int row, int column,  boolean searchOnRow) {
		   int left = 0;
		   if(searchOnRow){
			      int right = row-1;
			      int middle = 0;
			      while(left <= right){
			    	     middle = left + (right - left)/2;
			    	     if(matrix[middle][column] == target) return middle;
			    	     
			    	     if(matrix[middle][column] > target){
			    	    	     right = middle - 1;
			    	     }else{
			    	    	     left = middle + 1;
			    	     }
			      }
			      
			      return left;
		   }else{
			       int right = column-1;
			       int middle = left + (right - left)/2;
				      while(left <= right){
				    	     if(matrix[row][middle] == target) return middle;
				    	     
				    	     if(matrix[row][middle] > target){
				    	    	     right = middle - 1;
				    	     }else{
				    	    	     left = middle + 1;
				    	     }
				      }
				      
				      return left;
		   }
	}
*
*
*/
