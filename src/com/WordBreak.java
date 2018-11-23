package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public WordBreak() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<String> falseSet = new HashSet<>(); //memoization
	
	//caller function
	public boolean wordBreak(String s, List<String> wordDict) {
		
		//sanitation and wrong input checks
		if(s.trim().length()==0)
			return false;
		
		if(wordDict.isEmpty())
			return false;
		
		
		
	return eval(s, wordDict);
    }
	
	
	//evaluation function
	private boolean eval(String s, List<String> wordDict) {
		
		// if end of string is reached, we've found the combination. return true
		if(s.trim().length()==0)
			return true;
		
		// iterate over string
		for(int i=1;i<=s.length();i++) {
			
			//find if any substring is a part of dictionary
			if(wordDict.contains(s.substring(0, i))) {				
				String remainingString = s.substring(i);
				
				//if falseSet doesnt contain remaining string, it is worth exploring
				if(!falseSet.contains(remainingString)) {
					
					//call the function again
					boolean result = eval(remainingString, wordDict);
					
					// evalaute the findings
					if(result) {
						return true;
					}else { 
						falseSet.add(remainingString);
					}
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		
		String[] arr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		List<String> l = new ArrayList<>(Arrays.asList(arr));
		System.out.println(w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", l));;
		
		
	}
	
}
