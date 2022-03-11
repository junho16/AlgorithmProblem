package lc_2_Interview;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class Main33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = l + r + 1 >> 1 ;
            if(nums[mid] < nums[0]){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        System.out.println(l+ " " +r);
        if(target < nums[0]){
            l = l + 1;
            r = nums.length - 1;
        }else{
            l = 0;
        }
        while (l < r){
            int mid = l + r >> 1 ;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(l >= 0  && l < nums.length)
            return nums[l] == target ? l : -1;
        else
            return -1;
    }
}
