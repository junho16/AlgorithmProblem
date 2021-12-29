package max;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
142. 环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改 链表。
 */
public class Main142 {
    public ListNode detectCycle(ListNode head) {

        ListNode head_1 = head;
        ListNode head_2 = head;

        while(head_1 != null && head_2 != null){
            head_1 = head_1.next;
            head_2 = head_2.next.next;
            if(head_1 == head_2){
                //寻找一下第一个出现的节点（i走过的）
                ListNode headTmp = head;
                while (head_1 != headTmp){
                    headTmp = headTmp.next;
                    head_1 = head_1.next;
                }
                return headTmp;
            }
        }
        return null;
    }
}
