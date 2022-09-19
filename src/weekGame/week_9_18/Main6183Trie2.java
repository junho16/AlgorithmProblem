package weekGame.week_9_18;

import java.util.Arrays;

/**
 * 过了的
 * @author Junho
 * @date 2022/9/18 14:35
 */
public class Main6183Trie2 {
    private static final int N = 1001000;
    public static int[] cnt;
    public static int[][] son;
    public static int idx;

    public static void insert(String str){
        int p = 0;
        for(int i = 0 ; i < str.length(); i++){
            int u = str.charAt(i) - 'a';
            if( son[p][u] == 0 ){
                son[p][u] = ++idx;
                Arrays.fill(son[idx] , 0);
                cnt[idx] = 0;
            }
            p = son[p][u];
            cnt[p]++;
        }
    }
    public static int query(String str){
        int sum = 0 ;
        int p = 0;
        for(int i = 0 ;i < str.length() ;i++){
            int u = str.charAt(i) - 'a';
            if(son[p][u] != 0){
                sum += cnt[son[p][u]];
            }else{
                return sum;
            }
            p = son[p][u];
        }
        return sum;
    }
    public int[] sumPrefixScores(String[] words) {
//        cnt = new int[N];
//        son = new int[N][26];
        Arrays.fill(son[0] , 0);
        idx = 0;

        for(int i = 0 ;i < words.length ; i++){
            insert(words[i]);
        }
        int[] res = new int[words.length];
        for(int i = 0 ;i < words.length ; i++){
            res[i] = query(words[i]);
        }
        return res;
    }
}
