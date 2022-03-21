package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * @author Junho
 * @date 2022/3/21 14:59
 */
public class Main241 {
    List<String> expressions = new ArrayList();

    public List<Integer> diffWaysToCompute(String expression) {
        for (int i = 0; i < expression.length();  ) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                int k = i + 1;
                while (k < expression.length() && expression.charAt(k) >= '0' && expression.charAt(k) <= '9') {
                    k++;
                }
                expressions.add(expression.substring(i, k));
                i = k;
            } else {
                expressions.add(expression.charAt(i) + "");
                i++;
            }
        }
        //    for(int i=0 ; i< expressions.size() ;i++){
        //        System.out.println(expressions.get(i));
        //    }
        //    return null;
        return dfs(0, expressions.size() - 1 );
    }

    List<Integer> dfs(int left , int right){
        // System.out.println(left+" "+right);
        List<Integer> arr = new ArrayList<>();
        if(left == right){
            arr.add(Integer.parseInt(expressions.get(left)));
            return arr;
        }
        for(int i = left + 1 ; i < expressions.size() && i <=  right ;i += 2){
            List<Integer> leftArr = dfs(left, i - 1);
            List<Integer> rightArr = dfs(i + 1, right);
            for(Integer l : leftArr){
                for(Integer r : rightArr){
                    arr.add(action(expressions.get(i) , l , r));
                }
            }
        }
        return arr;
    }
    int action(String fu , int num1 , int num2){
        switch (fu){
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
        }
        return 0;
    }
}
