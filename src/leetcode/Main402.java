package leetcode;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class Main402 {
    public String removeKdigits(String num, int k) {
        String res = "";
        for(int i = 0 ; i < num.length() ;i++ ){
            while (k!= 0 && res.length() > 0 && num.charAt(i) < res.charAt(res.length()-1)){
                k--;
                res = res.substring(0, res.length()-1);
            }
            res += num.charAt(i);
        }
        if(k != 0){
            res = res.substring(0,res.length() - k );
        }
        System.out.println(res);
        if(res.equals("0") || res.equals(""))
            return "0";
        int i = 0;
        while(i < res.length() && res.charAt(i) == '0'){
            i++;
        }
        res = res.substring(i , res.length());
        if(res.equals("0") || res.equals(""))
            return "0";
        return res;

    }
}
