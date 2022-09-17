package AutumnQofEveryday;

import java.util.Scanner;

/**
 * 4405. 统计子矩阵
 * 给定一个 N×M 的矩阵 A，请你统计有多少个子矩阵 (最小 1×1，最大 N×M) 满足子矩阵中所有数的和不超过给定的整数 K?
 * 前缀和+双指针
 * @author Junho
 * @date 2022/9/11 18:27
 */
public class Main4405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        //前缀和 从第i行到第j行 的某一列 的前缀和
        int[][] pre = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m; j++ ){
                int x = sc.nextInt();
                pre[i][j] = x;
                pre[i][j] += pre[i-1][j];
            }
        }
        //答案比较大 因为是 500^3 需要用long
        long res = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i ; j <= n ; j++){
                for(int l = 1 , r = 1 , sum = 0 ; r <= m ; r++){
                    sum += pre[j][r] - pre[i - 1][r];
                    while (sum > k){
                        sum -= pre[j][l] - pre[i-1][l];
                        l++;
                    }
                    res += r - l + 1;
                }
            }
        }
        System.out.println(res);
    }
}
