package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划 -- 双重循环去判断 某一个字符是自己大 还是以某个其他字符在它前面 + 1大
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Main300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(res.size() == 0 || res.get(res.size()-1) < nums[i]){
                res.add(nums[i]);
            }else{
                if(nums[i] <= res.get(0)){
                    res.set(0 , nums[i]);
                }else{
                    int l = 0;
                    int r = res.size() - 1;
                    while(l < r){
                        int mid = l + r + 1 >> 1;

                        if(res.get(mid) >= nums[i]){
                            r = mid - 1;
                        }else{
                            l = mid;
                        }
                    }
                    // System.out.println(res.get(l));
                    // if(l + 1 < res.size() )
                    res.set(l + 1 , nums[i]);
                }
            }
        }
        return res.size();
//        下面的dp是比较一般的dp，其时间复杂度为n方,上面是优化过的，dp+二分，时间复杂度为nlogn
//        int[] f = new int[nums.length];
//        Arrays.fill(f , 1);
//        int res = 0;
//        for(int i = 0 ; i < nums.length ; i++ ){
//            for(int j = 0 ; j < i ; j++){
//                if(nums[j] < nums[i]){
//                    f[i] = Math.max(f[i] , f[j] + 1);
//                }
//            }
//            res = Math.max(res , f[i]);
//        }
//        return res;

//        下等dp，再写一遍
//        int[] f = new int[nums.length];
//        Arrays.fill(f , 1);
//        for(int i = 0 ; i < nums.length ; i++ ){
//            for(int j = 0 ; j < i ;j++){
//                if(nums[j] < nums[i]){
//                    f[i] = Math.max(f[j] + 1 , f[i] );
//                }
//            }
//        }
//        int res = 1;
//        for (int i = 0 ; i < f.length ;i++ ){
//            res = Math.max(res , f[i]);
//        }
//        return res;
    }
}
