package leetcode;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 * @author Junho
 * @date 2022/5/31 15:29
 */
public class Main611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                int left = j + 1;
                int right = nums.length - 1;
                int start = j;
                while (left < right && left < nums.length && right < nums.length){
                    int mid = (left + right + 1) >> 1;
                    //找的是最后一个大于等于a+b的位置
                    if(nums[mid] < nums[i] + nums[j]){
                        left = mid;
                    }else{
                        right = mid - 1;
                    }
                }
                // System.out.println( nums[i] + " "+  nums[j] + " " + left +" " + right + " " + start);

                if(left == right && nums[left] <  nums[i] + nums[j]){
                    res += (left - start);
                }
            }
        }
        return res;
    }
}
