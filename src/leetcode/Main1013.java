package leetcode;

/**
 * 这个故事告诉我们不要多想 直接暴力就好
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 */
public class Main1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0 ;
        for(int i = 0 ; i < arr.length ;i++){
            sum += arr[i];
        }
        if(sum % 3 != 0)
            return false;

        int num1idx = -1;
        for(int i = 0 , cnt = 0; i < arr.length - 2 ;i++ ){
            cnt += arr[i];
            if(cnt == sum/3){
                num1idx = i;
                break;
            }
        }
        if(num1idx == -1)
            return false;

        int num2idx = -1;
        for(int i = num1idx + 1 , cnt = 0; i < arr.length - 1 ;i++ ){
            cnt += arr[i];
            if(cnt == sum/3){
                num2idx = i;
                break;
            }
        }
        if(num2idx == -1)
            return false;

        int cnt = 0;
        for(int i = num2idx + 1 ; i < arr.length   ;i++ ){
            cnt += arr[i];
        }
        return cnt == sum/3;

//        int l = 0 , r = arr.length - 1;
//        int lSum = 0;
//        int rSum = 0;
//        while (l + 1 < r ){
//            if(lSum + arr[l] <= sum/3){
//                lSum += arr[l++];
//            }
//            if(rSum + arr[r] <= sum/3){
//                rSum += arr[r--];
//            }
//            if(lSum == sum/3 && rSum == sum/3){
//                return true;
//            }
//        }
//        return false;
    }
}
