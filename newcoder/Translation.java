
/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
测试样例：
"ABCDE",5,3
返回："DEABC"
 * @author liuqinghua
 *
 */
public class Translation {
	
	/**
	 *  思路，基本同字符翻转。reverse（全部） --》 reverse(n-len), reverse(len)
	 * @param A
	 * @param n
	 * @param len
	 * @return
	 */
	 public String stringTranslation(String A, int n, int len) {
		    char[] chars = A.toCharArray();
		    this.reverse(chars, 0, n-1);
		    
		    if(n < len) return null;
		    
		    this.reverse(chars, 0, n-len-1);
		    this.reverse(chars,n-len,n-1);
		 	return new String(chars);
	 }
	 
	 private void reverse(char[] A, int start, int end){
		  if(end < start || A.length < end - start +1) return;
		  
		  int left = start;
		  int right = end;
		  while(right > left){
			    this.swap(A, left++, right--);
		  }
	 }
	 
	 private void swap(char[] A, int left, int right){
		 char tmp = A[left];
		 A[left] = A[right];
		 A[right] = tmp;
	 }

	public static void main(String[] args) {
		String A = "ABCDE";
		int n = A.length();
		int len = 2;
		
		Translation t = new Translation();
		System.out.println(t.stringTranslation(A, n, len));
	}

}
