package weekGame.week_4_10;

/**
 * 6038. 向表达式添加括号后的最小结果 显示英文描述
 * 通过的用户数2337
 * 尝试过的用户数2587
 * 用户总通过次数2349
 * 用户总提交次数3710
 * 题目难度Medium
 * 给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
 *
 * 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
 *
 * 返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
 *
 * 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
 * @author Junho
 * @date 2022/4/10 11:25
 */
public class Main6038 {
    /**
     * "99999999+9"
     * 输出：
     * ""
     * 预期：
     * "9(9999999+9)"
     */
    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("99999999+9"));
    }
    public static  String minimizeResult(String expression) {
        String[] strs = expression.split("\\+");
        int num_1 = Integer.parseInt(strs[0]);
        int num_2 = Integer.parseInt(strs[1]);
        int res = Integer.MAX_VALUE;
        String resStr = "";
        int addIdx = expression.indexOf('+');
        for(int i = 0 ; i < addIdx ; i++){
            for(int j = addIdx + 1 ; j < expression.length() ;j++){
                String num1 = expression.substring(0 , i);
                String num2 = expression.substring(i , addIdx);
                String num3 = expression.substring(addIdx + 1 , j);
                String num4 = expression.substring(j , expression.length());
                // System.out.println(num1+"=>"+num2+"=>"+ num3+"=>"+num4);


                if(num1.equals("") && !num3.equals("")){
//                    res = Math.min(res,
//                            (Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4));
                    if((Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4) < res){
                        resStr = "(" + num2 + "+" + num3 + ")" + num4;
                        res = (Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4);
                    }
                }
                if(!num1.equals("") && num3.equals("")){
//                    res = Math.min(res,
//                            (Integer.parseInt(num2) + Integer.parseInt(num4)) * Integer.parseInt(num1));
                    if((Integer.parseInt(num2) + Integer.parseInt(num4)) * Integer.parseInt(num1) < res) {
                        resStr = num1 + "(" + num2 + "+" + num4 + ")";
                        res = (Integer.parseInt(num2) + Integer.parseInt(num4)) * Integer.parseInt(num1);
                    }
                }
                if(num1.equals("") && num3.equals("")){
//                    res = Math.min(res,
//                            (Integer.parseInt(num2) + Integer.parseInt(num4)) );
                    if((Integer.parseInt(num2) + Integer.parseInt(num4)) < res) {
                        resStr =  "(" + num2 + "+" + num4 + ")";
                        res = (Integer.parseInt(num2) + Integer.parseInt(num4)) ;
                    }
                }
                if(!num1.equals("") && !num3.equals("")){
//                    res = Math.min(res,
//                            (Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4) * Integer.parseInt(num1));
                    if((Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4) * Integer.parseInt(num1) < res) {
                        resStr =  num1 + "(" + num2 + "+" + num3 + ")" + num4;
                        res = (Integer.parseInt(num2) + Integer.parseInt(num3)) * Integer.parseInt(num4) * Integer.parseInt(num1) ;
                    }
                }
            }
        }
        return resStr;
    }
}
