package com.leetcode.problem;


/*
 * 
 * LeetCode Problem 3. Longest Substring Without Repeating Characters
 * 
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/"/>
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. 
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int longest = 0, count = 0;
	    int[] map = new int[128];
	    for(int curr = 0, start = 0; curr < s.length(); ++curr) {
	        int index = map[s.charAt(curr)];
	        if(start < index) {
	            if(longest < count) longest = count;
	            count = curr - index;
	            start = index;
	        }
	        count++;
	        map[s.charAt(curr)] = curr + 1;
	    }
	    return longest > count ? longest : count;
    }
}
