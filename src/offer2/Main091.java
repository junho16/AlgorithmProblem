package offer2;

/**
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 * @author Junho
 * @date 2022/6/29 13:43
 */
public class Main091 {
    public int minCost(int[][] costs) {
        int[][] res = new int[costs.length][costs[0].length];
        res[0][0] = costs[0][0];
        res[0][1] = costs[0][1];
        res[0][2] = costs[0][2];
        for(int i = 1 ; i < costs.length ; i++ ){
            for(int j = 0 ; j < 3; j++ ){
                if(j == 0){
                    res[i][j] = Math.min(res[i-1][1] , res[i-1][2])
                            + costs[i][j] ;
                }else if(j == 1){
                    res[i][j] = Math.min(res[i-1][0] , res[i-1][2])
                            + costs[i][j] ;
                }else{
                    res[i][j] = Math.min(res[i-1][0] , res[i-1][1])
                            + costs[i][j] ;
                }
            }
        }
        return Math.min(Math.min(res[costs.length - 1][0] , res[costs.length - 1][1]) , res[costs.length - 1][2]);
    }
}

