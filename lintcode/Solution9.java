package alg;

public class Solution9 {
	
	enum INPUTS{
		Zero,         //0，
		Integer,      //整数 1~9
		Decimal,      // 小数点
		Scientific,   //科学计数法  e
		Sign,         //符号 +/-
		Unkown         //位置字符
	}
	
	int[][] stateTranMatrix = { //stateTranMatrix 表示状态转移矩阵， stateTranMatrix[当前状态][当前输入符] = 下一状态, -1表示没有状态:错误
			{2,3,4,-1,1},
			{2,3,-1,-1,-1},
			{-1,3,4,-1,-1},
			{3,3,4,7,-1},
			{6,5,-1,-1,-1},
			{5,5,-1,7,-1},
			{6,5,-1,-1,-1},
			{-1,9,-1,-1,8},
			{-1,9,-1,-1,-1},
			{9,9,-1,-1,-1}
	};
	
	private boolean isSpace(char a){
		return a == ' ' || a == '	';
	}

	public INPUTS getInputs(char a){
		if(a == '.') return INPUTS.Decimal;
		if(a == 'e') return INPUTS.Scientific;
		if(a == '+' || a == '-') return INPUTS.Sign;
		if(a == '0') return INPUTS.Zero;
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
		int currState = 0; //当前状态，初始化
			
		if( s == null ) return false;
			
		char[] chars = s.toCharArray();
			
		for(int i=0; i<chars.length; i++){
			if(isSpace(chars[i])) continue;
			
			INPUTS inputs = this.getInputs(chars[i]);
			
			if(inputs == INPUTS.Unkown) return false;
			
			currState = stateTranMatrix[currState][inputs.ordinal()];
			
			if(currState == -1) return false;
			
		}
			
		return currState == 2 || currState == 3 || currState == 5 || currState == 6 || currState == 9;
	}
	
	
	/**
	 * @param args
	 
	 * "0.1e" -> false
	 * "e01" --false;
	 * "-1" --> true
	 * "0" => true
		"  . 0 " => true
		" 0.1 " => true
		"abc" => false
		"1 a" => false
		"2e10" => true
		" e " => false 
		" e 1" => false
		" - " => false
		" . " => false 
		" . 1 " => true
		" 1 .  " => true
		" 0 1" => true
	*/
	public static void main(String[] args) {
		 Solution9 solution13 = new Solution9();
		 
		 String text1 = "0.1e";
		 String text2 = "e01";
		 String text3 = "01";
		 String text4 = "-1";
		 String text5 = "0";
		 String text6 = " 0.1 ";
		 String text7 = "abc";
		 String text8 = "1 a";
		 String text9 = "2e10";
		 String text10 = "e";
		 String text11 = "e 1";
		 String text12 = " - ";
		 String text13 = " . ";
		 String text14 = " . 1 ";
		 String text15 = " . 0 ";
		 
		 
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
	}

}
