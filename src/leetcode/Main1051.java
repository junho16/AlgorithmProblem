package leetcode;

/**
 * 1051. 高度检查器
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 *
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 *
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 *
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * @author Junho
 * @date 2022/6/15 22:30
 */
public class Main1051 {
    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for(int i = 0 ; i < heights.length ;i++ ){
            arr[i] = heights[i];
        }
        int res = 0;
        quick(arr , 0 , heights.length - 1);
        for(int i = 0; i < heights.length ; i++){
            System.out.print( arr[i] +" ");
             res += arr[i] == heights[i] ? 1 : 0;
        }
        return res;
    }
    void quick(int[] arr , int left , int right){
        if(left >= right){
            return;
        }
        int l = left - 1;
        int r = right + 1;
        int mid = arr[left];
        while (l < r){
            do{
                l++;
            }while (mid > arr[l]);

            do{
                r--;
            }while (mid < arr[r] );

            if(l < r){
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        quick(arr , left , r);
        quick(arr , r + 1, right);

    }
}
