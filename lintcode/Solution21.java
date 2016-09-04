package alg;

import java.util.HashMap;
import java.util.Map;

//Fraction to Recurring Decimal
public class Solution21 {
	
	public String fractionToDecimal(int numerator, int denominator) {
		    if(denominator == 0) return null;
		    if(numerator == 0) return "0";
		    StringBuffer sb = new StringBuffer();
	        Map<Long, Integer> resultPos = new HashMap<Long, Integer>();
	        
	        long n= numerator;
	        long d = denominator;
	        
	        long result = 0;
	        long rest = 0;
	       boolean flag = true;
	       
	       while(flag){
	        	result = n / d;
	        	rest = n - result*d;
	        	Integer pos = null;
	        	
	        	if(!(sb.indexOf(".") > 0)){
	        		if(result == 0 && ((numerator>0&&denominator<0) || (numerator<0&&denominator>0))) sb.append("-0");
	        		else sb.append(result);
	        	}else{
	        		sb.append(Math.abs(result));
	        	}
	        	if(rest == 0) break;
	        	if(!(sb.indexOf(".") > 0)){
	        		sb.append(".");
	        	}
	        	
	        	if((pos = resultPos.get(rest)) != null){ //会进入某一个循环小数阶段
	        		sb.insert(pos+1, "(");
	        		sb.append(")");
	        		break;
	        	}
	        	
	        	resultPos.put(rest, sb.length()-1);
	        	n = rest*10;
	        }
	        return sb.toString();
    }
	
/*	public String fractionToDecimal(int numerator, int denominator) {
	    if(denominator == 0) return null;
	    StringBuffer sb = new StringBuffer();
        Map<Integer, Integer> resultPos = new HashMap<Integer, Integer>();
        
        int n= numerator;
        int d = denominator;
        
       int result = 0;
       int rest = 0;
       boolean flag = true;
       
       
	   result = n/d;
       n = n - d*result ;
       sb.append(result + "");
       if(n == 0){
   		   flag = false;
   	    }else{
   	    	sb.append(".");
   	    }
    
       while(flag){
    	   int lst = n;
    	   while(n / d == 0){
    		      lst = n;
    		      n = n*10;
    		      if( n / d == 0){
    		    	  sb.append("0");
    		      }
    	   }

    	   
        	result = n / d;
        	rest = n - result*d;
        	Integer pos = null;
        	
        	sb.append(Math.abs(result));
        	if(rest == 0) break;
        	
        	if((pos = resultPos.get(rest)) != null){ //会进入某一个循环小数阶段
        		sb.insert(pos+1, "(");
        		sb.append(")");
        		break;
        	}
        	
        	n = rest;
        	resultPos.put(rest, sb.length()-1);
        }
        return sb.toString();
}*/
	
	public static void main(String[] args) {
			Solution21 solution21 = new Solution21();
			String result1 = solution21.fractionToDecimal(1, 2);
			System.out.println(result1);
			
			String result2 = solution21.fractionToDecimal(2, 1);
			System.out.println(result2);
			
			String result3 = solution21.fractionToDecimal(2, 3);
			System.out.println(result3);
			
			String result4 = solution21.fractionToDecimal(0, 2);
			System.out.println(result4);
			
			String result5 = solution21.fractionToDecimal(1, 0);
			System.out.println(result5);
			
			String result6 = solution21.fractionToDecimal(1, 3);
			System.out.println(result6);
			
			String result7 = solution21.fractionToDecimal(-100, 3);
			System.out.println(result7);
			
			String result8 = solution21.fractionToDecimal(100, 5);
			System.out.println(result8);
			
			String result9 = solution21.fractionToDecimal(	-2147483647,  1 ); //整数的负边界
			System.out.println(result9);
			
			String result10 = solution21.fractionToDecimal(	1,  60); 
			System.out.println(result10);
			
			String result11 = solution21.fractionToDecimal(	1,  90);
			System.out.println(result11);
			
			String result12 = solution21.fractionToDecimal(	1,  900);
			System.out.println(result12);
			
			String result13 = solution21.fractionToDecimal(	1,  1000); 
			System.out.println(result13);
			
			String result14 = solution21.fractionToDecimal(	1,  99); 
			System.out.println(result14);
			
			String result15 = solution21.fractionToDecimal(	-1,  99); 
			System.out.println(result15);
			
			String result16 = solution21.fractionToDecimal(	-1,  -2147483648); 
			System.out.println(result16);
	}

}
