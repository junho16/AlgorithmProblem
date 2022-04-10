package leetcode;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 * @author Junho
 * @date 2022/4/9 13:47
 */
public class Main258 {
    public int addDigits(int num) {
        int res = 0;
        boolean flag = true;
        while (flag){
            int sum = 0;
            String ns = num+"";
            for(int i = 0; i < ns.length() ; i++){
                sum += Integer.parseInt(ns.charAt(i)+"");
            }
            if(sum < 10){
                flag = false;
                res = sum;
            }else{
                num = sum;
            }
        }
        return res;
    }
}
