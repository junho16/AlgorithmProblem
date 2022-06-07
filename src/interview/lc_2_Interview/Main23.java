package interview.lc_2_Interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Main23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode);
                listNode = listNode.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
//        for(ListNode i : queue){
////            System.out.print(i.val + " ");
//            dummy.next = i;
//            dummy = dummy.next;
//        }
        while (!queue.isEmpty()) {
            // System.out.print(queue.peek().val + " ");
            dummy.next = new ListNode(queue.poll().val);
            dummy = dummy.next;
        }
        return res.next;
    }
}
