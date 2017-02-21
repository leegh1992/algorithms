package com.niuke.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从头到尾打印链表，要求不改变链表的结构
 * 
 * @author lee
 * @date 2017年2月21日
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Problem5_PrintListReversingly {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		printListFromTailToHead(null);
	}

	/**
	 * 使用栈
	 * 
	 * @param listNode
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode == null)
			return list;
		Stack<Integer> stack = new Stack<Integer>();

		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}

		while (!stack.isEmpty()) {
			list.add(stack.peek());
			stack.pop();
		}
		return list;
	}

}
