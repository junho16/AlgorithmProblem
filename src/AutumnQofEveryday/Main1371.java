package AutumnQofEveryday;

import java.util.Arrays;

/**
 * @author Junho
 * @date 2022/9/15 19:50
 */
public class Main1371 {
    public int findTheLongestSubstring(String s) {
        // 记录下32种状态分别出现的最早的位置
        int[] dist = new int[32];
        Arrays.fill(dist , Integer.MAX_VALUE);
//        因为状态0确实出现在下标为-1的位置处, 如果也设置为INT_MAX, 那第1次运算到pre[0]时就不是第1次出现状态0, 而是第2次出现状态0了
//        因为这里的pre其实是类似c++反向迭代器的end，表示一个左开右闭区间的左端点。状态0的特殊点在于空串的状态也是0，对应的它的rend就应该是0-1=-1。
        dist[0] = -1;
        int cur = 0;
        int res = 0 ;
        for(int i = 0; i < s.length() ; i++){
            switch (s.charAt(i)){
                case 'a':{
                    cur ^= 1;
                    break;
                }
                case 'e':{
                    cur ^= 2;
                    break;
                }
                case 'i':{
                    cur ^= 4;
                    break;
                }
                case 'o':{
                    cur ^= 8;
                    break;
                }
                case 'u':{
                    cur ^= 16;
                    break;
                }
            }
            if(dist[cur] == Integer.MAX_VALUE){
                // 第一次出现这种状态的位置 记录下来
                dist[cur] = i;
            }else{
                res = Math.max(res , i - dist[cur]);
            }
        }
        return res;
    }
}
