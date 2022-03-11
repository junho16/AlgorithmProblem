package lc_2_Interview;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Main21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            head = head.next;
        }
        if (list1 != null){
            head.next = list1;
        }
        if (list2 != null){
            head.next = list2;
        }
        return dummy.next;
    }
}
