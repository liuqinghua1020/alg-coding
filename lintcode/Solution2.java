package alg;

public class Solution2 {
	
	private Solution2(){}
	 
	public static class SolutionHandle{
		private static final Solution2 solution2 = new Solution2();
	}
	
	public static Solution2 getInstance() {
		return SolutionHandle.solution2;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
