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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(list1!=null){
            arr.add(list1.val);
            list1=list1.next;
        }
        while(list2!=null){
            arr.add(list2.val);
            list2=list2.next;
        }
        if(arr.size()==0)return null;
        Collections.sort(arr);
        ListNode hr = new ListNode(arr.get(0));
        ListNode curr= hr;

        for(int i=1;i<arr.size();i++){
            curr.next=new ListNode(arr.get(i));
            curr=curr.next;
        }
        return hr;
    }
}