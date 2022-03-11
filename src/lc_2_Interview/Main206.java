package lc_2_Interview;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Main206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
//        下面的代码太烂了，上面的更清晰
//        if(head == null)
//            return null;
//        ListNode p = head;
//        ListNode q = head.next;
//        ListNode n = q;
//        while (q != null && q.next != null){
//            n = q.next;
//            q.next = p;
//            p = q;
//            q = n;
//        }
//        if(q != null)q.next = p;
//        else q = p;
//        head.next = null;
//        return q;
    }
}
