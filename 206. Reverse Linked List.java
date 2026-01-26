// Using stack
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }

        ListNode reverseHead = st.pop();
        curr = reverseHead;

        while (!st.isEmpty()) {
            curr.next = st.pop();
            curr = curr.next;
        }

        curr.next = null;
        return reverseHead;
    }
}

// Using Iterative approach

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
