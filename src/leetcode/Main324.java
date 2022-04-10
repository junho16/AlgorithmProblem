package leetcode;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 * @author Junho
 * @date 2022/4/9 20:20
 */
public class Main324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums, 0 ,  nums.length);
        int[] nums_1;
        int[] nums_2;
        nums_1 = nums.length % 2 == 0 ?  new int[nums.length / 2] : new int[(nums.length / 2) + 1];
        nums_2 = new int[nums.length / 2] ;
        for(int j = 0 , idx = 0 ; j < nums_1.length ;   j++){
            nums_1[idx++] = nums[j];
        }
        for(int idx = 0 , j = nums_1.length  ; j < nums.length ; j++){
            nums_2[idx++] = nums[j];
        }

        // for(int i = 0 ; i < nums_1.length ; i++ ){
        //     System.out.print(nums_1[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0 ; i < nums_2.length ; i++ ){
        //     System.out.print(nums_2[i] + " ");
        // }

        int[] res = new int[nums.length];
        int i_idx = 0 ,  num_1_idx = nums_1.length - 1 , num_2_idx = nums_2.length -1 ;
        for( ; i_idx < nums.length && num_1_idx >=0  && num_2_idx >=0 ; i_idx++){
            if(i_idx % 2 == 0 ){
                res[i_idx] = nums_1[num_1_idx--];
            }else{
                res[i_idx] = nums_2[num_2_idx--];
            }
        }
        while(num_1_idx >=0 ){
            res[i_idx++] = nums_1[num_1_idx--];
        }
        while(num_2_idx >= 0 ){
            res[i_idx++] = nums_2[num_2_idx--];
        }
        for(int i = 0 ; i < res.length ; i++ ){
            nums[i] = res[i];
            // System.out.print(nums[i] + " ");
        }
    }
}
