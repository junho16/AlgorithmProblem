package interview.zj_youth;

/**
 * 【编程题】实现一个 36 进制的加法 0-9 a-z。
 * 输入样例 1
 * 1113 24
 * abbbb 1
 * 输出样例 1
 *
 * abbbc
 *
 * @author Junho
 * @date 2022/4/24 16:04
 */
public class Main_1 {
    public static void main(String[] args) {

        System.out.println(add("abbbb", "1"));

        System.out.println(add("abbbc", "a"));

    }
    static String add(String a, String b) {
        String map = "0123456789abcdefghijklmnopqrstuvwxyz";

        int idx_a = a.length() - 1;
        int idx_b = b.length() - 1;
        String res = "";
        int jw = 0;
        while (idx_a >= 0 && idx_b >=0){
            int an = map.indexOf(a.charAt(idx_a));
            int bn = map.indexOf(b.charAt(idx_b));
            res += map.charAt((jw + an + bn) % 36);
            jw = (jw + an + bn) / 36;
            idx_a--;
            idx_b--;
        }
        while (idx_a >= 0 ){
            int an = map.indexOf(a.charAt(idx_a));
            res += map.charAt((jw + an) % 36);
            jw = (jw + an) / 36;
            idx_a--;
        }
        while (idx_b >= 0 ){
            int bn = map.indexOf(b.charAt(idx_b));
            res += map.charAt((jw + bn) % 36);
            jw = (jw + bn) / 36;
            idx_b--;
        }
        if(jw != 0){
            res += map.charAt(jw);
        }
        return new StringBuilder(res).reverse().toString();
    }
}
