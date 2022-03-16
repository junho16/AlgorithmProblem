package lc_2_Interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Main31 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(i - 1 >=0 && nums[i - 1] < nums[i]){
                int index = i - 1;
                int minNum = Integer.MAX_VALUE;
                for(int j = i - 1 ; j < nums.length ; j++){
                    if(nums[j] > nums[i - 1] && nums[j] < minNum){
                        index = j;
                        minNum = nums[j];
                    }
                }
                int tmp = nums[i - 1];
                nums[i - 1] = nums[index];
                nums[index] = tmp;
                // for(int s = 0 ; s < nums.length ; s++ )
                //     System.out.print(nums[s] + " ");
                Arrays.sort(nums , i, nums.length);
                return;
            }
        }
        for(int l = 0 , r = nums.length - 1 ; l <= r ; l++ , r--){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}