package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 335. 路径交叉
 * 给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 * @author Junho
 * @date 2022/3/26 9:51
 */
public class Main335 {
    public boolean isSelfCrossing(int[] distance) {
        if(distance.length <= 3 )
            return false;
        for(int i = 3 ; i < distance.length ;i++){
            if(i >= 3
                    && distance[i] >= distance[i-2]
                    && distance[i-1] <= distance[i-3])
                return true;
            if(i >= 4
                    && distance[i] + distance[i-4] >= distance[i-2]
                    && distance[i-1] == distance[i-3] )
                return true;
            if(i >= 5
                    && distance[i] + distance[i-4] >= distance[i-2]
                    && distance[i-1] + distance[i-5] >= distance[i-3]
                    && distance[i-2] >= distance[i-4]
                    && distance[i-3] >= distance[i-1])
                return true;
        }
        return false;
    }
//    下面的暴力 最后一个测试丶过不去
//    public boolean isSelfCrossing(int[] distance) {
//        Set<String> set = new HashSet();
//        int[] fx_x = {0, -1, 0, 1};
//        int[] fx_y = {1, 0, -1, 0};
//        set.add("0 0");
//        for(int i = 0 , fx = 0 , x = 0 , y = 0; i < distance.length ; i++){
//            for(int j = 0 ; j < distance[i] ; j++){
//                x += fx_x[fx];
//                y += fx_y[fx];
//                if(set.contains(x + " " + y)){
//                    // for(String s : set ){
//                    //     System.out.println(s);
//                    // }
//                    // System.out.println();
//                    return true;
//                }
//                else{
//                    set.add(x + " " + y);
//                    // for(String s : set ){
//                    //     System.out.println(s);
//                    // }
//                    // System.out.println();
//                }
//            }
//            fx = (fx + 1) % 4;
//        }
//        return false;
//    }
}
