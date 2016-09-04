package alg;

//First Bad Version
public class Solution19 {
	
	//二分法 还是只寻找 中间点，终止条件自拟
	 public int firstBadVersion(int n) {
		 if(n<=0) return 0;
		 if(n==1) {
			   if(isBadVersion(n)) return n;
			   else  return 0;
		 }
		 
		 if(this.isBadVersion(1)) return 1; //如果第一个就是坏的，那就直接返回吧
		 //上面排除掉三种极端的情况，下面就是至少n>=2的情况了。
		 int left = 1;
		 int right = n;
		 int middle = left+(right-left)/2;
		 
		 while(left >=1 && right <= n && left <= right && middle >=1 && middle+1 <= n
				               &&  this.isTheSame(middle, middle+1) == true){
			 
				 	 if(this.isBadVersion(middle) == false && this.isBadVersion(middle + 1) == false){
				 		    left = middle+1;
				 	 }else if(this.isBadVersion(middle) == true && this.isBadVersion(middle + 1) == true){
				 		    right = middle-1;
				 	 }
				 	 
				 	 //middle = (left + right)/2; //left + right 可能会整数越界。。
				 	 middle = left+(right-left)/2;
		 }
		 
		 if(middle >=1 && middle + 1 <= n && this.isBadVersion(middle)==false &&  this.isBadVersion(middle+1)==true){
			 return middle+1;
		 }
		
		 return 0;
	  }



	private boolean isTheSame(int i, int j) {
		  if((this.isBadVersion(i)==true && this.isBadVersion(j)==true) || (this.isBadVersion(i)==false && this.isBadVersion(j)==false))
			  return true;
		  return false;
	}



	public boolean isBadVersion(int index){
		//boolean[] indexes = {false, false, true, true, true};
		//boolean[] indexes = {false, false, false, true};
		//boolean[] indexes = {false, false};
		//return  indexes[index];
		if(index > 0 && index < 2147483647) return false;
		else if(index >= 2147483647 && index <= 2147483647) return true;
		return false;
	}
	public static void main(String[] args) {
		Solution19 solution19 = new Solution19();
		int n = 2147483647 ;
		int index =solution19.firstBadVersion(n);
		System.out.println("第一个坏的零件是  " + index);
	}

}
