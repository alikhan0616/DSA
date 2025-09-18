/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode prev = null;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return prev;
        }

        ListNode temp = head.next;
        head.next = prev;
        prev = head;

        return reverseList(temp);


    }
}