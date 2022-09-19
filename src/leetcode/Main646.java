package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * @author Junho
 * @date 2022/9/17 20:23
 */
public class Main646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[1];
                }
            }
        });
        int cnt = 0;
        for(int i = 0 ; i < pairs.length - 1 ; i++){
            if(pairs[i][1] < pairs[i + 1][0]){
                cnt++;
            }
            if(i == pairs.length - 1 && pairs[i][1] < pairs[i + 1][0]){
                cnt++;
            }
        }
        return cnt;


    }
}
