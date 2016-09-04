package alg;

//Add Digits
public class Solution23 {
	
	 public int addDigits(int num) {
		   if(num<0) return 0;
		   if(num<10) return num;
		   double n = num-1;
		   int a = (int)Math.floor(n/9);
		   int result = num - 9 * a;
		   return result;
	  }

	public static void main(String[] args) {
			Solution23 solution23 = new Solution23();
			
			int r1 = solution23.addDigits(0);
			System.out.println(r1);
			
			int r2 = solution23.addDigits(10);
			System.out.println(r2);
			
			int r3 = solution23.addDigits(38);
			System.out.println(r3);
			
			int r4 = solution23.addDigits(65536);
			System.out.println(r4);
			
	}

}
