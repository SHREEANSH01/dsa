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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // StringBuilder s1 = new StringBuilder();
        // StringBuilder s2 = new StringBuilder();

        // while (l1 != null) {
        //     s1.append(l1.val);
        //     l1 = l1.next;
        // }

        // while (l2 != null) {
        //     s2.append(l2.val);
        //     l2 = l2.next;
        // }

        // s1.reverse();
        // s2.reverse();

        // int n1 = Integer.parseInt(s1.toString());
        // int n2 = Integer.parseInt(s2.toString());

        // String ans = String.valueOf(n1 + n2);

        // ListNode head = null;

        // for (int i =0 ; i <=ans.length() - 1; i++) {
        //     ListNode node = new ListNode(ans.charAt(i) - '0');
        //     node.next = head;
        //     head = node;
        // }

        // return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            carry = sum / 10;
        }

        return dummy.next;

    }
}