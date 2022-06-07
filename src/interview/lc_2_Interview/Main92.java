package interview.lc_2_Interview;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class Main92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = getNode(dummy , left);
        if (start != null){
            ListNode p = start;
            ListNode pre = p.next;
            ListNode cur = p.next.next;
            for(int i = 0 ; i < right - left ; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode headtmp = p;
            ListNode endhead = p.next;
            p.next = pre;
            endhead.next = cur;
        }
        return dummy.next;

    }
    ListNode getNode(ListNode root , int num){
        ListNode x = root;
        for(int i = 0 ; i < num - 1 ; i ++){
            x = x.next;
        }
        return x;
    }
}
