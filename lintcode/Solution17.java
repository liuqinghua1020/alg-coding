package alg;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
	 //Decode Ways
	 public int numDecodings(String s) {
		  //动规的方式
		 if(s == null || "".equals(s)) return 0;
		 
		 char[] chars = s.toCharArray();
		 
		 int[] result = new int[chars.length];
		 
		 int c = chars[0]-'0';
		 if(c == 0){
			 return 0;
		 }
		 
		 result[0] = 1;
		 
		 int index = 0;
		 
		 for(index=1; index<chars.length; index++){
			 c = chars[index] - '0';
			 if(c != 0){
				 result[index] = result[index-1];
			 }
			 
			 int c_pre = chars[index-1] - '0';
			 int sum = c_pre*10 + c;
			 if(c_pre != 0 && sum <= 26 && sum > 0){
				 if(index <= 1){
					 result[index] += 1;
				 }else{
					 result[index] += result[index-2];
				 }
			 }
		 }
		 
		 return result[chars.length-1];
	 }
	 
	 
	    /**
		 * @param args
		 */
		public static void main(String[] args) {
			Solution17 solution17 = new Solution17();
			//String s = "";
			//String s = "12";
			//String s = "227";
			//String s = "0";
			//String s = "00";
			//String s = "100"; 
			//String s = "101";
			String s = "1223";
			
			int num = solution17.numDecodings(s);
			System.out.println(num);
		}

}

//回溯法求解
/*
private void getResult(List<Integer> result, int index, char[] chars) {
    if(chars==null || chars.length == 0){
    	return;
    }
    
	if(index == chars.length){
		 count = count + 1;
		 return;
	}
	 
	char ch = chars[index];
	int c = ch - '0';
	 
	if(result.isEmpty()){
		result.add(c);
		this.getResult(result, index+1, chars);
	}else{
		result.add(c);
		this.getResult(result, index+1, chars);
		result.remove(result.size()-1);
		
		int num = result.get(result.size()-1);
		int sum = num*10 + c;
		if(sum <= 26){
			result.remove(result.size()-1);
			result.add(sum);
			this.getResult(result, index+1, chars);
		}
	}
}
*/

	/*private void getResult(List<Integer> result, int index, char[] chars) {
		if(index == chars.length){
			 count = count + 1;
			 return;
		}
		
		int num = 0;
		if(!result.isEmpty()){
			num = result.get(result.size()-1);
		}
		 
		char ch = chars[index];
		
		int c = ch - '0';
		
		if(num > 10){
			result.add(c);
			this.getResult(result, index+1, chars);
		}else{
			int sum = num*10 + c;
			if(sum <= 26){
				if(!result.isEmpty()){
					result.remove(result.size()-1);
				}
				result.add(sum);
				this.getResult(result, index+1, chars);
				
				result.remove(result.size()-1);
				result.add(num);
				result.add(c);
				this.getResult(result, index+1, chars);
				
			}
		}
		
	}*/
