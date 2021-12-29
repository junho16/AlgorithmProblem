package max;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Main5 {
    public String longestPalindrome(String s) {
        int l = 0; int r = 0;
        String res = "";
        for(int i = 0; i < s.length() ;i++){
            l = i - 1 ;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if(res.length() < r - l -1){
                res = s.substring(l + 1, r);
            }
            l = i ; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if(res.length() < r - l - 1){
                res = s.substring(l + 1 , r );
            }
        }
        return res;
    }
}
