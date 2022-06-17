package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Junho
 * @date 2022/6/15 15:40
 */
public class Main1552 {
    public static void main(String[] args) {
        Main1552 main = new Main1552();
        main.maxDistance(new int[]{5,4,3,2,1,1000000000} , 2);
    }
    int[] position;
    int m;
    // ArrayList list  ;
    public int maxDistance(int[] position_, int m_) {

        position = position_;
        m = m_;
        // list = new ArrayList();

        // for(int i = 0 ; i < position.length ;i++){
        //     list.add(position[i]);
        // }

        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        while(left < right){

            int mid = left + right + 1 >> 1;
            // System.out.println(left+" "+ right + " " + mid + " " + check(mid));
            if(check(mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean check(int mid){
        //mid 是距离
        int sum = 1;
        int pre = position[0];
        for(int i = 1 ; i < position.length ; i++){
            if(position[i] - pre >= mid){
                pre = position[i];
                sum++;
            }
        }
        return sum >= m;
        //下面的时间复杂度太高
        // int sum = 0 ;
        // for(int i = position[0] ; i <= position[position.length - 1] ;i += mid){
        //     if(list.contains(i)){
        //         sum++;
        //         if(sum >= m)
        //             return true;
        //     }
        // }
        // return false;
    }
}
