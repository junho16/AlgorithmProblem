package lc_2_Interview;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Main2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int nextNum = 0;
        while(l1 != null && l2 != null){
            cur.next = new ListNode((l2.val + l1.val + nextNum) % 10);
            nextNum = (l2.val + l1.val + nextNum) / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            cur.next = new ListNode((l1.val + nextNum ) % 10);
            nextNum = (l1.val + nextNum ) / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null){
            cur.next = new ListNode((l2.val + nextNum ) % 10);
            nextNum = (l2.val + nextNum ) / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if(nextNum != 0){
            cur.next = new ListNode(nextNum);
        }
        return res.next;
    }
}