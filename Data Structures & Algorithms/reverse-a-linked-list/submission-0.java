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
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode prev = null;
        while (curNode != null){
             //readjust pointers
             ListNode temp = curNode.next;
             curNode.next = prev;
             //move to next nodes
             prev = curNode;
             curNode = temp;
        }
        return prev;
    }
}
