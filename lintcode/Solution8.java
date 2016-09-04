package alg;

public class Solution8 {
	/**
	 * 
	 * @param board 数独矩阵
	 * 
	 * 思路：以回溯的方式进行操作，每一个 空格 试探 1~9 个数字（这个部分可以通过预处理的方式减少试探的次数），然后检测是否符合规则
	 *     1.该数字在该行是否出现过
	 *     2.该数字在该列是否出现过
	 *     3.该数字在该元素所在的小九宫格内是否出现
	 *     
	 */
	
	//Sudoku Solver
		//回溯法
		public void solveSudoku(char[][] board) {
		     //针对每一个 空格，尝试 从 1~9 赋值，合格了继续下一步,为了满足下一步 （9,9）宫格 总共 81步 (0~80)
			 Result result = this.solve(board, 0, 80);
			 board = result.board;
		}
		
		private Result solve(char[][] board, int step, int total) {
			 if(step > total) {
				 Result result = new Result(Solution8.this.copy(board), true);
				 return result;
			 }
			 
			 int i = step / 9;
			 int j = step % 9;
			 while(board[i][j] != '.' && step < total){
				 step ++;
				 i = step / 9;
				 j = step % 9;
			 }
			 
			 for(char candidate = '1'; candidate <= '9'; candidate++){
				 if(this.detection(board, candidate, i, j)){
					 board[i][j] = candidate;
					 Result result = this.solve(board, step+1, total);
					 if(result != null && result.success){
						 
						 return result;
						 
					 }else{
						 board[i][j] = '.';
					 }
					 
				 }
		     }
			 
			 Result result = new Result(Solution8.this.copy(board), false);
			 return result;
		}

		/**
		 * 判断 候选的值 是否能填入此数独中
		 * @param board 数独
		 * @param candidate 候选值
		 * @param i 候选值所在行
		 * @param j 候选值所在列
		 */
		public boolean detection(char[][] board, char candidate, int i, int j){
			//包括 一行，一列，以及所在的小九宫格
			if(this.detectionRow(board, candidate, i, j) && this.detectionCol(board, candidate, i, j)
					&& this.detetionMat(board, candidate, i, j)){
				return true;
			}
			
			return false;
		}

		/**
		 * 检测一列
		 * @param board
		 * @param candidate
		 * @param j
		 * @return
		 */
		private boolean detectionCol(char[][] board, char candidate, int iIndex, int j) {
			if(board.length <= 0) return false;
			int length = board[0].length;
			if(j > length || j < 0) return false;
			for(int i=0; i<length ; i++){
				if(iIndex == i) continue;
				if(candidate == board[i][j]) return false;
			}
			return true;
		}

		/**
		 * 检测一行
		 * @param board
		 * @param candidate
		 * @param j
		 * @return
		 */
		private boolean detectionRow(char[][] board, char candidate, int i, int jIndex) {
			if(i > board.length || i < 0) return false;
			for(int j=0; j< board[i].length; j++){
				if(jIndex == j) continue;
				if(candidate == board[i][j]) return false;
			}
			return true;
		}
		
		
		/**
		 * 检测所在九宫格
		 * @param board
		 * @param candidate
		 * @param j
		 * @return
		 */
		private boolean detetionMat(char[][] board, char candidate, int i, int j) {
			for(int a=-2; a<=2; a++){
				for(int b=-2; b<=2; b++){
					if(this.outBoundy(i, j, a, b)) continue;
					if(i == i+a && j == j+b) continue;
					if(board[i+a][j+b] == candidate) return false;
				}
			}
			
			return true;
		}

		/**
		 * 九宫格检测是否越界 true为越界
		 * @param i
		 * @param j
		 * @param a
		 * @param b
		 * @return
		 */
		private boolean outBoundy(int i, int j, int a, int b) {
			int iIndex = i % 3;
			int jIndex = j % 3;
			if(iIndex + a > 2 || iIndex + a < 0 || jIndex + b > 2 || jIndex +b < 0) return true;
			return false;
		}
		

		class Result{
			char[][] board;
			boolean success;
			
			public Result(char[][] board, boolean success){
				 this.board = board;
				 this.success = success;
			}
		}
		
		public char[][] copy(char[][] board){
			char[][] newBoard = new char[board.length][board.length];
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					newBoard[i][j] = board[i][j];
				}
			}
			
			return newBoard;
		}
		
		/*public void print(char[][] board){
			System.out.println("-----------------------------------------");
			for(int i=0; i < board.length; i++){
				 for(int j=0; j<board[i].length; j++){
					 System.out.print(" " + board[i][j] + " ");
				 }
				 System.out.println();
			 }
			System.out.println("-----------------------------------------");
		}*/
		

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			 char[][] board = {
					 {'5','3','.','.','7','.','.','.','.'},
					 {'6','.','.','1','9','5','.','.','.'},
					 {'.','9','8','.','.','.','.','6','.'},
					 {'8','.','.','.','6','.','.','.','3'},
					 {'4','.','.','8','.','3','.','.','1'},
					 {'7','.','.','.','2','.','.','.','6'},
					 {'.','6','.','.','.','.','2','8','.'},
					 {'.','.','.','4','1','9','.','.','5'},
					 {'.','.','.','.','8','.','.','7','9'},
			 };
			 
			 Solution8 solution8 = new Solution8();
			 solution8.solveSudoku(board);
			 //solution8.print(board);
			 /*for(int i=0; i < board.length; i++){
				 for(int j=0; j<board[i].length; j++){
					 System.out.print(" " + board[i][j] + " ");
				 }
				 System.out.println();
			 }*/
		}

}
