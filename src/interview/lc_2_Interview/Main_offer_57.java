package interview.lc_2_Interview;

import java.util.ArrayList;

/**
 * 滑动窗口
 *
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Main_offer_57 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> reslist = new ArrayList();
        for(int i = 1 , j = 1 , cnt = 0; i < target ; i++){
            cnt += i;
            while (cnt > target){
                cnt -= j;
                j++;
            }
            // System.out.println(cnt );
            if(cnt == target && i != j){
                //    System.out.println(j + " " + i );
                int[] tmp = new int[i - j + 1];
                int index = 0;
                for(int k = j ; k <= i ; k++ ){
                    tmp[index++] = k;
                }
                reslist.add(tmp);
            }
        }
        int[][] res = new int[reslist.size()][];
        for(int k = 0 ; k < reslist.size() ; k++){
            res[k] = reslist.get(k);
        }
        return res;
    }
}
