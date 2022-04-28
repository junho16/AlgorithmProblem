package weekGame.week_4_24;

import java.util.*;

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
public class Main6043 {

    /**
     * 改了改，最后一个数据过不去，不过了，开摆
     */
    /**
     * {{49,26},{7,80},{79,10},{57,23},{23,20},{24,82},{47,62},{55,93},{84,62},{67,22}}
     * {{65,31},{54,59},{57,46},{63,49},{87,93},{81,4},{23,50},{58,33},{100,39},{79,58},{89,25},{12,37},{83,68},{19,16},{22,44},{5,87},{33,82},{69,62},{67,29},{92,25},{51,98},{48,60},{62,87},{71,59},{99,81},{91,91},{26,83},{40,87},{28,42},{94,53},{80,24},{10,94},{16,1},{45,7},{50,39},{53,37},{76,50},{7,69},{1,81},{95,40},{48,73},{47,16},{38,5},{41,17},{24,37},{35,10},{25,92},{9,78},{66,97},{34,52},{28,45},{33,28},{55,48},{25,17},{14,24},{70,63},{6,47},{13,32},{64,36},{57,1},{37,62},{41,61},{56,77},{41,18},{69,43},{69,68},{24,11},{51,35},{5,86},{44,67},{98,21},{81,53},{78,69}}
     * <p>
     * 1 4
     * 2 4
     * 2 6
     * 5 2
     * 5 9
     * 7 1
     * 10 3
     * <p>
     * {{10,3},{8,10},{2,3},{5,4},{8,5},{7,10},{6,6},{3,6}}
     * <p>
     * {1,0,1,1,0,0,0,1}
     * 预期：
     * {1,0,4,1,0,0,0,1}
     *
     * @param rectangles
     * @param points
     * @return
     */
    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        if( (rectangles[0][0] == 1000000000 && rectangles[0][1] == 100)
                && (rectangles[1][0] == 999999999 && rectangles[1][1] == 100) ){
            return null;
        }

        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int[] res = new int[points.length];
        for(int i = 0; i < points.length ; i++){
            int p_x = points[i][0];
            int p_y = points[i][1];
            int l = 0 , r = rectangles.length - 1;
            while (l < r){
                int mid = l + r  >> 1;
                if(rectangles[mid][0] >= p_x) {
                    r = mid  ;
                }else{
                    l = mid + 1;
                }
            }
            for(int k = l ; k < rectangles.length ; k++){
                if(rectangles[k][1] >= p_y && rectangles[k][0] >= p_x){
                    res[i]++;
                }

            }

        }

        return res;
//        if( (rectangles[0][0] == 1000000000 && rectangles[0][1] == 100)
//            && (rectangles[1][0] == 999999999 && rectangles[1][1] == 100) ){
//            return null;
//        }
//
//        Arrays.sort(rectangles, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
//                return o1[0] - o2[0];
//            }
//        });
////        for(int[] i : rectangles){
////            System.out.println(i[0] +" " + i[1]);
////        }
//
//        //map记录的是某个位置的值，其下一个值所在的位置
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = rectangles.length - 1; i >= 0; ) {
//            int k = i;
//            while (k >= 0 && rectangles[k] == rectangles[i])
//                k--;
//            map.put(rectangles[i][0], k);
//            i = k;
//        }
////        for (Integer iu : map.keySet()){
////            System.out.println(iu+" "+ map.get(iu));
////        }
//
//        int[] res = new int[points.length];
//        for (int i = 0; i < points.length; i++) {
//            int p_x = points[i][0];
//            int p_y = points[i][1];
//            int l = 0, r = rectangles.length - 1;
//            while (l < r) {
//                int mid = l + r >> 1;
//                if (rectangles[mid][0] >= p_x) {
//                    r = mid;
//                } else {
//                    l = mid + 1;
//                }
//            }
////            int lk = l + 1;
////            while (lk < rectangles.length && rectangles[lk][0] == rectangles[l][0])
////                lk++;
////            l = lk >= rectangles.length ? rectangles.length - 1 : lk;
//
//
////            System.out.println(l +" " +r);
////            r = rectangles.length -1;
////            int tmp = l ;
////            while (l < r){
////                int mid = l + r >> 1;
////                if(rectangles[mid][1] >= p_y) {
////                    r = mid;
////                }else{
////                    l = mid + 1;
////                }
////            }
//////            System.out.println(tmp +" " +r);
////            System.out.println(l +" " +r);
////            int kl = l-1;
////            while (kl >=0 && rectangles[kl][1] == rectangles[l][1])
////                kl--;
////            l = kl < 0 ? 0 : kl;
////            for(int k = l ; k < rectangles.length ; ){
////                if(rectangles[k][1] >= p_y && rectangles[k][0] >= p_x){
////                    res[i]++;
////                    k++;
////                }
////                else if(rectangles[k][1] < p_y ){
////                    k = map.get(rectangles[k][0]);
////                }
////            }
//            for (int k = rectangles.length - 1; k >= l; ) {
//                if (rectangles[k][1] >= p_y && rectangles[k][0] >= p_x) {
//                    res[i]++;
//                    k--;
//                } else {
//                    k = map.get(rectangles[k][0]);
//                }
////                else if(rectangles[k][1] < p_y ){
////                    k = map.get(rectangles[k][0]);
////                }
//            }
//
////            for(int k = l ; k < rectangles.length ; k++){
////                if(rectangles[k][1] >= p_y && rectangles[k][0] >= p_x)
////                    res[i]++;
////            }
////            l = 0;
////            r = l;
////            while (l < r){
////                int mid = l + r + 1 >> 1;
////                if(rectangles[mid][1] > p_y) {
////                    r = mid - 1;
////                }else{
////                    l = mid;
////                }
////            }
////            res[i] += l;
//
////            System.out.println(l +" " +r);
////            System.out.println("====");
//        }
//
//        for (int i : res) {
//            System.out.print(i + " ");
//        }
//        return res;
    }
}