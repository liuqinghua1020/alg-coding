
public class Rotation {
	
	 public boolean chkRotation(String A, int lena, String B, int lenb) {
	        if(A == null || B == null || lena != lenb){
	        	return false;
	        }
	        
	        String C = A + A;
	        return C.contains(B);
	    }

	public static void main(String[] args) {
		String a = "12345";
		String b = "45213";
		System.out.println(new Rotation().chkRotation(a, a.length(), b, b.length()));
	}

}
