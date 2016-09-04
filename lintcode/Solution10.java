package alg;

import alg.Solution9.INPUTS;

//Done !!!!!
public class Solution10 {
	enum INPUTS{
		Zero,            //0
		Integer,         //1~9，
		Decimal,      // 小数点
		Scientific,   //科学计数法  e
		Sign,         //符号 +/-
		Unkown         //未知字符
	}
	
	int[][] stateTranMatrix = { //stateTranMatrix 表示状态转移矩阵， stateTranMatrix[当前状态][当前输入符] = 下一状态, -1表示没有状态:错误
			{5,6,2,-1,1},
			{5,6,2,-1,-1},
			{3,4,-1,-1,-1},
			{3,4,-1,9,-1},
			{4,4,-1,9,-1},
			{5,6,7,9,-1},
			{6,6,8,9,-1},
			{3,4,-1,-1,-1},
			{3,4,-1,9,-1},
			{11,11,-1,-1,10},
			{11,11,-1,-1,-1},
			{11,11,-1,-1,-1}
	};
	
	private boolean isSpace(char a){
		return a == ' ' || a == '	';
	}

	public INPUTS getInputs(char a){
		if(a == '0') return INPUTS.Zero;
		if(a == '.') return INPUTS.Decimal;
		if(a == 'e') return INPUTS.Scientific;
		if(a == '+' || a == '-') return INPUTS.Sign;
		if(a >= '1' && a <= '9') return INPUTS.Integer;
		return INPUTS.Unkown;
				
	}
	
	/**
	 *  * Valid Number 
	 * 
	 *
	 * 合法的字符包括 "1"~"9", "e", "-/+", ".", " "(空格)， "	"(Tab键)
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {
		s = s.trim();
		int currState = 0; //当前状态，初始化
			
		if( s == null ) return false;
			
		char[] chars = s.toCharArray();
			
		for(int i=0; i<chars.length; i++){
			//if(isSpace(chars[i])) continue;
			if(isSpace(chars[i])) return false;
			
			INPUTS inputs = this.getInputs(chars[i]);
			
			if(inputs == INPUTS.Unkown) return false;
			
			currState = stateTranMatrix[currState][inputs.ordinal()];
			
			if(currState == -1) return false;
			
		}
			
		return currState == 3 || currState == 4 || currState == 5 || currState == 6  || currState == 7 || currState == 8 || currState == 11;
   }

	/**
	 * @param args
	 * 
	 * 001 true
	 * 00  true
	 * 01  true
	 * 0e: false
	 * 2e0  true
	 * 0e1  true
	 * . 0   false
	 * . 1   false
	 * .1    true
	 * 1 .   false
	 * 1.    true
	 *  01.  true
	 * "0080052.24"  true
	 */
	public static void main(String[] args) {
		Solution10 solution13 = new Solution10();
		 
		 String text1 = "0.1e";
		 String text2 = "e01";
		 String text3 = "01";
		 String text4 = "-1";
		 String text5 = "0";
		 String text6 = " 0.1 ";
		 String text7 = "abc";
		 String text8 = "1a";
		 String text9 = "2e10";
		 String text10 = "e";
		 String text11 = "e1";
		 String text12 = " - ";
		 String text13 = " . ";
		 String text14 = " . 1 ";
		 String text15 = " . 0 ";
		 String text16 = " 1 .  ";
		 String text17 = " 0e ";
		 String text18 = " 00 ";
		 String text19 = " 001 ";
		 String text20 = " 2e0 ";
		 String text21 = " 1. ";
		 String text22 = " .1 ";
		 String text23 = " 01. ";
		 String text24 = " 0e1 ";
		 String text25 = "0080052.24";
		 
		 
		 System.out.println("text1 " + text1 + " : " + solution13.isNumber(text1));
		 System.out.println("text2 " + text2 + " : " + solution13.isNumber(text2));
		 System.out.println("text3 " + text3 + " : " + solution13.isNumber(text3));
		 System.out.println("text4 " + text4 + " : " + solution13.isNumber(text4));
		 System.out.println("text5 " + text5 + " : " + solution13.isNumber(text5));
		 System.out.println("text6 " + text6 + " : " + solution13.isNumber(text6));
		 System.out.println("text7 " + text7 + " : " + solution13.isNumber(text7));
		 System.out.println("text8 " + text8 + " : " + solution13.isNumber(text8));
		 System.out.println("text9 " + text9 + " : " + solution13.isNumber(text9));
		 System.out.println("text10 " + text10 + " : " + solution13.isNumber(text10));
		 System.out.println("text11 " + text11 + " : " + solution13.isNumber(text11));
		 System.out.println("text12 " + text12 + " : " + solution13.isNumber(text12));
		 System.out.println("text13 " + text13 + " : " + solution13.isNumber(text13));
		 System.out.println("text14 " + text14 + " : " + solution13.isNumber(text14));
		 System.out.println("text15 " + text15 + " : " + solution13.isNumber(text15));
		 System.out.println("text16 " + text16 + " : " + solution13.isNumber(text16));
		 System.out.println("text17 " + text17 + " : " + solution13.isNumber(text17));
		 System.out.println("text18 " + text18 + " : " + solution13.isNumber(text18));
		 System.out.println("text19 " + text19 + " : " + solution13.isNumber(text19));
		 System.out.println("text20 " + text20 + " : " + solution13.isNumber(text20));
		 System.out.println("text21 " + text21 + " : " + solution13.isNumber(text21));
		 System.out.println("text22 " + text22 + " : " + solution13.isNumber(text22));
		 System.out.println("text23 " + text23 + " : " + solution13.isNumber(text23));
		 System.out.println("text24 " + text24 + " : " + solution13.isNumber(text24));
		 System.out.println("text25 " + text25 + " : " + solution13.isNumber(text25));
	}

}
