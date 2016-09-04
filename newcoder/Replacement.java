
public class Replacement {
	
	 public String replaceSpace(String iniString, int length) {
	        // write code here
		   char[] chars = iniString.toCharArray();
		   int space = 0;
		   for(char ch:chars){
			   if(ch == ' '){
				   space ++;
			   }
		   }
		   
		   int newlength = length + space*2;
		   char[] newChars = new char[newlength];
		   int j=0;
		   for(int i=0; i<length;i++){
			   if(chars[i] == ' '){
				   newChars[j++]='%';
				   newChars[j++]='2';
				   newChars[j++]='0';
			   }else{
				   newChars[j++]=chars[i];
			   }
		   }
		   return new String(newChars);
	  }

	public static void main(String[] args) {
		Replacement r = new Replacement();
		
		String s = "Mr John Smith";
		
		System.out.println(r.replaceSpace(s, s.length()));
	}

}
