package alg;

//Wildcard Matching
public class Solution24 {

	public boolean isMatch(String s, String p) {
		if(s == null || p == null) return false;
	    char[] ss = s.toCharArray();
	    char[] ps = p.toCharArray();
	    if(ps.length == 0 && ss.length != 0) return false;
	    int si = 0;
	    int pi = 0;
	    
	    boolean star = false; //p是否之前包含有*
	    int smark = -1;
	    int pmark = -1;
	    for(; si < ss.length; ){
	    	  if(pi < ps.length && ps[pi] == '?'){
	    		  si ++;
	    		  pi ++;
	    	  }else if(pi < ps.length && ps[pi] == '*'){
	    		    star = true;
	    		    smark = si;
	    		    while(pi < ps.length && ps[pi] == '*') pi ++;
	    		    if(pi == ps.length) return  true;
	    		   pmark = pi-1;
	    	  }else{
	    		    if((pi < ps.length &&  ss[si] != ps[pi])  || pi >= ps.length){//如果不相等，则将smark原本的值纳入到 * 的范围之中,或者此前估计错误，导致pi遍历结束
	    		    	  if(!star) return false; //如果之前没有* ,则直接匹配不成功
	    		    	  si = ++smark;
	    		    	  pi = pmark+1;
	    		    }else{
	    		    	si++;
	    		    	pi++;
	    		    }
	    	  }
	    }
	    
	    while(pi < ps.length && ps[pi] == '*') pi++;
	    return pi ==ps.length;
	}
	public static void main(String[] args) {
		   Solution24  solution24 = new Solution24();
		   
		    String s0 = "a";
		    String p0 = "";
		    System.out.println("0 : " + solution24.isMatch(s0, p0));
		    
		    
		    String s1 = "aa";
		    String p1 = "a";
		    System.out.println("1 : " + solution24.isMatch(s1, p1));
		    
		    String s2 = "aa";
		    String p2 = "aa";
		    System.out.println("2 : " + solution24.isMatch(s2, p2));
		    
		    String s3 = "aaa";
		    String p3 = "aa";
		    System.out.println("3 : " + solution24.isMatch(s3, p3));
		    
		    String s4 = "aa";
		    String p4 = "*";
		    System.out.println("4 : " +  solution24.isMatch(s4, p4));
		    
		    String s5 = "aa";
		    String p5 = "a*";
		    System.out.println("5 : " + solution24.isMatch(s5, p5));
		    
		    String s6 = "ab";
		    String p6 = "a?";
		    System.out.println("6 : " + solution24.isMatch(s6, p6));
		    
		    String s7 = "ab";
		    String p7 = "*?";
		    System.out.println("7 : " + solution24.isMatch(s7, p7));
		    
		    String s8 = "aab";
		    String p8 = "c*a*b";
		    System.out.println("8 : " + solution24.isMatch(s8, p8));
		    
		    String s9 = "aab";
		    String p9 = "*a*b";
		    System.out.println("9 : " + solution24.isMatch(s9, p9));
		    
		    String s10 = "";
		    String p10 = "*";
		    System.out.println("10 : " + solution24.isMatch(s10, p10));
		    
		   String s11 = "a";
		    String p11 = "aa";
		    System.out.println("11 : " + solution24.isMatch(s11, p11));
		   
		   String s12 = "a";
		   String p12 = "*a";
		   System.out.println("12 : " + solution24.isMatch(s12, p12));
		   
		   String s13 = "abb";
		   String p13 = "a?";
		   System.out.println("13 : " + solution24.isMatch(s13, p13));
		   
		   String s14 = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
		   String p14 = "*aabb***aa**a******aa*";
		   System.out.println("14 : " + solution24.isMatch(s14, p14));
		   
		   String s15 = "aaaaa";
		   String p15 = "*aaaaa*";
		   System.out.println("15 : " + solution24.isMatch(s15, p15));
		    
		    String s16 = "ab";
		    String p16 = "*?";
		    System.out.println("16 : " + solution24.isMatch(s16, p16));
	}

}

/*public boolean isMatch(String s, String p) {
	  if(s == null || p == null) return false;
    char[] ss = s.toCharArray();
    char[] ps = p.toCharArray();
    Boolean[][]  results = new Boolean[ss.length][ps.length];
	  return  this.match(ss, ps, 0, 0, results);
}

private boolean match(char[] s, char[] p,  int si,  int pi, Boolean[][] result){
	  if(si == s.length && pi == p.length ) return true;
	  
	  if(si < s.length && pi < p.length && result[si][pi] != null){
		       return result[si][pi];  //解决递归深度过长的问题
	  }
	  
	  
	   boolean r1 = true;
	   boolean r2 = false;
	   boolean r3 = false;
	   boolean r4 = false;
	   
	   while(si < s.length && pi < p.length ){
		       if(s[si] != p[pi]  &&  p[pi] != '?' ){
		    	      r1 = false;
		    	      result[si][pi] = r1;
		    	      break;
		       }
		       result[si][pi] = r1;
		       si ++;
		       pi ++;
	   }
	   
	   if(si < s.length && pi < p.length ){
	         if(p[pi] == '*'){
			     r2 = match(s, p, si, pi+1, result);
			     r3 = match(s,p, si+1,pi, result);
			     r4 = match(s, p, si+1, pi+1, result);
		   }
		   result[si][pi]  = r1 || r2 || r3 || r4 ;
	   }else if(si < s.length){
		      return false;
	   }else if(pi < p.length){
		      if(pi == p.length - 1 && p[pi] == '*'){
		    	    return  true;
		      }
		      return false;
	   }
	 
	   return r1 || r2 || r3 || r4 ;
}*/

/**
if(s == null || p == null) return false;
char[] ss = s.toCharArray();
char[] ps = p.toCharArray();
int si = 0;
int pi = 0;

int markp = -1;  //mark  *'s  position

for(; si < s.length();  ){
	   if((pi < ps.length && ss[si] == ps[pi] ) || (pi < ps.length && ps[pi] == '?')){
		       si ++;
		       pi ++;
	   }else if(pi < ps.length && ps[pi] == '*'){
		    markp = pi;
		    pi ++;
	   }else{
		    if(markp == -1){
		    	
		    }
		    pi = markp;
		    si ++;
		    pi ++;
	   }
}

while(pi < ps.length){
	  if(ps[pi] != '*'){
		     break;
	  }
	  pi ++;
}
return   pi == ps.length;
*/