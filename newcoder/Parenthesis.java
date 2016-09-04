
public class Parenthesis {
	
	public boolean chkParenthesis(String A, int n) {
		  char[] chars = A.toCharArray();
		  int num = 0;
		  for(int i=0; i<n;i++){
			    if(chars[i] == '(')  num++;
			    if(chars[i] == ')')   num --;
			    if(num < 0) return false;
		  }
		  
		  if(num != 0) return false;
		  return true;
	 }

	public static void main(String[] args) {
		Parenthesis p = new Parenthesis();
		
		System.out.println(p.chkParenthesis("()(", "()(".length()));
		
		System.out.println(p.chkParenthesis("()a()", "()a()".length()));
	}

}
