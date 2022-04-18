package weekGame.week_4_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6072. 转角路径的乘积中最多能有几个尾随零 显示英文描述
 * 通过的用户数383
 * 尝试过的用户数682
 * 用户总通过次数387
 * 用户总提交次数1139
 * 题目难度Medium
 * 给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。
 *
 * 转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；反之亦然。当然，同样不能访问之前已经访问过的单元格。
 *
 * 一条路径的 乘积 定义为：路径上所有值的乘积。
 *
 * 请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。
 *
 * 注意：
 *
 * 水平 移动是指向左或右移动。
 * 竖直 移动是指向上或下移动。
 *
 * @author Junho
 * @date 2022/4/17 11:24
 */
public class Main6072 {
    /**
     *
     输入：
     [[437,230,648,905,744,416],
     [39,193,421,344,755,154],
     [480,200,820,226,681,663],
     [658,65,689,621,398,608],
     [680,741,889,297,530,547],
     [809,760,975,874,524,717]]
     输出：
     6
     预期：
     7

     */
    public static void main(String[] args) {
        Main6072 main6072 = new Main6072();
        System.out.println(main6072.maxTrailingZeros(
                new int[][]{
                        {23, 17, 15, 3, 20},
                        {8, 1, 20, 27, 11},
                        {9, 4, 6, 2, 21},
                        {40, 9, 1, 10, 6},
                        {22, 7, 4, 5, 3}
                }
        ));
        System.out.println(main6072.maxTrailingZeros(
                new int[][]{
                        {437,230,648,905,744,416},
                        {39,193,421,344,755,154},
                        {480,200,820,226,681,663},
                        {658,65,689,621,398,608},
                        {680,741,889,297,530,547},
                        {809,760,975,874,524,717}
                }
        ));


    }
    Map<String , Integer> map = new HashMap<>();
    int[][] grid ;
    int res = 0;
    public int maxTrailingZeros(int[][] g) {
        grid = g;
        for(int i = 0; i < grid.length ;i++ ){
            for(int j = 0 ;j < grid[0].length ; j++){
                dfs(new ArrayList<Integer>() , i, j, 0 , 0 );
                dfs(new ArrayList<Integer>() , i, j, 0 , 1 );
                dfs(new ArrayList<Integer>() , i, j, 0 , 2 );
                dfs(new ArrayList<Integer>() , i, j, 0 , 3 );
            }
        }
        return res;
    }
    // 路径记录 ，num作为 已经转了几次弯了 ，fx作为方向 0 1 2 3 代表上下左右
    void dfs(List<Integer> list, int x , int y , int num , int fx ){

        int[] fx_x = {-1, 1, 0, 0};
        int[] fx_y = {0, 0, -1, 1};
        if( x < 0 || y < 0 ||  x >= grid.length || y >= grid[0].length || num == 2){
            int ans2 = 0;
            int ans5 = 0;

            for(int i = 0; i < list.size() ;i++ ){

                // System.out.print(list.get(i) + " ");
                ans2 += cal2(list.get(i));
                ans5 += cal5(list.get(i));
            }
            // System.out.println();
            // if(ans2> res || ans5> res){
            //    for(int i = 0; i < list.size() ;i++ ){
            //         System.out.print(list.get(i) + " ");
            //     }
            //     System.out.println();
            // }
            res = Math.max(res , ans2 >= ans5 ? ans5 : ans2);

            return;
        }
        // System.out.println(x+" " + y);
        list.add(grid[x][y]);
        for(int i = 0; i < 4 ; i++){
            int a = fx_x[i] + x;
            int b = fx_y[i] + y;
            List<Integer> l = new ArrayList<>(list);
            if(i == fx){
                //i == fx说明不用变向
                dfs(l , a , b , num , fx);
            }else{
                if((fx == 0 && i != 1) || (fx == 1 && i != 0 )
                        || (fx == 2 && i != 3) || (fx == 3 && i != 2 ))
                    dfs(l , a , b , num + 1 , i);

            }
        }
    }



    int cal2(int n){
        int sum1 = 0;//计算因子为2的个数
        while(n > 0 && n % 2 == 0){
            n = n / 2;//不会出现0~1的分数
            sum1++;
        }
        return sum1;
    }

    int cal5(int n){
        int sum2 = 0;//计算因子为5的个数 ;
        while(n > 0 && n % 5 == 0){
            n = n / 5;
            sum2++;
        }
        return sum2;
    }
}
//class Solution {
//    public int maxTrailingZeros(int[][] grid) {
//        int m = grid.length , n = grid[0].length;
//        // 预处理一个数包含2，5的数量
//        int[][] t = new int[1001][2];
//        for(int i = 2 ; i <= 1000 ; i++){
//            int c2 = 0;
//            int t2 = i;
//            while(t2 % 2 == 0){
//                t2 /= 2;
//                c2++;
//            }
//
//            int c5 = 0;
//            int t5 = i;
//            while(t5 % 5 == 0){
//                t5 /= 5;
//                c5++;
//            }
//            t[i][0] = c2;
//            t[i][1] = c5;
//        }
//        // 左边2，5数量
//        int[][][] l = new int[m][n][2];
//        // 上边2，5数量
//        int[][][] u = new int[m][n][2];
//        for(int i = 0 ; i < m ; i++){
//            for(int j = 0; j < n ; j++){
//                if(i - 1 >= 0){
//                    u[i][j][0] = u[i-1][j][0] + t[grid[i-1][j]][0];
//                    u[i][j][1] = u[i-1][j][1] + t[grid[i-1][j]][1];
//
//                }
//                if(j - 1 >= 0){
//                    l[i][j][0] = l[i][j-1][0] + t[grid[i][j-1]][0];
//                    l[i][j][1] = l[i][j-1][1] + t[grid[i][j-1]][1];
//                }
//            }
//        }
//        // 右边2，5数量
//        int[][][] r = new int[m][n][2];
//        // 下边2，5数量
//        int[][][] d = new int[m][n][2];
//        for(int i = m-1 ; i >= 0; i--){
//            for(int j = n-1 ; j >= 0 ;j--){
//                if(i + 1 < m){
//                    d[i][j][0] = d[i+1][j][0] + t[grid[i+1][j]][0];
//                    d[i][j][1] = d[i+1][j][1] + t[grid[i+1][j]][1];
//
//                }
//                if(j + 1 < n){
//                    r[i][j][0] = r[i][j+1][0] + t[grid[i][j+1]][0];
//                    r[i][j][1] = r[i][j+1][1] + t[grid[i][j+1]][1];
//                }
//            }
//        }
//        int ret = 0;
//        for(int i = 0 ; i < m ; i++){
//            for(int j = 0 ; j < n ; j++){
//                int m2 = t[grid[i][j]][0];
//                int m5 = t[grid[i][j]][1];
//                // 左上
//                ret = Math.max(ret , Math.min( l[i][j][0]+u[i][j][0]+m2 , l[i][j][1]+u[i][j][1]+m5) );
//                // 左下
//                ret = Math.max(ret , Math.min( l[i][j][0]+d[i][j][0]+m2 , l[i][j][1]+d[i][j][1]+m5) );
//                // 右上
//                ret = Math.max(ret , Math.min( r[i][j][0]+u[i][j][0]+m2 , r[i][j][1]+u[i][j][1]+m5) );
//                // 右下
//                ret = Math.max(ret , Math.min( r[i][j][0]+d[i][j][0]+m2 , r[i][j][1]+d[i][j][1]+m5) );
//
//            }
//        }
//        return ret;
//    }
//}
//