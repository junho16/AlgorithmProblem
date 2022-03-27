package leetcode;

/**
 * 661. 图片平滑器
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 *
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 *
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * @author Junho
 * @date 2022/3/24 20:33
 */
public class Main661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for(int i = 0  ;i < img.length ; i++){
            for(int j = 0; j < img[0].length ; j++){
                int num = 0;
                int size = 0;
                for(int w = i - 1 ; w <= i + 1 ; w++ ){
                    for(int h = j - 1 ; h <= j + 1 ; h++){
                        if(w >= 0 && w < img.length && h >= 0 && h < img[0].length){
                            num += img[w][h];
                            size++;
                        }
                    }
                }
                res[i][j] = num/size;
            }
        }
        return res;
    }
}
