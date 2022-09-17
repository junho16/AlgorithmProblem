package leetcode;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 * @author Junho
 * @date 2022/8/13 11:52
 */
public class Main640 {
    public static void main(String[] args) {
        Main640 main640 = new Main640();
        String test = "x+5-3+x";
        String test1 = "6+x-2";
        String test2 = "x";
        String test3 = "2x";
        String test4 = "0";
        String test5 = "-x";
        int[] res = main640.getRes(test5);
//        System.out.println(main640.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(res[0] + " "+ res[1]);
    }
    public String solveEquation(String equation) {
        // 2 x 0 x-2
        int equalIdx = equation.indexOf("=");
        String pre = equation.substring(0 , equalIdx);
        String pos = equation.substring(equalIdx + 1 , equation.length());
        int[] preArr = getRes(pre);
        int[] posArr = getRes(pos);
        // System.out.print(preArr[0]+" "+preArr[1] + posArr[0]+" "+posArr[1]);
        int a = preArr[0] - posArr[0];
        int b = posArr[1] - preArr[1];

        if(a == 0 && b == 0){
            return "Infinite solutions";
        }else if(a == 0 && b != 0){
            return "No solution";
        }else{
            return "x="+ b / a;
        }
    }
    public int[] getRes(String equation){
        int coeNum = 0;// 系数
        int num = 0;   // 常数
        if(equation.charAt(0) != '+' && equation.charAt(0) != '-'){
            equation = '+' + equation;
        }
        char[] chars = equation.toCharArray();
        for(int i = 0 ; i < chars.length ; ){
            int j = i + 1;
            int coe = 1;
            while (j < equation.length() && equation.charAt(j) >= '0' && equation.charAt(j) <= '9') j++;
            if(i + 1 < j)
                coe = Integer.parseInt(equation.substring(i + 1, j));
            if(chars[i] == '-')
                coe *= -1;
            if(j < equation.length() && chars[j] == 'x'){
                coeNum += coe;
                i = j + 1;
            } else {
                num += coe;
                i = j;
            }
//            i = i == 0 ? j + 1 : j ;
        }
        return new int[]{coeNum , num};
    }
}
