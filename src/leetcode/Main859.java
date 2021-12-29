package leetcode;

/**
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
public class Main859 {
    public boolean buddyStrings(String s, String goal) {

        if(s.equals(goal)){
            int[] nums = new int[28];
            for(int i = 0; i < s.length() ;i++){
                nums[s.charAt(i) - 'a']++;
//                for(int j = i+1 ; j < s.length() ; j++ ){
//                    if(s.charAt(i) != goal.charAt(i-1)){
//                        return false;
//                    }
//                }
            }
            for(int i = 0 ;i < nums.length;i++){
                if(nums[i] >= 2){
                    return true;
                }
            }
            return false;
//            for(int i = 1; i < s.length() ;i++){
//                if(s.charAt(i) != goal.charAt(i-1)){
//                    return false;
//                }
//            }
//            return true;
        }
        int index = 0;
        int[] errArr = new int[s.length()];
        for(int i = 0; i < s.length() ;i++){
            if(s.charAt(i) != goal.charAt(i)){
                errArr[index++] = i;
            }
        }
        if(index != 2)
            return false;
        else{
            int index_1 = errArr[0];
            int index_2 = errArr[1];
            if(s.charAt(index_1) == goal.charAt(index_2) &&
                    s.charAt(index_2) == goal.charAt(index_1)){
                return true;
            }else{
                return false;
            }
        }
    }
}
