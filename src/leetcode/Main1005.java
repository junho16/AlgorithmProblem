package leetcode;

import java.util.Arrays;

/**]
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class Main1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums , 0 , nums.length);
        int minNum = Integer.MAX_VALUE;
        int minIdx = 0;
        boolean isZero = false;
        int fuNum = 0;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] == 0){
                isZero = true;
            }else{
                if(Math.abs(nums[i]) < minNum ){
                    minNum = Math.abs(nums[i]);
                    minIdx = i;
                }
            }
            if(nums[i] < 0)
                fuNum++;
        }

        System.out.println();
        System.out.println(fuNum);
        System.out.println(isZero);
        System.out.println(minNum);
        System.out.println(minIdx);
        System.out.println();
        if(fuNum >= k){
            for(int i = 0; i < k ;i++) {
                nums[i] = -nums[i];
                System.out.println( " 1");
            }
        }else{
            //大于k 则进行是否有0和k的奇偶性判断
            if(isZero){
                for(int i = 0 ; i < nums.length ; i++){
                    if(nums[i] > 0)
                        break;
                    else{
                        nums[i] = -nums[i];
                    }
                    System.out.println( " 2");
                }
            }else{
                //如果没有0--》如果是偶数则不变 如果是奇数则加上最小的
                if((k-fuNum) % 2 == 1){
                    for(int i = 0 ; i < nums.length ; i++){
                        if(nums[i] > 0){
                            break;
                        } else{
                            nums[i] = -nums[i];
                        }
                        System.out.println( " 3");
                    }
                    nums[minIdx] = -nums[minIdx];
                }else{
                    for(int i = 0 ; i < nums.length ; i++){
                        if(nums[i] > 0)
                            break;
                        else{
                            nums[i] = -nums[i];
                        }
                        System.out.println( " 4");
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            // System.out.print(nums[i]+" ");
            res += nums[i];
        }
        return res;
    }
}
