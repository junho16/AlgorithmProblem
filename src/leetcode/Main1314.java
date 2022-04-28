package leetcode;

/**
 *  虽然代码又长又笨，但是好歹算是写了 ok
 * 1314. 矩阵区域和
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 *
 *
 * @author Junho
 * @date 2022/4/25 13:37
 */
public class Main1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = k ; i < mat.length - k ; i++ ){
            for(int j = k ; j < mat[0].length - k ; j++ ){
                if(j == k){
                    int tmp = 0;
                    for(int id_0 = i - k ; id_0 <= i + k ;id_0++){
                        for(int id_1 = j - k ; id_1 <= j + k ; id_1++){
                            tmp += mat[id_0][id_1];
                        }
                    }
                    ans[i][j] = tmp;
                }else{
                    int removeN = 0;
                    for(int id = i - k ; id <= i + k ; id++){
                        removeN += mat[id][j-1-k];
                    }
                    int addN = 0;
                    for(int id = i - k ; id <= i + k ; id++){
                        addN += mat[id][j+k];
                    }
                    ans[i][j] = ans[i][j-1] - removeN + addN;
                }

            }
        }
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(i < k || i >= mat.length - k || j < k || j >= mat[0].length - k){
                    int atmp = 0;
                    for(int id_0 = i - k; id_0 <= i + k ; id_0++){
                        for(int id_1 = j - k ; id_1 <= j + k ; id_1++){
                            if(id_0 >=0 && id_0 < mat.length && id_1 >= 0 && id_1 < mat[0].length){
                                atmp += mat[id_0][id_1];
                            }
                        }
                    }
                    ans[i][j] = atmp;
                }
            }
        }
        return ans;
    }
}
