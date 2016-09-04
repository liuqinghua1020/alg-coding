package alg;

public class Solution14 {
	public String convert(String s, int numRows) {
		if(s == null || s.trim().length() <= 0){
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		
		char[] chars = s.toCharArray();
		
		int max = 2 * (numRows - 1);
		
		if(numRows <=0 || max < 0)
			return "";
		
		int start = 0;
		char c = chars[start];
		sb.append(c);
		int index = 0;
		int i=0;
		int cur = 0;
		for(int j=1; j< chars.length;j++){
			int step = 0;
			if(i % 2 == 0){
				step = max - 2*index;
				if(step <= 0){
					step = max;
				}
			}else{
				
				step = 2*index;
				if(step <= 0){
					step = max;
				}
			}
			cur += step;
			

			if(cur >= chars.length || !this.contains(chars[cur], chars) || numRows == 1){
				start += 1;
				cur = start;
				c = chars[start];
				if(!this.contains(c, chars)) break;
				sb.append(c);
				i = 0;
				index += 1;
				continue;
			}
			c = chars[cur];
			sb.append(c);
			i++ ;
		}
		
		return sb.toString();
    }
	
	private boolean contains(char c, char[] chars){
		for(char ch:chars){
			if(c == ch) return true;
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution14 solution18 = new Solution14();
		
		System.out.println(solution18.convert("123456789", 2));
		System.out.println(solution18.convert("123456789", 3));
		System.out.println(solution18.convert("123456789", 4));
		System.out.println(solution18.convert("123456789", 5));
		
		System.out.println(solution18.convert("PAYPALISHIRING", 3));
		
		System.out.println(solution18.convert("AB", 1));
	}


}
