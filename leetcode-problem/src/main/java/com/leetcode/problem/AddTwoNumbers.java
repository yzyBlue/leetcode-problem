package com.leetcode.problem;
/*
 * LeetCode Problem 2. Add Two Numbers 
 * 
 * <a href="https://leetcode.com/problems/add-two-numbers/"/>
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		
		Output: 7 -> 0 -> 8
		
 * 
 * */


public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode tepm=new ListNode(0);
        ListNode result=new ListNode(0);
        tepm=result;
        int a=0;
        while(l1!=null||l2!=null||a!=0){
           if(l1!=null){
               a=a+l1.val;
               l1=l1.next;
           }
           if(l2!=null){
               a=a+l2.val;
               l2=l2.next;
           }
           tepm.next=new ListNode(a%10);
           a=a/10;
           tepm=tepm.next;
        }
        return result.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}