
/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * @author liuqinghua
 *
 */
public class Reverse {
	
	/**
	 * 每一个字符逆序，每一个单词逆序
	 * @param A
	 * @param n
	 * @return
	 */
	 public String reverseSentence(String A, int n) {
	      char[] chars = A.toCharArray();
	      
	      this.reverse(chars, 0,  n-1);
	      int posStart = 0;
	      
	      for(int i=posStart+1; posStart<n&&i<n; i++){
	    	   if(i == n-1){
	    		   this.reverse(chars, posStart, i);
	    	   }else if(chars[i] == ' '){
	    		   this.reverse(chars, posStart, i-1);
	    		   posStart = i+1;
	    	   }
	      }
	      
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
		String A = "Io love you";
		Reverse r = new Reverse();
		System.out.println(r.reverseSentence(A, A.length()));
	}

}
