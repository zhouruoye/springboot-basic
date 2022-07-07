package com.cest.f101To200;

import com.cest.pojo.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class From141To150 {

    public static void main(String[] args) {

        System.out.println(32 >> 1);
        System.out.println(32 >>> 1);
        System.out.println(32 >>> 2);
    }

    /**
     * 141. 环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     */
    public boolean hasCycle(ListNode head) {
        //通过hash判断
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.add(head)) {
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
