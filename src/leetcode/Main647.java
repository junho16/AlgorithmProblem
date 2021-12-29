package leetcode;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Main647 {
    /**
     * 什么叫做一遍过呀？？谁告诉我一下？什么叫？什么叫一遍就过了？？？啊？你耳朵聋了？说啊！对没错，这就是一遍过！
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            int l = i - 1 ;
            int r = i + 1 ;
            while ( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                res++;
            }
            l = i;
            r = i + 1;
            while ( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }
        return res+s.length();
    }
    /**
     * 纯暴力也能过 好家伙 不过是超过了百分之五的人， 鬼鬼 那剩下的百分之五是傻子吧？
     * @param s
     * @return
     */
    public int countSubstrings_2(String s) {
        int res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ;j < s.length() ; j++){
                StringBuilder str = new StringBuilder(s.substring(i,j));
                if(str.toString().equals(str.reverse().toString()))
                    res++;
            }
        }
        return res;
    }
}
