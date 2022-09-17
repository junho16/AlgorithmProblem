package AutumnQofEveryday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3675. 逃离迷宫
 * 给定一个 m×n (m 行, n 列)的迷宫，迷宫中有两个位置，gloria 想从迷宫的一个位置走到另外一个位置，当然迷宫中有些地方是空地，gloria 可以穿越，有些地方是障碍，她必须绕行，从迷宫的一个位置，只能走到与它相邻的 4 个位置中，当然在行走过程中，gloria 不能走到迷宫外面去。
 * 令人头痛的是，gloria 是个没什么方向感的人，因此，她在行走过程中，不能转太多弯了，否则她会晕倒的。
 * 我们假定给定的两个位置都是空地，初始时，gloria 所面向的方向未定，她可以选择 4 个方向的任何一个出发，而不算成一次转弯。
 * gloria 能从一个位置走到另外一个位置吗？
 *
 * 0-1 BFS问题
 * DFS 题解：https://www.acwing.com/solution/content/134087/
 * @author Junho
 * @date 2022/9/13 20:30
 */
public class Main3675_DFS {

    static int k ;
    static int start_x ;
    static int start_y ;
    static int end_x ;
    static int end_y ;
    static int m , n ;

    static char[][] map;
    static int[][] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt  = sc.nextInt();
        while (cnt-- > 0){
            m = sc.nextInt();
            n = sc.nextInt();
            map = new char[m][n];
            max = new int[m][n];
            for(int i = 0 ; i < m ; i++){
                String s = sc.next();
                char[] chars = s.toCharArray();
                for(int j = 0 ; j < n ; j++){
                    map[i][j] = chars[j];
                }
                Arrays.fill(max[i] , Integer.MAX_VALUE);
            }
            k = sc.nextInt();
            start_y = sc.nextInt();
            start_x = sc.nextInt();


            end_y = sc.nextInt();
            end_x = sc.nextInt();

            end_x -= 1;
            end_y -= 1;
//            max[start_x - 1][start_y - 1] = 0;

//            for(int i = 0 ; i < m ; i++){
//                for(int j = 0 ; j < n ; j++){
//                    System.out.print(map[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            for(int i = 0 ; i < m ; i++){
//                for(int j = 0 ; j < n ; j++){
//                    System.out.print(max[i][j] +" ");
//                }
//                System.out.println();
//            }
            if( dfs(start_x - 1, start_y - 1 , -1 , -1) ){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }

    }

    static boolean check(int x , int y){
        if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] == '*'){
            return false;
        }else{
            return true;
        }
    }

    static boolean dfs(int x , int y , int pos , int ans){
        int[] fx_x = {-1 , 0 , 1, 0};
        int[] fx_y = {0 , 1 , 0 , -1};
        if(x == end_x && y == end_y)
            return true;
        for(int i = 0; i < 4 ; i++){
            int a = fx_x[i] + x;
            int b = fx_y[i] + y;
            if(check(a , b)){
                int tot = i == pos ? 0 : 1;
                //重要的剪枝环节 如果转弯数超过了k，或者转弯数超过了目标点的最优转弯数，都不搜
                if(ans + tot > k || ans + tot > max[a][b] ){
                    continue;
                }
                max[a][b] = ans + tot;
                if(dfs(a , b , i , ans + tot))
                    return true;
            }
        }
        return false;
    }

}
