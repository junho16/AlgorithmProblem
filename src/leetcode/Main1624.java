package leetcode;

/**
 * @author Junho
 * @date 2022/9/17 9:26
 */
public class Main1624 {
    public static void main(String[] args) {
        maxLengthBetweenEqualCharacters("cbzxy");
    }
    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        for(int i = 0 ; i < 26; i++){
            first[i] = s.indexOf('a' + i);
        }
        int[] last = new int[26];
        String srev = new StringBuilder(s).reverse().toString();
        for(int i = 0 ; i < 26; i++){
            last[i] = srev.indexOf('a' + i) == -1 ? -1 : s.length() - srev.indexOf('a' + i) - 1;
        }
        int res = -1;
        for(int i = 0 ; i < 26 ; i++){
            if((first[i] != -1 && last[i] != -1) && (first[i] != last[i])){
                res = Math.max(res , last[i] - first[i] - 1);
            }
        }
        return res;
    }
}
