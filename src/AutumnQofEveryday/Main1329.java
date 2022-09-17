package AutumnQofEveryday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Junho
 * @date 2022/9/13 16:38
 */
public class Main1329 {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length , col = mat[0].length;
        int[][] res = new int[row][col];
        for(int i = row - 1 ; i >= 0 ; i--){
            int x = i , y = 0 ;
            int sx = i , sy = 0;
            List<Integer> list = new ArrayList<>();
            while (x >= 0 && x < row && y >=0 && y < col){
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            int idx = 0;
            while (sx >= 0 && sx < row && sy >=0 && sy < col){
                res[sx++][sy++] = list.get(idx++);
            }
        }
        for(int i = col - 1 ; i > 0 ; i--){
            int x = 0 , y = i ;
            int sx = 0 , sy = i;
            List<Integer> list = new ArrayList<>();
            while (x >= 0 && x < row && y >=0 && y < col){
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            int idx = 0;
            while (sx >= 0 && sx < row && sy >=0 && sy < col){
                res[sx++][sy++] = list.get(idx++);
            }
        }
        return res;
    }
}
