// 1.remove Nth Node From End of List


// Hint
// Given the head of a linked list, remove the nth node from the end of the list and return its head.
 
// Example 1:Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:Input: head = [1], n = 1
// Output: []

// Example 3:Input: head = [1,2], n = 1
// Output: [1]

 
// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 
// 2.Given n pairs of parentheses, write a function to .
 
// Example 1:Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:Input: n = 1
// Output: ["()"]

 
// Constraints:
// 1 <= n <= 8


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; this.next = null; }
}

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move first and second together until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node
        second.next = second.next.next;
        
        return dummy.next;
    }
}
