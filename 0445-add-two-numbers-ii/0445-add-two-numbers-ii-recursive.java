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
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if(length1 > length2){
            l2 = addPadding(l2, length1 - length2);
        } else {
            l1 = addPadding(l1, length2 - length1);
        }

        ListNode result = addHelper(l1, l2);
        if(carry != 0){
            ListNode head = new ListNode(carry, result);
            return head;
        }
        return result;

    }

    private int getLength(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    private ListNode addPadding(ListNode head, int pad){
        for(int i = 0 ; i < pad ; i++){
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
        }
        return head;
    }

     private ListNode addHelper(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null ){
            return null;
        }

        ListNode nextNode = addHelper(l1.next, l2.next);

        int sum = l1.val + l2.val + carry;
        carry = sum / 10;
        ListNode curr = new ListNode(sum % 10, nextNode);
        return curr;
    }
}