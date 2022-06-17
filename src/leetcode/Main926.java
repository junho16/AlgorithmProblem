package leetcode;

/**
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 *
 * @author Junho
 * @date 2022/6/16 10:59
 */
public class Main926 {
    public static void main(String[] args) {
         minFlipsMonoIncr("00110");
    }
    public static int minFlipsMonoIncr(String s) {
        //从前往后 前缀和
        int[] sumPre = new int[s.length()];

        int sum = 0;
        sum += (s.charAt(0) - '0');
        sumPre[0] = s.charAt(0) - '0';
        for(int i = 1 ; i < s.length() ; i++){
            sum += (s.charAt(i) - '0');
            sumPre[i] = sumPre[i - 1] + s.charAt(i) - '0';
        }
        int res = s.length();
        for(int i = 0 ; i < s.length() ; i++){
            int num_1 = sumPre[i] - (s.charAt(i) - '0');
            int num_0 = s.length() - i - 1 - (sumPre[s.length()-1] - sumPre[i]);
            res = Math.min(res , num_0 + num_1);
        }
        return res;
//        System.out.println(s.length() +" " + sumPre.length);
//        for(int i = 0 ; i < s.length() ; i++){
//            System.out.print(sumPre[i] +" ");
//        }
    }
}
