package huawei.test;

import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/5/11 15:37
 */
public class Main_01 {
    /**
        5
        3
        1 2 30
        1 5 20
        3 5 10

        4
        6
        2 3 10
        1 3 15
        1 4 25
        3 4 8
        1 4 16
        2 4 20
     */
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();   //小时
        int m = sc.nextInt();   //超市数
        int[] score = new int[n + 1];
        for(int i = 0 ; i < m ; i++){
            int x0 = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            for(int j = x0 ; j <= x1 ; j++){
                score[j] = score[j] == 0 ? x2 : Math.min(score[j] , x2);
            }
        }
        int res = 0;
        for(int i = 0 ; i < score.length ; i++){
            res += score[i];
        }
        System.out.println(res);
    }
}
