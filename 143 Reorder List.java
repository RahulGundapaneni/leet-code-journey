
class Solution {
    public void reorderList(ListNode head) {
        ListNode check = head;
        ListNode result = check;
        Stack<ListNode> st = new Stack<>();
        while(head != null) {
            st.add(head);
            head = head.next;
        }
        while (check != st.peek() && check.next != st.peek()) {
            ListNode temp = check.next;
            ListNode tail = st.pop();

            check.next = tail;
            tail.next = temp;
            check = temp;
        }
        st.pop().next = null;
        head = result;
    }
}

// Method 2: Finding middle, reversing second half and merging both halves

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
    public void reorderList(ListNode head) {
        ListNode test = head;
        if (head == null || head.next == null) return;
        ListNode slow = test;
        ListNode fast = test;


        while(fast.next != null && fast.next.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(fast.val);

        // Now reverse the list
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = prev;
        while(curr != null) {
            ListNode temp = test.next;
            ListNode currNext = curr.next;
            test.next = curr;
            curr.next = temp;
            test = temp;
            curr = currNext;
        }
    }
}

