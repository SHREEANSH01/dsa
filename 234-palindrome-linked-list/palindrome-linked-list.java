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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> a= new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
        ArrayList<Integer> b= new ArrayList<>(a);
        Collections.reverse(b);
        for(int i=0;i<a.size();i++){
            if(!a.get(i).equals(b.get(i)))return false;
        }
        return true;
    }
}