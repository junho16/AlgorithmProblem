package interview.lc_2_Interview;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Main25 {
    ListNode head;
    int k;
    public ListNode reverseKGroup(ListNode h, int kk) {
        head = h;
        k = kk;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p != null){
            if(isExistNextK(p)){
                ListNode pre = p.next;
                ListNode cur = p.next.next;
                for(int i = 0 ;i < k - 1; i++){
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                ListNode headtmp = p.next;
                p.next = pre;
                headtmp.next = cur;
                p = headtmp;
            }
        }
        return dummy.next;
    }
    boolean isExistNextK(ListNode r){
        int num = 0;
        ListNode root = r;
        while (root != null){
            num++;
            root = root.next;
        }
        return num >= k;
    }
}
