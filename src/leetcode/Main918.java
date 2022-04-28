package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 918. 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 * @author Junho
 * @date 2022/4/22 10:59
 */
public class Main918 {


    /**
     * ==》数组总和 减去 子数组最小和 == 子数组最大和
     *  sum:数组和
     *  resMax：当前子数组和的最大值
     *  resMin：子数组和的最小值
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
        }
        int lastMax = nums[0] , lastMin = nums[0];
        int resMax = nums[0] , resMin = nums[0];
        // int resMax = 0 , resMin = 0;
        for(int i = 1 ; i < nums.length ; i++){
            lastMax = nums[i] + Math.max(0 , lastMax);
            resMax = Math.max(resMax , lastMax);
            lastMin = nums[i] + Math.min(0 , lastMin);
            resMin = Math.min(resMin , lastMin);
        }
        // System.out.println(resMax+" "+resMin + " "+ sum);

        return resMax <= 0 ? resMax : Math.max(resMax , sum - resMin);

    }

//    我直接就笑了 集合超时比数组严重多了hhhh
//    public int maxSubarraySumCircular(int[] nums) {
//        LinkedList<Integer> list = new LinkedList();
//        int res = Integer.MIN_VALUE;
//        for(int i = 0 ; i < nums.length ; i++){
//            list.addLast(nums[i]);
//        }
//        for(int i = 0 ;i < nums.length ; i++){
//            list.addLast(list.removeFirst());
//            int tmpRes = Integer.MIN_VALUE;
//            for(int last = 0, ii = 0; ii < list.size() ; ii++){
//                last = list.get(ii) + Math.max( 0 , last);
//                tmpRes = Math.max(tmpRes , last);
//            }
//            res = Math.max(res , tmpRes);
//        }
//        return res;
//    }

//    //超出时间限制
//    public int maxSubarraySumCircular(int[] nums) {
//        int[] tmp;
//        int res = Integer.MIN_VALUE;
//        for(int i = 0 ; i < nums.length ; i++){
//            tmp = new int[nums.length];
//            int idx = 0;
//            for(int j = i ; j < nums.length ; j++){
//                tmp[idx++] = nums[j];
//            }
//            for(int j = 0 ; j < i ; j++){
//                tmp[idx++] = nums[j];
//            }
//            int tmpRes = Integer.MIN_VALUE;
//            for(int last = 0, ii = 0; ii < tmp.length ; ii++){
//                last = tmp[ii] + Math.max( 0 , last);
//                tmpRes = Math.max(tmpRes , last);
//            }
//            res = Math.max(res , tmpRes);
//        }
//        return res;
//    }

//    超出内存限制。。。
//    public int maxSubarraySumCircular(int[] nums) {
//        List<int[]> list = new ArrayList<>();
//        for(int i = 0 ; i < nums.length ; i++){
//            int[] tmp = new int[nums.length];
//            int idx = 0;
//            for(int j = i ; j < nums.length ; j++){
//                tmp[idx++] = nums[j];
//            }
//            for(int j = 0 ; j < i ; j++){
//                tmp[idx++] = nums[j];
//            }
//            list.add(tmp);
//        }
//        int res = Integer.MIN_VALUE;
//        // for(int[] arr : list){
//        //     for(int i : arr){
//        //         System.out.print( i + " ");
//        //     }
//        //     System.out.println();
//        // }
//        for(int[] arr : list){
//            int tmp = Integer.MIN_VALUE;
//            for(int last = 0, i = 0; i < arr.length ; i++){
//                last = arr[i] + Math.max( 0 , last);
//                tmp = Math.max(tmp , last);
//            }
//            res = Math.max(res , tmp);
//            // System.out.print(res+" :");
//            // for(int s : arr){
//            //     System.out.print( s + " ");
//            // }
//            // System.out.println();
//
////            for(int i : arr){
////                System.out.print( i + " ");
////            }
////            System.out.println();
//        }
//        return res;
//    }
}
