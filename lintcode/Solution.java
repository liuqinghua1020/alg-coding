package alg;

import java.util.ArrayList;

public class Solution {
	
	public ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
		if(dictionary == null) return null;
		ArrayList<String> words = new ArrayList<String>();
		int maxlength = 0;
		for(String word : dictionary){
			if(word.length() > maxlength){
				words.clear();
				words.add(word);
				maxlength = word.length();
			}else if(word.length() == maxlength){
				words.add(word);
			}
		}
		
		return words;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] dictionary1 = {"dog",
				  "google",
				  "facebook",
				  "internationalization",
				  "blabla"};
		ArrayList<String> words1 = s.longestWords(dictionary1);
		for(String wd : words1){
			System.out.print(" " + wd + " ");
		}
		
		System.out.println();
		
		String[] dictionary2 = { "like",
				  "love",
				  "hate",
				  "yes"};
		ArrayList<String> words2 = s.longestWords(dictionary2);
		for(String wd : words2){
			System.out.print(" " + wd + " ");
		}
		
	}

}
