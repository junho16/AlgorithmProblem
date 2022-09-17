package interview.amazon;

import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/8/20 15:08
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double minRes = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 0 , left = 0 , right = sum ; i < n - 1; i++){
            left += arr[i];
            right -= arr[i];
            double ave_l = Math.floor(left / (i + 1));
            double ave_r = Math.floor(right / (n - i - 1 ));

            if(Math.abs(ave_l - ave_r) < minRes){
                minRes = Math.abs(ave_l - ave_r);
                minIdx = i;
            }
        }
        System.out.println(minIdx + 1);
    }

    /**
     5
     1 3 2 4 5
     System.out.println(left + " " + (i+1) + " " + right + " " + (n - i - 1) +  " ave_l:" + ave_l+" ; " + "ave_r:" + ave_r +" ==> " + Math.abs(ave_l - ave_r) );
     */
}
