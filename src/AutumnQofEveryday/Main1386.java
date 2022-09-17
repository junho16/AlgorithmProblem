package AutumnQofEveryday;

import java.util.HashMap;
import java.util.Map;

/**
 * 1386. 安排电影院座位
 * 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 * @author Junho
 * @date 2022/9/16 15:02
 */
public class Main1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < reservedSeats.length ; i++){
            int x = reservedSeats[i][0];
            int y = reservedSeats[i][1];
            if(y != 1 && y != 10){
                // 将1-9映射到0-7 并将为1（占位）的位置放到 map 存的x对应的value中进行记录，即value记录的值是二进制串 是某一行哪些位置为1
                map.put(x , map.getOrDefault(x , 0) | 1 << (y - 2));
//                    int v = map.get(x);
//                    v |= 1 << (y - 2) ;
//                    map.put(x , v);
            }
        }
        int res = 2 * n - map.size() * 2 ;
        // map中的值与其相& ==》即取出对应位置为1的数==》若结果大于1 说明有位置上有1（有人占位了）；若结果为0 说明该位置全是0 即没有人占位 可以多安排一组4人间
        int fix1 = 0b11110000;
        int fix2 = 0b00001111;
        int fix3 = 0b00111100;

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(
                    ((fix1 & entry.getValue()) == 0) ||
                            ((fix2 & entry.getValue()) == 0)  ||
                            ((fix3 & entry.getValue()) == 0)
            ) {
                res += 1;
            }
        }
        return res;
    }
}
