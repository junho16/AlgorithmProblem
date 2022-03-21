package weekGame.week_3_20;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 6029. 射箭比赛中的最大得分
 * Alice 和 Bob 是一场射箭比赛中的对手。比赛规则如下：
 *
 * Alice 先射 numArrows 支箭，然后 Bob 也射 numArrows 支箭。
 * 分数按下述规则计算：
 * 箭靶有若干整数计分区域，范围从 0 到 11 （含 0 和 11）。
 * 箭靶上每个区域都对应一个得分 k（范围是 0 到 11），Alice 和 Bob 分别在得分 k 区域射中 ak 和 bk 支箭。如果 ak >= bk ，那么 Alice 得 k 分。如果 ak < bk ，则 Bob 得 k 分
 * 如果 ak == bk == 0 ，那么无人得到 k 分。
 * 例如，Alice 和 Bob 都向计分为 11 的区域射 2 支箭，那么 Alice 得 11 分。如果 Alice 向计分为 11 的区域射 0 支箭，但 Bob 向同一个区域射 2 支箭，那么 Bob 得 11 分。
 *
 * 给你整数 numArrows 和一个长度为 12 的整数数组 aliceArrows ，该数组表示 Alice 射中 0 到 11 每个计分区域的箭数量。现在，Bob 想要尽可能 最大化 他所能获得的总分。
 *
 * 返回数组 bobArrows ，该数组表示 Bob 射中 0 到 11 每个 计分区域的箭数量。且 bobArrows 的总和应当等于 numArrows 。
 *
 * 如果存在多种方法都可以使 Bob 获得最大总分，返回其中 任意一种 即可。
 * @author Junho
 * @date 2022/3/20 14:29
 */
public class Main6029 {
    //结果与结果分数
    public int[] res;
    int resScore = 0;

    int n ;
    int[] arrows;


    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        n = numArrows;
        arrows = aliceArrows;
        res = new int[12];
        dfs(11 , n , 0, new LinkedList<>()  );

        for (int l = 0 ,r = res.length - 1 , idx = 0  ; l < r ; l++,r--  ) {
            int tmp = res[l];
            res[l] = res[r];
            res[r] = tmp;
            // System.out.print(res[i]+" ");
        }

        return res;
    }
    //index：区域  arrowNum：剩下的箭的数量  sum：得分 list：目前的中箭序列
    public void dfs(int index , int arrowNum , int sum , LinkedList<Integer> list  ){
        //  System.out.println("===>"+arrowNum);
        if(index <= -1 || arrowNum <= 0){

            if (sum > resScore) {
                // System.out.println("==>"+sum);
                resScore = sum;
                res = new int[12];
                for (int i = list.size() - 1 ; i >= 0 ; i--  ) {
                    res[i] = list.get(i);
                }
                System.out.println();
                if(arrowNum >= 0){
                    for(int i = list.size() - 1; i >= 0  ;i--){
                        if(res[i] == 0){
                            res[i] += arrowNum;
                            return;
                        }
                    }
                }
            }
            return;
        }
        //此区域中箭
        if(arrowNum >= arrows[index] + 1){
            LinkedList dfs1 = new LinkedList<>(list);
            dfs1.add((arrows[index] + 1));
            dfs(index - 1 ,  arrowNum - (arrows[index] + 1) , sum + index , dfs1  );
        }

        //此区域不中
        LinkedList dfs2 = new LinkedList<>(list);
        dfs2.add(0);
        dfs(index - 1 ,  arrowNum  , sum  ,  dfs2);

    }
}