package leetcode;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * @author Junho
 * @date 2022/6/15 19:21
 */
public class Main540 {
    int[] nums;
    public int singleNonDuplicate(int[] nums_) {
        nums = nums_;
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 1){
            return nums[0];
        }
        while (left < right){
            int mid = left + right >> 1;
            if(check(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
    public boolean check(int mid) {
        if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 &&  nums[mid] == nums[mid + 1]) ){
            return true;
        }else{
            return false;
        }
    }
//    下面的太丑了
//    int[] nums;
//    public int singleNonDuplicate(int[] nums_) {
//
//        nums = nums_;
//        int left = 0;
//        int right = nums.length - 1;
//        if(nums.length == 1){
//            return nums[0];
//        }
////        if(nums[0] != nums[nums.length - 1]){
////            return nums[0];
////        }
////        if(nums[nums.length - 2] != nums[nums.length - 1]){
////            return nums[nums.length - 1];
////        }
//        while (left < right){
//            int mid = left + right >> 1;
//            if(mid == 0 && nums[0] != nums[1]){
//                return nums[0];
//            }
//            if(mid == nums.length - 1 && nums[nums.length - 1] != nums[nums.length - 2]){
//                return nums[nums.length - 1];
//            }
//            if(check(mid)){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//        return nums[left];
//    }
//    public boolean check(int mid) {
////        if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 &&  nums[mid] == nums[mid + 1]) ){
////            return true;
////        }else{
////            return false;
////        }
//        if (mid > 0 && mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
//            return true;
//        } else if (mid < nums.length - 1 && mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
//            return true;
//        }
//
//        if (mid > 0 && mid % 2 == 1 && nums[mid] == nums[mid + 1]) {
//            return false;
//        } else if (mid < nums.length - 1 && mid % 2 == 0 && nums[mid] == nums[mid - 1]) {
//            return false;
//        }
//        return false;
//    }
}
