package com.phoenix.ex24;

/**
 * (5ms)
 * 这是一个递归的做法。注意交换的顺序
 * @author Phoenix-Z
 *
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		//空链表或者链表中的节点个数为偶数
        if(head == null)
        	return head;
        //链表中的节点个数为奇数
        if(head != null && head.next == null)
        	return head;
        //每次成对交换节点时，第二个节点就是新的头结点
        ListNode newHead = head.next;
        //第一个节点的新后继节点使用递归算法
        head.next = swapPairs(newHead.next);
        //第二个节点指向第一个节点
        newHead.next = head;
        //返回新节点
        return newHead;
    }
	
	public static void main(String[] args) {
		
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}