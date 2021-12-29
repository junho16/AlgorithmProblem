package offer;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 */
public class Main678 {
    /**
     * 神奇的做法，也是最正经的做法，优雅的做法，grace，
     * 因为维护了一个low和high，来代替原来的cnt
     * 以前的cnt是左括号-- 右括号++ 一旦中间出现了负值则返回false，最后判断值是否为0
     * 现在是维护一个low和一个high 来判断遍历之后最小值是否可以为0；
     * 如果遇到* 则可以随意变换，比如变成左右括号，按照正常括号维护low和high就可以了
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for(int i= 0 ; i < s.length() ;i++ ){
            if(s.charAt(i) == '('){
                low++;
                high++;
            }else if(s.charAt(i) == ')'){
                low--;
                high--;
            }else{
                low--;
                high++;
            }
            low = Math.max(0 , low);
            if(low > high)
                return false;
        }
        if(low == 0)
            return true;
        else
            return false;
    }
//    public boolean checkValidString(String s) {
//        Stack<Character> stack = new Stack<>();
//        char tar = '*';
//        int lNum = 0;
//        int rNum = 0;
//        for(int i = 0 ; i < s.length() ;i++){
//            if(s.charAt(i) == '(') lNum++;
//            else rNum++;
//        }
//
//        if(lNum > rNum){
//            tar = ')';
//        }else if(lNum < rNum){
//            tar = '(';
//        }
//        for(int i = 0 ; i < s.length() ;i++ ){
//            if(s.charAt(i) == '(')
//                stack.add('(');
//            else if(s.charAt(i) == '*' && tar == '(')
//                stack.add('(');
//            else if(s.charAt(i) == ')' || (s.charAt(i) == '*' && tar == ')')){
//                stack.pop();
//            }
//        }
//        if(stack.isEmpty())
//            return true;
//        else{
//            return false;
//        }
//    }
}
