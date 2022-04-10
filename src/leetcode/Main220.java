package leetcode;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * @author Junho
 * @date 2022/4/9 14:44
 */
public class Main220 {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(
                new int[]{-2147483648,2147483647} , 1, 1
        ));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length ; i++){
            Long u = nums[i] * 1L;
            Long minBigThanU = treeSet.ceiling(u);
            Long maxSmallThanU = treeSet.floor(u);
            if(minBigThanU != null && minBigThanU - u <= t ){
                return true;
            }
            if(maxSmallThanU != null && u - maxSmallThanU <= t){
                return true;
            }
            treeSet.add(u);
            if(i >= k){
                treeSet.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }


//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
////        u - t  :  u + t
//        int n = nums.length;
//        TreeSet<Long> ts = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            Long u = nums[i] * 1L;
//            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
//            Long l = ts.floor(u);
//            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
//            Long r = ts.ceiling(u);
//            if(l != null && u - l <= t) return true;
//            if(r != null && r - u <= t) return true;
//            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
//            ts.add(u);
//            if (i >= k) ts.remove(nums[i - k] * 1L);
//        }
//        return false;
//    }


//    暴力稳超时
//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for(long i = 0; i < nums.length ;i++ ){
//            for(long j = i + 1 ; j < nums.length ; j++ ){
//                System.out.println(nums[(int)i]);
//                System.out.println(nums[(int)j]);
//                System.out.println(Math.abs((long)nums[(int)i] - (long)nums[(int)j]));
//                if(Math.abs((long)nums[(int)i] - (long)nums[(int)j]) <= t && Math.abs(i - j) <= k)
//                    return true;
//            }
//        }
//        return false;
//    }
}
