package offer;

/**
 * 滑动窗口算法
 * 就是一个窗口 滑呀滑 滑呀滑~~~
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Main57_2 {
    public int[][] findContinuousSequence(int target) {
        int index = 0;
        int l = 1 , r = 2;
        int resNum = l + r ;
        int[][] res = new int[20000][];
        while (l < r && r < target){
            if(resNum > target){
                resNum -= l;
                l++;
            }
            else if(resNum < target){
                r++;
                resNum += r;
            } else{
                int[] restmp = new int[r - l + 1];
                int idx = 0;
                for(int i = l; i <= r ; i++)
                    restmp[idx++] = i;
                res[index++] = restmp;
                resNum -= l;
                l++;
            }
        }
        int[][] returnRes = new int[index][];
        for(int i = 0 ;i < index ; i++){
            returnRes[i] = res[i];
        }
        return returnRes;
    }
}
