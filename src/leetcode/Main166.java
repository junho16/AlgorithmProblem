package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 */
public class Main166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        String res = "";
        long reStrIdx = 0;
        //余数和其出现的起始位置
        Map<Long , Long> map = new HashMap();


        boolean isfu = false;
        if((num < 0 && den > 0) || (num > 0 && den < 0)){
            isfu = true;
        }
        System.out.println(isfu);
        num = Math.abs(num);
        den = Math.abs(den);

        res += num/den;
        long yushu = num % den;
        if(yushu != 0)
            res+=".";

        while (yushu != 0){
            map.put(yushu , (long)res.length());
//            yushu *= 10;
            num = yushu * 10;
            res += num / den;
            yushu = num % den;
            if(map.containsKey(yushu)){
                reStrIdx =  map.get(yushu);
                break;
            }
        }
        System.out.println(res);
        if(reStrIdx == 0){
            return isfu ? "-"+res : res;
        }else{
            String xunhuan = res.substring((int) reStrIdx, res.length());
            res = res.substring(0 , (int) reStrIdx);
            res += "("+xunhuan+")";
            return isfu ? "-"+res : res;
        }
        // System.out.println(res);

    }
}
