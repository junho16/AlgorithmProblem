package base;

import java.util.Scanner;

/**
 * 差分数组
 * 差分:差分的思想：已知数组A 构造数组B满足 ai = b1 + b2 + ... + bi(也就是说 a 是作为 b 的前缀和 则 ==》 b 称为 a 的差分)
 *  最常用的功能: 在 O（1）时间复杂度下给 l,r 范围内 A 数组内元素 + c
 *  ==》某个数组在某个区间范围内都加上一个数
 * 797. 差分
 *  输入一个长度为 n 的整数序列。
 *  接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。
 *  请你输出进行完所有操作后的序列。
 *  输入格式 : 第一行包含两个整数 n 和 m。第二行包含 n 个整数，表示整数序列。接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。
 *  输出格式 : 共一行，包含 n 个整数，表示最终序列。
 *  数据范围 1≤n,m≤100000, 1≤l≤r≤n, −1000≤c≤1000, −1000≤整数序列中元素的值≤1000
 *
 * @author Junho
 * @date 2022/6/7 10:26
 */
public class MainHackerRankArray {

    //前缀和数组
    static int[] A = new int[100010];

    //差分数组
    static int[] B = new int[100010];

    public static void insert(int l , int r , int c){
        B[l] += c;
        B[r + 1] -=c ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        //前缀和数组
//        A = new int[n];
//        //差分数组
//        B = new int[n];
        for(int i = 0 ;i < n ;i++){
//            int k = sc.nextInt();
            A[i] = sc.nextInt();
            insert(i , i, A[i]);
        }
        for(int j = 0 ; j < n ;j++  ) {
            System.out.print(A[j] +" ");
        }
        System.out.println();
        for(int j = 0 ; j < n ; j++  ) {
            System.out.print(B[j] + " ");
        }
        System.out.println();
        for(int i = 0 ;i < m  ; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

//            System.out.println( l+ " " + r + " "+ c);
            insert(l-1 ,r-1 ,c);
          }
        System.out.print(B[0]);
        for(int i = 1 ; i < n ; i++){
            B[i] += B[i - 1];
            System.out.print(" " + B[i]);
        }

//        for(int j = 0 ; j < n ;j++  ) {
//            System.out.print(A[j] +" ");
//        }
//        System.out.println();
//        for(int j = 0 ; j < n ; j++  ) {
//            System.out.print(B[j] + " ");
//        }
//        System.out.println();
    }
}
