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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode check = head;
        ListNode remove = head;
        while(check != null) {
            count = count + 1;
            check = check.next;
        }
        int removeIndex = count - n;
        // remove head
        if (removeIndex == 0) {
            return head.next;
        }
        int index = 0;
        while(remove != null) {
            if(index == removeIndex - 1) {
                remove.next = remove.next.next;
            }
            remove = remove.next;
            index++;
        }
        return head;
    }
}


// Method 2 : Two pointer approach
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while(n > 0) {
            right = right.next;
            n--;
        }
        while(right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
