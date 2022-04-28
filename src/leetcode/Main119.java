package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author Junho
 * @date 2022/4/26 10:39
 */
public class Main119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1 ; i <= rowIndex+1 ; i++){
            List<Integer> list = new ArrayList<>();
            if(i == 1){
                list.add(1);
                res = new ArrayList<>(list);
                continue;
            }
            else if(i == 2){
                list.add(1);
                list.add(1);
                res = new ArrayList<>(list);
                continue;
            }else{
                list.add(1);
                for(int k = 1; k < i - 1 ; k++){
                    list.add(  res.get(k-1) + res.get(k));
                }
                list.add(1);
                res = new ArrayList<>(list);
                // for(Integer ii : res){
                //     System.out.print(ii+" ");
                // }
                // System.out.println();
            }
        }
        return res;
    }
}
