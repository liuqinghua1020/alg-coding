import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author liuqinghua
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 */
public class Transform {
	 
	/**
	 * 
	 * @param A
	 * @param lena
	 * @param B
	 * @param lenb
	 * @return
	 */
	 public boolean chkTransform(String A, int lena, String B, int lenb) {
		    if(lena != lenb) {
		    	return false;
		    }
		    
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i=0; i<lena;i++){
	        	char key = A.charAt(i);
	        	if(map.get(key) == null){
	        		map.put(key, 0);
	        	}
	        	map.put(key,  map.get(key) + 1);
	        }
	        
	        
	        for(int i=0; i< lenb; i++){
	        	 char key = B.charAt(i);
	        	 if(map.get(key) == null){
	        		 return false;
	        	 }
	        	 
	        	 map.put(key, map.get(key)-1);
	        }
	        
	        Iterator<Character> it = map.keySet().iterator();
	        while(it.hasNext()){
	        	  Integer value = map.get(it.next());
	        	  if(value !=  0){
	        		  return false;
	        	  }
	        }
		    return true;
	 }
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		Transform tf = new Transform();
		System.out.println(tf.chkTransform(a, a.length(), b, b.length()));
	}

}
