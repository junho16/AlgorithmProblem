package leetcode;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Main704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < target)
                l = mid + 1 ;
            else
                r = mid;
        }
        if(nums[r] == target)
            return r;
        return -1;

    }
}
