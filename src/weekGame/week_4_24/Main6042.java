package weekGame.week_4_24;

import java.util.HashSet;
import java.util.Set;

/**
 * 6042. 统计圆内格点数目 显示英文描述
 * 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi)
 * 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 *
 * 注意：
 *
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 * @author Junho
 * @date 2022/4/24 10:44
 */
public class Main6042 {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < circles.length ; i++){
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for(int j = x - r ; j <= x + r ; j++){
                for(int k = y - r ; k <= y + r ; k++){
                    if( Math.pow(j - x , 2) + Math.pow(k - y , 2) <= Math.pow(r , 2))
                        set.add(j + " " + k);
                }
            }
        }
        return set.size();
    }
}
