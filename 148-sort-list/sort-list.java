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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> ans = new ArrayList<>();
        while(head!=null){
            ans.add(head.val);
            head=head.next;
        }
        Collections.sort(ans);
        ListNode hr = null;
        for(int i=ans.size()-1;i>=0;i--){
            ListNode curr = new ListNode(ans.get(i));
            curr.next=hr;
            hr=curr;
        }
        return hr;
    }
}