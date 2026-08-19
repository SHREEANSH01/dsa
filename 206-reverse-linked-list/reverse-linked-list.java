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
        ArrayList<Integer> arr= new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        if(arr.size()==0) return null;
        ListNode hr =new ListNode(arr.get(arr.size()-1));
        ListNode curr=hr;
        for(int i=arr.size()-2;i>=0;i--){
            curr.next=new ListNode(arr.get(i));
            curr=curr.next;
        }
        return hr;
    }
}