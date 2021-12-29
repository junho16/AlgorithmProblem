package leetcode;

import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class Main234 {

    public boolean isPalindrome(ListNode h) {
        int length = 0;
        ListNode head = h;
        while(head != null){
            length++;
            head = head.next;
        }
        head = h;
        for(int i = 0; i < ((length + 1 )/ 2) - 1  ;i++ ){
            head = head.next;
        }

        //========================

        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        // ListNode a = h;
        // for(int i = 0 ; i < length/2 ;i++){
        //     System.out.print(a.val+" ");
        //     a = a.next;
        // }
        // System.out.println();
        // ListNode aa = pre;
        // for(int i = 0 ; i < length/2 ;i++){
        //     System.out.print(aa.val+" ");
        //     aa = aa.next;
        // }

        ListNode headFirst = h;
        ListNode headLast = pre;
        for(int i = 0 ; i < length/2 ;i++){
            if(headFirst.val != headLast.val)
                return false;
            headFirst = headFirst.next;
            headLast = headLast.next;
        }
        return true;
    }
    /**
     * 当然以下的做法是不可以的
     * @param head
     * @return
     */
    public boolean isPalindromes(ListNode head) {
        int[] nums = new int[100005];
        int idx = 0;
        while (head != null) {
            nums[idx++] = head.val;
            head = head.next;
        }
        int l = 0 , r = idx-1;
        while(l < r){
            if(nums[l] == nums[r]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
