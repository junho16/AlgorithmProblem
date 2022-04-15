package base;

import java.util.Scanner;

/**
 * 01背包问题
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * @author Junho
 * @date 2022/4/14 16:06
 */
public class Main_01Bag {
    public static void main(String[] args) {
//        int n, v;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] V = new int[n + 1];
        int[] M = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            V[i] = sc.nextInt();
            M[i] = sc.nextInt();
        }
//        for(int i = 0 ;i < n ;i++){
//            System.out.println(V[i] + " " + M[i]);
//        }
//        System.out.println(n+" " +v);
        int[][] dp  = new int[n + 1][v + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= v ; j++){
                dp[i][j] = dp[i-1][j];
                if(V[i] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j - V[i]] + M[i] , dp[i][j]);
            }
//            for(int j = v; j >= 0 ; j--){
//                if(V[i] <= j)
//                    dp[i][j] = Math.max(dp[i - 1][j - V[i]] + M[i] , dp[i - 1][j]);
//            }
        }
        System.out.println(dp[n][v]);
    }
}
