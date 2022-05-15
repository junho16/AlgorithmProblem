package weekGame.week_5_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *6064. 不含特殊楼层的最大连续楼层数 显示英文描述
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 *
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 *
 * 返回不含特殊楼层的 最大 连续楼层数。
 * @author Junho
 * @date 2022/5/15 11:04
 */
public class Main6064 {
    /**
     * 64/80
     * @param bottom
     * @param top
     * @param special
     * @return
     */
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        res = Math.max(res , special[0] - bottom);
        res = Math.max(res , top - special[special.length - 1]);
        for(int i = 1 ; i < special.length ; i++){
            res = Math.max(res , special[i] - special[i-1] - 1);
        }
        return res;
//        List<Integer> list = new ArrayList<>()
//        for(int i = 0 ; i < special.length ; i++){
//            list.add(special[i]);
//        }
//        int res = 0;
//        for(int i = bottom; i <= top ;  ){
//            if(list.contains(i)){
//                int k = i;
//                while(k <= top && list.contains(k))
//                    k++;
//                bottom = k;
//                i = k;
//            }else{
//                res = Math.max(res , i - bottom + 1 );
//                i++;
//            }
//        }
//        return res;
    }
}
