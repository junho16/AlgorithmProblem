package weekGame.week_5_15;

/**
 * @author Junho
 * @date 2022/5/15 13:35
 */
public class Main6065 {
    /**
     * 统计数字二进制形式每一位1的个数, 最大的就是答案
     * @param candidates
     * @return
     */
    public int largestCombination(int[] candidates) {
        int res = 0;
        int[] cnt = new int[32];
        for(int i = 0 ; i < candidates.length ; i++){
            for(int j = 0; j < 32 ; j++){
                if((candidates[i] & (1 << j) ) > 0){
                    cnt[j]++;
                }
                res = Math.max(res , cnt[j]);
            }
        }
        return res;
    }
}
