package weekGame.week_3_27;

/**
 * 5253. 找到指定长度的回文数
 * 给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
 *
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 *
 * @author Junho
 * @date 2022/3/27 14:47
 */
public class Main5253 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int base = intLength % 2 == 0 ? intLength / 2 : intLength / 2 + 1;
        base = (int) Math.pow(10 , base - 1);
        long[] res = new long[queries.length];
        for(int i = 0 ;i < queries.length ; i++){
            long p = queries[i];
            if(p > 9 * Math.pow(10 , (intLength-1)  / 2 )){
                res[i] = -1;
                continue;
            }
            String num = base + p - 1 + "";
            if(intLength  % 2 == 0 ){
                StringBuilder sb = new StringBuilder(num);
                res[i] = Long.parseLong(num + sb.reverse().toString());
            }else{
                StringBuilder sb = new StringBuilder(num.substring(0 , num.length() - 1));
                res[i] = Long.parseLong( num + sb.reverse().toString() );
            }
        }
        return res;
    }
}


//    public long[] kthPalindrome(int[] queries, int intLength) {
//        int n = queries.length;
//        long min = (long)Math.pow(10, (intLength - 2 + 1)/2);
//        long max = (long)Math.pow(10, (intLength + 1)/2) - 1;
//        long[] ans = new long[n];
//        for (int i = 0; i <  n; i++){
//            int q = queries[i];
//            if ((long)q > (long)9*Math.pow(10, (intLength-1)/2)){
//                ans[i] = -1;
//                continue;
//            }
//            long cur  = q - 1 + min;
//            String str = String.valueOf(cur);
//            if (intLength % 2 == 0){
//                StringBuilder sb = new StringBuilder(str);
//                str += sb.reverse().toString();
//            }
//            else{
//                StringBuilder sb = new StringBuilder(str);
//                str += sb.reverse().toString().substring(1);
//            }
//            ans[i] = Long.parseLong(str);
//        }
//        return ans;
//    }