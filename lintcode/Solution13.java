package alg;

public class Solution13 {
	
	
	public int myAtoi(String str) {
		return 0;
		/*int num = 0;
		int sign = 1;
		StringBuffer buffer = new StringBuffer();
		
		if(str == null || str.length()==0){
			return 0;
		}
		
		char[] chars = str.toCharArray();
		
		int index = 0;
		while(chars[index] == ' ' || chars[index] == '	') //去前导空格 
			index ++;
		
		if(chars[index] == '+' || chars[index] == '-') {
			if(chars[index] == '-'){
				sign = -1;
			}
			index ++;
		}
		
		while(index < chars.length){
			if(chars[index] < '0' || chars[index] > '9'){
				break;
			}
			buffer.append(chars[index]);
			if(value < 0 && sign == 1){
				return Integer.MAX_VALUE;
			}
			
			if(value > 0 && sign == -1){
				return Integer.MIN_VALUE;
			}
			 
			num = num * 10 + sign * (chars[index] - '0');;
			index ++;
		}
	
		return  num;*/
	}
/*	
	//String to Integer 
	//还是要从低位找起
	// 输入为空 ，不为空，非数字， 超出int范围
    public int myAtoi(String str) {
    	int num = 0;
    	int sqr = 1;
    	str = str.trim();
    	for(int i = str.length()-1; i>=0; i--){
    		char a = str.charAt(i);
    		if(a == '-' && i != 0){
    			return -1;
    		}
    		
    		if(a == '-' && i == 0){
    			num = -1 * num;
    			continue;
    		}
    		
    		if(a == '+' && i != 0){
    			return -1;
    		}
    		
    		if(a == '+' && i == 0){
    			continue;
    		}
    		
    		
    		
    		if(a < '0' || a > '9'){
    			return -1;
    		}
    		
    		num = (a-'0')*sqr + num;
    		sqr *= 10;
    	
    	}
        return num;
    }*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution13 solution13 = new Solution13();
/*		
		String n1 = "-";
		System.out.println(solution13.myAtoi(n1));
		
		String n2 = "0";
		System.out.println(solution13.myAtoi(n2));
		
		String n3 = "01";
		System.out.println(solution13.myAtoi(n3));
		
		String n4 = "10";
		System.out.println(solution13.myAtoi(n4));
		
		String n5 = "-10";
		System.out.println(solution13.myAtoi(n5));
		
		String n6 = "-10a";
		System.out.println(solution13.myAtoi(n6));
		
		String n7 = "-1009";
		System.out.println(solution13.myAtoi(n7));
		
		String n8 = "-100a";
		System.out.println(solution13.myAtoi(n8));
		
		String n9 = "+100";
		System.out.println(solution13.myAtoi(n9));
		
		String n10 = "+-2";
		System.out.println(solution13.myAtoi(n10));
		
		System.out.println(solution13.myAtoi("+1"));
		
		System.out.println(solution13.myAtoi(""));
		
		System.out.println(solution13.myAtoi("2147483646"));
		System.out.println(solution13.myAtoi("2147483647"));
		System.out.println(solution13.myAtoi("2147483648"));
		
		System.out.println(solution13.myAtoi("-2147483647"));
		System.out.println(solution13.myAtoi("-2147483648"));
		System.out.println(solution13.myAtoi("-2147483649"));*/
		//2147483648
		//10522545459
		//1932610867
		System.out.println(solution13.myAtoi("10522545459"));
	}

}
