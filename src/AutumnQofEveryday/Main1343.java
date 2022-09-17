package AutumnQofEveryday;
/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 *
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * 固定的滑动窗口 sum值（或者双指针）
 * @author Junho
 * @date 2022/9/14 15:47
 */
public class Main1343 {

    //优雅
    public int numOfSubarrays_1(int[] a, int k, int threshold) {
        int res = 0;
        for (int i = 0, j = 0, s = 0; i < a.length; i ++ ) {
            s += a[i];
            if (i - j >= k) s -= a[j ++ ];
            if (i - j + 1 == k && s >= k * threshold) res ++ ;
        }
        return res;
    }


    // 土办法
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        for(int l = 0 , r = 0 , cnt = 0 , sum = 0  ; r < arr.length ; r++){
            if(cnt < k){
                //小于k个
                sum += arr[r];
                cnt++;
                if(k == cnt && sum >= k * threshold){
                    res++;
                }
            }else{
                //>=k 个
                sum += arr[r];
                sum -= arr[l++];
                if(sum >= k * threshold){
                    res++;
                }
            }
        }
        return res;
    }
}
