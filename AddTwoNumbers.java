// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/* Definition for singly-linked list.*/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class SolutionAddTN {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode operate = result;
        int digit = 0;
        while (l1 != null || l2 != null|| digit == 1){
            int val1 = l1 == null? 0:l1.val;
            int val2 = l2 == null? 0:l2.val;
            int sum = digit + val1 + val2;
            operate.val = sum % 10;
            digit = sum / 10;
            if (digit > 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)){
                operate.next = new ListNode(digit);
                operate = operate.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }
}


//other's solution
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;           //abort first node
    }
}