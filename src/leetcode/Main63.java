package leetcode;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * @author Junho
 * @date 2022/4/14 11:02
 */
public class Main63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1
                || obstacleGrid[0][0] == 1)
            return 0;

        int[][] f = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i = 0 ; i < obstacleGrid.length ; i++){
            if( obstacleGrid[i][0] == 1){
                f[i][0] = -999;
                break;
            }else{
                f[i][0] = 1;
            }
        }
        for(int i = 0 ; i < obstacleGrid[0].length ; i++){
            if( obstacleGrid[0][i] == 1){
                f[0][i] = -999;
                break;
            }else{
                f[0][i] = 1;
            }
        }



        for(int i = 1 ; i < obstacleGrid.length ; i++){
            for(int j = 1 ; j < obstacleGrid[0].length ; j++){
                f[i][j] = obstacleGrid[i][j] == 1 ? -999 : 0;
            }
        }
        // for(int i = 0 ; i < obstacleGrid.length ; i++){
        //     for(int j = 0 ; j < obstacleGrid[0].length ; j++){
        //         System.out.print(f[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i = 1 ; i < obstacleGrid.length ; i++){
            for(int j = 1 ; j < obstacleGrid[0].length ; j++){
                if(f[i][j] != -999){
                    int a = f[i - 1][j] == -999 ? 0: f[i - 1][j];
                    int b = f[i][j - 1] == -999 ? 0: f[i][j - 1];
                    f[i][j] = a + b;
                }
            }
        }
        // for(int i = 0 ; i < obstacleGrid.length ; i++){
        //     for(int j = 0 ; j < obstacleGrid[0].length ; j++){
        //         System.out.print(f[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return f[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
     }
}
