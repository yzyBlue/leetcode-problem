/**
 * 
 * 
 * LeetCode Problem 6. ZigZag Conversion
 * 
 * <a href="https://leetcode.com/problems/zigzag-conversion/"/>
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	
 * 
 * 
 * 
 */
package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		int length = s.length();
		if(length<=numRows||numRows==1){
			return s;
		}
		List<String>[] listArray = new ArrayList[numRows];
		for (int j = 0; j < length; j++) {
			int b=j%(2 * numRows - 2);
			if(b<=numRows-1){
				if(listArray[b]==null){
					listArray[b]=new ArrayList<String>();
				}
				listArray[b].add(s.substring(j, j+1));
			}else{
				if(listArray[2*(numRows-1)-b]==null){
					listArray[2*(numRows-1)-b]=new ArrayList<String>();
				}
				listArray[2*(numRows-1)-b].add(s.substring(j, j+1));
			}
		}
		StringBuffer result=new StringBuffer();
		for (int k=0;k<numRows;k++){
			for(int j=0;j<listArray[k].size();j++){
				result.append(listArray[k].get(j));
			}
		}
		return result.toString();
	}
}
