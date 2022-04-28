package leetcode;

import java.util.*;

/**
 * 两遍BFS跑一遍，求一下交集就好 （需要注意的点可能只有emm 某一个海的边缘要算进去
 *
 * 417. 太平洋大西洋水流问题
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 *
 * @author Junho
 * @date 2022/4/27 9:40
 */
public class Main417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[] fx_x = {0, 1, -1, 0};
        int[] fx_y = {1, 0, 0, -1};
        Set<String> set = new HashSet();

        //res_0 和 res_1 分别存放的是上半部分可以到海里的地方和下半部分可以到海里的地方
        List<List<Integer>> res_0 = new ArrayList<>();
        List<List<Integer>> res_1 = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> queue = new LinkedList();
        boolean[][] flag = new boolean[heights.length][heights[0].length];
        flag[0][0] = true;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(peek[0]);
            tmp.add(peek[1]);
            res_0.add(tmp);
            for (int i = 0; i < 4; i++) {
                int a = peek[0] + fx_x[i];
                int b = peek[1] + fx_y[i];
                if (
                        (
                                ((a == 0 && b >= 0 && b < heights[0].length) ||

                                        (b == 0 && a >= 0 && a < heights.length)) && !flag[a][b]

                        ) || (
                                a >= 0 && b >= 0 && a < heights.length && b < heights[0].length && !flag[a][b] && heights[a][b] >= heights[peek[0]][peek[1]]
                        )
                ) {
                    queue.add(new int[]{a, b});
                    flag[a][b] = true;
                }
            }
        }

        queue = new LinkedList();
        flag = new boolean[heights.length][heights[0].length];
        flag[heights.length - 1][heights[0].length - 1] = true;
        queue.add(new int[]{heights.length - 1, heights[0].length - 1});
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(peek[0]);
            tmp.add(peek[1]);
            res_1.add(tmp);
            for (int i = 0; i < 4; i++) {
                int a = peek[0] + fx_x[i];
                int b = peek[1] + fx_y[i];
                if (
                        (
                                (
                                        (a == heights.length - 1 && b >= 0 && b < heights[0].length) ||
                                                (b == heights[0].length - 1 && a >= 0 && a < heights.length)) && !flag[a][b]
                        ) || (
                                a >= 0 && b >= 0 && a < heights.length && b < heights[0].length && !flag[a][b] && heights[a][b] >= heights[peek[0]][peek[1]]
                        )
                ) {
                    queue.add(new int[]{a, b});
                    flag[a][b] = true;
                }
            }
        }

        for (List<Integer> list : res_0) {
            set.add(list.get(0) + " " + list.get(1));
        }
        for (List<Integer> list : res_1) {
            if (set.contains(list.get(0) + " " + list.get(1)))
                res.add(list);
        }
        return res;
    }
}
