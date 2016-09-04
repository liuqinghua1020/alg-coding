package alg;

public class Solution7 {
	/**
	 * Palindrome Partitioning II
	 * 动态规划 
	 *    1. f(i, j) = min{f(i, k) + f(k, j)}(i <= k <= j) + 1
	 *        ==> 
	 *       f(i) = min(f(k+1) + P(i, k)==true?1:0)(i<=k<=n-1) 
	 *       f(i, j) 表示 字符区间 （i, j）的最小cut值， f(i)表示(i, n-1) 区间 最小的cut值
	 *       
	 *    2. 回文数判断（动态规划版） P(i,j) 表示 字符区间（i, j）是否回文数， P(i,j) = true表示 是 ， P(i,j) = false 表示 否
	 *       P(i, j) = char[i] == char[j] && P(i+1, j-1) 
	 *       P(i, i) = true;
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		char[] chars = s.toCharArray();
		
		//初始化 P
		int[][] P = new int[s.length()][s.length()];
		for(int i=0; i< P.length ;i++){
			for(int j=0; j<P[i].length; j++){
				P[i][j] = -1;
			}
			
			P[i][i] = 1;
		}
		
		int[] f = new int[s.length()+1];
		
		f[s.length()] = 0;
		f[s.length()-1] = 1;
		
		for(int i= s.length() - 1; i>=0; i--){
			 int min = Integer.MAX_VALUE;
			 for(int k= i; k<s.length(); k++){
				 int sum = f[k+1] + this.isPalindrome(chars, i, k, P);
				 if(sum < min){
					 min = sum;
				 }
			 }
			 f[i] = min;
		}
		
		return f[0]-1;
    }

	
	/**
	 * 是否回文数字  0表示是回文  1表示不是回文
	 * @param chars
	 * @param i
	 * @param j
	 * @param P
	 * @return
	 */
	private int isPalindrome(char[] chars, int i, int j, int[][] P) {
		 if(i < 0 || j > chars.length) return -1;
		 if(i == j) return 1;
		 if(i == j-1) return chars[i] == chars[j] ? 1 : 0;
		 if(i > j) return P[j][i];
		 
		 int flag = P[i+1][j-1];
		 if(flag == -1){
			 flag = this.isPalindrome(chars, i+1, j-1, P);
			 P[i+1][j-1] = flag;
		 }
		 
		 boolean result = chars[i] == chars[j] && flag == 1;
		 int num = result ? 1:0;
		 return num;
	}
	
	public static void main(String[] args){
		Solution7 solution7 = new Solution7();
		/*
		String s = "a";
		int[][] P = new int[s.length()][s.length()];
		for(int i=0; i< P.length ;i++){
			for(int j=0; j<P[i].length; j++){
				P[i][j] = -1;
			}
			
			P[i][i] = 1;
		}
		System.out.println(solution7.isPalindrome(s.toCharArray(), 0, s.length()-1, P));*/
		
		/*String msg = "a";
		System.out.println(solution7.minCut(msg));
		
		String msg4 = "ab";
		System.out.println(solution7.minCut(msg4));
		*/
		
		String msg3 = "aab";
		System.out.println(solution7.minCut(msg3));
		
		/*
		String msg2 = "efe";
		System.out.println(solution7.minCut(msg2));*/
	}

}
