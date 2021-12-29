package max;

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
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0 ; i < lists.length ; i++){
            if(lists[i] != null)
                queue.add(lists[i]);
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while ( !queue.isEmpty()){
            ListNode peekNode = queue.poll();
            cur.next = peekNode;
            cur = cur.next;
            if(peekNode.next != null){
                queue.add(peekNode.next);
            }
        }
        return res.next;
    }
}
