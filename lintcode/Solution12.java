package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution12 {
	
	//Anagrams
	//返回的数值是 每一组 Anagrams 中 按字典序排序最小那个字符串
	public List<String> anagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str:strs){
			String orderStr = this.checkOrder(str);
			List<String> list = map.get(orderStr);
			if(list == null){
				list = new ArrayList<String>();
				map.put(orderStr, list);
			}
			list.add(str);
			
		}
		
		
		List<String> result = new ArrayList<String>();
		for(String key:map.keySet()){
			List<String> list = map.get(key);
			if(list.size() > 1){
				result.addAll(list);
			}
		}
        return result;
    }
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private String checkOrder(String str) {
		char[] chars = str.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for(char ch:chars){
			list.add(ch);
		}
		
		Collections.sort(list);
		
		char[] newChars = new char[list.size()];
		for(int i=0; i<chars.length;i++){
			newChars[i] = list.get(i);
		}
		
		return new String(newChars);
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String[] strs = {"eat", "boy","his","ate", "b", "sih", "tae","yyo","yoo"};
		String[] strs = {"", ""};
		Solution12 solution12 = new Solution12();
		List<String> list = solution12.anagrams(strs);
		for(String str : list){
			System.out.println(" - " + str + " ");
		}
	}

}
