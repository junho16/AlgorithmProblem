package weekGame.week_3_13;

import java.util.HashMap;
import java.util.Map;

/**
 * 5203. 统计可以提取的工件
 * 存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，其中 artifacts[i] = [r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
 *
 * (r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
 * (r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
 * 你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
 *
 * 给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
 *
 * 生成的测试用例满足：
 *
 * 不存在重叠的两个工件。
 * 每个工件最多只覆盖 4 个单元格。
 * dig 中的元素互不相同。
 */
public class Main5203 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        //用来存放地图的，把每一个格子对应的第几块对应起来
        Map<String, Integer> tableMap = new HashMap();
        Map<Integer, Integer> count = new HashMap<>();
//        int[] count = new int[n];
        for (int i = 0; i < artifacts.length; i++) {
            int r1 = artifacts[i][0];
            int c1 = artifacts[i][1];
            int r2 = artifacts[i][2];
            int c2 = artifacts[i][3];
//            count[i] = (c2-c1) * (r2 - r1);
            count.put(i, (c2 - c1 + 1) * (r2 - r1 + 1));
            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    tableMap.put(r + " " + c, i);
//                    count.put(i , count.getOrDefault(i , 0) +1);
                }
            }
        }
        // for(String s : tableMap.keySet()){
        //     System.out.println(s+" "+tableMap.get(s));
        // }
        // System.out.println("==========");
        // for(Integer s : count.keySet()){
        //     System.out.println(s+" "+count.get(s));
        // }
        int res = 0;
        for (int i = 0; i < dig.length; i++) {
            if (tableMap.containsKey(dig[i][0] + " " + dig[i][1])) {
//                if(--count[tableMap.get(dig[i][0] + dig[i][1] + "")] == 0)
//                    res++;
                int num = count.get(tableMap.get(dig[i][0] + " " + dig[i][1]));
                num = num - 1;
                count.put(tableMap.get(dig[i][0] + " " + dig[i][1]), num);
                if (num == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}


//5
//        [[3,1,4,1],[1,1,2,2],[1,0,2,0],[4,3,4,4],[0,3,1,4],[2,3,3,4]]
//        [[0,0],[2,1],[2,0],[2,3],[4,3],[2,4],[4,1],[0,2],[4,0],[3,1],[1,2],[1,3],[3,2]]
