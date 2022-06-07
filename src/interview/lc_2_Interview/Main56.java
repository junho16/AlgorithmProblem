package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Main56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> resArr = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ;i++){
            if(resArr.size() == 0){
                resArr.add(intervals[i]);
            }else{
                if(resArr.get(resArr.size() - 1)[1] >= intervals[i][0]
                        && resArr.get(resArr.size() - 1)[1] <= intervals[i][1] ){
                    resArr.get(resArr.size() - 1)[1] = intervals[i][1];
                }else if(resArr.get(resArr.size() - 1)[1] < intervals[i][0]){
                    resArr.add(intervals[i]);
                }
            }
        }
        int[][] res = new int[resArr.size()][2];
        for(int i = 0 ; i < resArr.size() ; i++ ){
            res[i] = resArr.get(i);
            // System.out.println(resArr.get(i)[0] + " " + resArr.get(i)[1]);
        }
        return res;
    }
}
