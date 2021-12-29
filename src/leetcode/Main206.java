package leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 */
public class Main206 {
    public ListNode reverseList(ListNode head) {
        if(head == null ){
            return null;
        }
        ListNode cur = head;
        ListNode pre = new ListNode();
        ListNode tmp = head;
        while(cur != null){
//            cur = pre.next;
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode rehead = pre;
        while(rehead.next.next != null){
            rehead = rehead.next;
        }
        rehead.next =null;
        return pre;
    }
}
