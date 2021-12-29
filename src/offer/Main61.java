package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Main61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums , 0 ,nums.length);
        int kingNum = 0;
        int cNum = 0;
        for(int i = 0; i < nums.length ; i++ ){
            if(nums[i] == 0 )
                kingNum++;
            else{
                if(i+1 < nums.length){
                    if(nums[i+1] == nums[i])
                        return false;
                    else
                        cNum+=(nums[i+1]-nums[i]-1);
                }
            }
        }
        if(kingNum>=cNum)
            return true;
        else
            return false;
    }
}
