import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
测试样例：
["abc","de"],2
"abcde"
 * @author liuqinghua
 *
 */
public class Prior {
	
	 public String findSmallest(String[] strs, int n) {
	        // write code here
		    List<String> lists = new ArrayList<String>();
		    for(String str:strs){
		    	lists.add(str);
		    }
		    
		    Collections.sort(lists, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					 String c1 = o1 + o2;
					 String c2 = o2 + o1;
					 return c1.compareTo(c2);
				}
		    });
		    
		    StringBuffer sb = new StringBuffer();
		    for(String str: lists){
		    	sb.append(str);
		    }
		    return sb.toString();
	    }

	public static void main(String[] args) {
		Prior p = new Prior();
		String[] strs = {"abc", "de"};
		String result = p.findSmallest(strs, strs.length);
		System.out.println(result);
	}

}
