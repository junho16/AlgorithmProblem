package lc_2_Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class Main143 {
    public void reorderList(ListNode head) {
        if(head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中点
        ListNode cur = slow;

        //分成两个链表
        ListNode p = head;
        ListNode nullPre = p;
        while (p != cur){
            nullPre = p;
            p = p.next;
        }
        nullPre.next = null;
        ListNode list1 = head;

        //第二条链表
        ListNode pre = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode list2 = pre;

        // while (list1 != null){
        //     System.out.print(list1.val + " ");
        //     list1 = list1.next;
        // }
        // System.out.println();
        // while (list2 != null){
        //     System.out.print(list2.val + " ");
        //     list2 = list2.next;
        // }

        ListNode list1Tmp = null ;
        ListNode list2Tmp = null ;
        while (list1.next != null && list2.next != null){
            list1Tmp = list1.next;
            list2Tmp = list2.next;
            list1.next = list2;
            list2.next = list1Tmp;
            list1 = list1Tmp;
            list2 = list2Tmp;
        }
        list1.next = list2;
        // if(list2Tmp != null)
        //     list2.next = list2Tmp;
    }
}
