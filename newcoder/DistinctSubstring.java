import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DistinctSubstring {
	
	public int longestSubstring(String A, int n) {
        Map<Character, Integer> charPos = new HashMap<Character, Integer>(); //记录一个无重复串中每一个字符的上一次出现的位置
        Map<Character, Integer> charStart = new HashMap<Character, Integer>(); //记录一个无重复串的起始字符的位置
        int num = 1;
        int maxNum = num;
        charPos.put(A.charAt(0),  0);
        charStart.put(A.charAt(0),  0);
        
        char startChar = A.charAt(0);
        
        
        for(int i=1; i< n; i++){
        	  char c = A.charAt(i);
        	  if(charPos.containsKey(c)){ //一旦包含该字符a， 证明在 a之后到下一个a之前都不存在重复，则可以 (a*)a  变成 a (*a) 继续下面遍历字符
        		     if(maxNum < num){
        		    	  maxNum = num;
        		     }
        		     Integer pos = charPos.get(c);
        		     Integer start = charStart.get(c);
        		     
   		    	     num = i-pos;
   		    	     
   		    	     for(int j=start; j<pos;j++){
   		    	    	 char cremove = A.charAt(j);
   		    	    	 charPos.remove(cremove);
   		    	    	 charStart.remove(cremove);
   		    	     }
   		    	     
   		    	  Iterator<Character> it = charPos.keySet().iterator();
   		    	  while(it.hasNext()){
   		    		   char old = it.next();
   		    		   if(old == c){
   		    			   charPos.put(c,  i);
   		    		   }
   		    		charStart.put(old, pos+1);
   		    	  }
   		    	     
   		    	  startChar = A.charAt(pos+1);  
        	  }else{
        		    num ++;
        		    charPos.put(c,  i);
        		    int start = charStart.get(startChar);
        		    charStart.put(c, start);
        	  }
        }
        
        if(maxNum < num){
	    	  maxNum = num;
	     }
        
        return maxNum;
    }

	public static void main(String[] args) {
		DistinctSubstring ds = new DistinctSubstring();
		String a = "abcdaefghi";
		System.out.println(ds.longestSubstring(a, a.length()));
	}

}
