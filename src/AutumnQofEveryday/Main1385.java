package AutumnQofEveryday;

/**
 * 1385. 两个数组间的距离值
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * @author Junho
 * @date 2022/9/16 13:07
 */
public class Main1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for(int i = 0 ; i < arr1.length ; i++ ){
            int f = 0;
            for(int j = 0 ; j < arr2.length ; j++){
                if(Math.abs(arr1[i] - arr2[j]) > d){
                    f += 1;
                }
            }
            if(f == arr2.length){
                res += 1;
            }
        }
        return res;
    }
}
