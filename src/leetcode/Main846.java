package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个简单的模拟吧算是 并没有用什么算法额
 * 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 */
public class Main846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int sizeArrLen = 0;
        int[] sizeArr = new int[hand.length];
        Arrays.sort(hand);

        Map<Integer , Integer> hashmap = new HashMap();
        for(int i = 0 ; i < hand.length ; i++ ){
            hashmap.put(hand[i] , hashmap.getOrDefault(hand[i] , 0) + 1 );
        }

        int str = 0;
        while (str < hand.length){
            int k = str;
            while (k < hand.length - 1 && hand[k] == hand[k+1]){
                k++;
            }
//            sizeArr[sizeArrLen++] = k - str + 1;
            sizeArr[sizeArrLen++] = hand[str];
            str = k + 1 ;
        }
        // for(int i = 0 ;i < sizeArr.length ; i++){
        //     System.out.print( sizeArr[i] + " ");
        // }
        // for(Map.Entry entry : hashmap.entrySet()){
        //     System.out.println(entry.getKey()+" " +entry.getValue());
        // }
        int idx = 0;
        while (idx < sizeArrLen && hashmap.get(sizeArr[idx]) != 0){
            for(int i = 0 ; i < groupSize ; i++ ){
                if(!hashmap.containsKey(sizeArr[idx] + i) || hashmap.get(sizeArr[idx] + i) == 0) {
                    return false;
                }else{
                    hashmap.put(sizeArr[idx] + i , hashmap.get(sizeArr[idx] + i) - 1);
                }
            }
            System.out.println();
            // System.out.print(idx +" " +sizeArr[idx] );
            // for(Map.Entry entry : hashmap.entrySet()){
            //     System.out.println(entry.getKey()+" " +entry.getValue());
            // }
            // System.out.println("=============");
            while (idx < sizeArrLen && hashmap.get(sizeArr[idx]) == 0){
                idx++;
            }

        }
        return true;
    }
}
