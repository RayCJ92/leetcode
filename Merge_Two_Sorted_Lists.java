// 21. Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
// e.g. 
// 	  input : [4,5]
// 			  [2,8] 
// 	  answer : [2,4,5,8]  (sorted too)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode first = node;
        while (l1 != null || l2 != null){
            if(l1 != null){
                if (l2 == null || l1.val <= l2.val){
                    node = node.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            if(l2 != null){
                if(l1 == null || l1.val > l2.val){
                    node = node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
        }
        return first.next;
    }
}

// a BRILLIANT way using recursion (*@ο@*) 
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}