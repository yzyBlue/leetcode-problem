package com.leetcode.problem;

/*
 * 
 * LeetCode Problem 326. Power of Three
 * 
 * <a href="https://leetcode.com/problems/power-of-three/"/>
 * 
 * Given an integer, write a function to determine if it is a power of three.

Follow up:

Could you do it without using any loop / recursion?

 * 
 * 
 * */
public class PowerofThree {
	public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;    
    }
	public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
	public boolean isPowerOfThree3(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        //return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
	public boolean isPowerOfThree4(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
