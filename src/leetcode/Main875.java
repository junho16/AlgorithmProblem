package leetcode;

/**
 * 这个 之前周赛（第三题） 做过 二分
 *
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *
 * @author Junho
 * @date 2022/6/7 19:34
 */
public class Main875 {
    int[] p;
    int limit;
    public int minEatingSpeed(int[] piles, int h) {
        limit = h;
        p = piles;
        int l = 1 , r = 0;
        for(int i = 0 ; i < piles.length ; i++){
            r = Math.max(r , piles[i]);
        }
        while (l < r){
            int mid = l + r >> 1 ;
            if(check(mid)){
                //mid 可以满足
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
    boolean check(int n){
        int sum = 0;
        for(int i = 0 ;i < p.length ;i++){
            if(p[i] <= n){
                sum += 1;
            }else{
                sum += p[i] % n == 0 ? p[i] / n : p[i] / n + 1 ;
            }
        }
        return sum <= limit;
    }
}
