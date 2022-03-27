package leetcode;

import com.sun.javafx.css.PseudoClassState;

import java.util.Stack;

/**
 * 682. 棒球比赛
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 * @author Junho
 * @date 2022/3/26 17:04
 */
public class Main682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i< ops.length ;i++ ){
            if(ops[i].equals("C")){
                stack.pop();
            }else if(ops[i].equals("D")){
                stack.push(stack.peek() * 2);
            }else if(ops[i].equals("+")){
                int tmp = stack.pop();
                int num = stack.peek() + tmp;
                stack.push(tmp);
                stack.push(num);
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int res = 0 ;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
