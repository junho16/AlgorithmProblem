package leetcode;

import java.util.Arrays;

/**
 * @author Junho
 * @date 2022/9/17 9:54
 */
public class Main1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int size = (int) (arr.length * 0.05);
        int sum = 0;
        for(int i = size; i < arr.length - size ;i++){
            sum += arr[i];
        }
        return sum * 1.0 / (arr.length - 2 * size);
    }
}
