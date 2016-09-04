package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

	//Combination Sum
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		   if(candidates == null || candidates.length == 0){
			   return null;
		   }
		   
		   Arrays.sort(candidates);
		   
		   List<List<Integer>> lists = new ArrayList<List<Integer>>();
		   List<Integer> list = new ArrayList<Integer>();
		   
		   this.dfs(candidates, lists, list, target, 0);
		   
	       return lists;
	 }
	 
	private void dfs(int[] candidates, List<List<Integer>> lists,
			List<Integer> list, int rest, int start) {
		if(rest == 0){
			List<Integer> newList = new ArrayList<Integer>(list);
			lists.add(newList);
		} 
		
		for(int i=start; i < candidates.length; i++){
			 if(candidates[i] > rest){
				 break;
			 }
			 list.add(candidates[i]);
			 this.dfs(candidates, lists, list, rest - candidates[i], i);
			 list.remove(list.size()-1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution15 solution15 = new Solution15();
		int[] array = {8,7,4,3};
		int target = 11;
		
		List<List<Integer>> lists = solution15.combinationSum(array, target);
		
		for(List<Integer> list:lists){
			for(Integer i : list){
				System.out.print(" " +  i + " ");
			}
			System.out.println();
		}
	}

}
