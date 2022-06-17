package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * @author Junho
 * @date 2022/6/15 20:33
 */
public class Main498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List> resList = new ArrayList<>();
        for(int i = 0 ; i < mat.length ; i++){
            List<Integer> list = new ArrayList<>();
            int x = i;
            int y = 0;
            while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length){
                list.add(mat[x][y]);
                x -= 1;
                y += 1;
            }
            resList.add(list);
        }
        for(int i = 1 ; i < mat[0].length ; i++){
            List<Integer> list = new ArrayList<>();
            int x = mat.length - 1;
            int y = i;
            while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length){
                list.add(mat[x][y]);
                x -= 1;
                y += 1;
            }
            resList.add(list);
        }

//        for(int i = 0 ; i < resList.size() ; i++ ){
//            for(int j = 0 ; j < resList.get(i).size() ;  j++){
//                System.out.print(resList.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }

        int[] res = new int[mat.length * mat[0].length];
        boolean fx = true;
        int idx = 0;
        for(int i = 0 ; i < resList.size() ; i++ ){
            if(fx){
                for(int j = 0 ; j < resList.get(i).size() ;  j++){
//                    System.out.print(resList.get(i).get(j) +" ");
                    res[idx++] = (int) resList.get(i).get(j);
                }
            }else{
                for(int j = resList.get(i).size() - 1 ; j >= 0 ;  j--){
//                    System.out.print(resList.get(i).get(j) +" ");
                    res[idx++] = (int) resList.get(i).get(j);
                }
            }
            fx = !fx;
        }
        return res;
    }


}