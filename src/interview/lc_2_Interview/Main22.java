package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个推论需要记住
 * 假设 一个括号序列 从前往后遍历到了某一处，你会发现，前面的左括号的数量永远大于右括号
 * 相当于说 每一个右括号都有一个左括号在等他 如果出现了没等到的情况 基本就是g了
 *
 * 带入到本题目中，
 *      左括号什么时候可以添加？==》任意时候（只要其数量小于n）
 *      右括号什么时候可以添加？==》当左括号的数量大于它的时候才可以添加
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Main22 {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int nn) {
        n = nn;
        res = new ArrayList<>();
        dfs( 0 , 0 , "");
        return res;
    }
    void dfs(int left_num , int right_num , String path){
        if(left_num == n && right_num == n ){
            res.add(path);
            return;
        }
        if(left_num < n){
            dfs(left_num + 1 ,right_num , path + "(");
        }
        if(left_num > right_num && right_num < n){
            dfs(left_num  ,right_num + 1  , path + ")");
        }
    }
}
