package offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Main56_1 {
    public int[] singleNumbers(int[] nums) {
        int tmpSum = 0;
        for(int i = 0; i < nums.length ; i++){
            tmpSum ^= nums[i];
        }
        int k = 0 ;
        while ((tmpSum >> k & 1) == 0 ){
            k++;
        }
        int[] res = new int[2];
        int resNum1 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if((nums[i] >> k & 1)  != 0){
                resNum1 ^= nums[i];
            }
        }
        res[0] = resNum1;
        res[1] = tmpSum ^ resNum1;
        return res;
    }
}
