package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 */
public class Main397 {
    public Map<Long,Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }
    int dfs(long n){
        if(n == 1)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        int res = n % 2 == 0 ?
                dfs(n / 2) :
                Math.min(dfs(n + 1 ) , dfs( n - 1 ));
        map.put(n , res);
        return res + 1;
    }
}
