package offer2;

/**
 *剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * @author Junho
 * @date 2022/6/21 17:08
 */
public class Main004 {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for(int i = 0 ; i < nums.length ; i++){
            int it = nums[i];
            int idx = 0;
            while (it != 0){
                arr[idx] += (it & 1);
                arr[idx++] %= 3;
                it >>>= 1;
            }
        }
        int res = 0 ;
        for(int i = 0 ; i < 32 ; i++){
            res <<= 1;
            res |= arr[31 - i];
        }
        return res;
//        注意 下m面用Math.pow(2 , 31 - i)的方式不行 因为 出现负数就不行了 因此用或操作比较好
////        int res = 0;
//        String str = "";
//        for(int i = arr.length - 1 ; i >= 0 ; i--){
//            str += arr[i];
////            res += Math.pow(2 , 31 - i) * arr[i];
//        }
//        return Integer.valueOf(str , 10);
////        return res;
    }
}
