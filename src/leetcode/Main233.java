package leetcode;

/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *
 * @author Junho
 * @date 2022/3/22 9:42
 */
public class Main233 {
    //这种暴力那必然是过不了所有数据的
    public int countDigitOne(int n) {
        int res = 0;
        for(int i = 1 ; i <= n ; i++ ){
            String s = i + "";
            for(int j = 0 ; j < s.length() ; j++){
                if(s.charAt(j) == '0')
                    res++;
            }
        }
        return res;
    }
}
