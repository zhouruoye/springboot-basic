package com.cest.recursion.leetcode203;

/**
 * 203 leetcode
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode second = new ListNode(2,head);
        ListNode third = new ListNode(3,second);



        ListNode listNode = new Solution().removeElements(third, 6);
        System.out.println(111);
    }
}
