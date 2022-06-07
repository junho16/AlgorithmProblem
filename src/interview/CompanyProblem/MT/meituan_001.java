package interview.CompanyProblem.MT;

import java.util.Scanner;

/**
 * meituan-001. 小美的用户名
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 *
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 *
 * @author Junho
 * @date 2022/4/15 22:43
 */
public class meituan_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int n = Integer.parseInt(sc.next());
        for(int i = 0 ; i < n ; i++){
            String s = sc.next();
            boolean flag = true;
            if(!((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'))){
                flag = false;
            }
            int numberNum = 0;
            int chNum = 0;
            for(int j = 0 ;j < s.length() ;j++){
                if(
                    !( ( (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') ) ||
                        (s.charAt(j) >= '0' && s.charAt(j) <= '9'))
                ){
                    flag = false;
                    break;
                }
                if( (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') ){
                    chNum++;
                }
                if(  (s.charAt(j) >= '0' && s.charAt(j) <= '9')){
                    numberNum++;
                }
            }


            if(flag){
                if(numberNum == 0 || chNum == 0){
                    System.out.println("Wrong");
                }else{
                    System.out.println("Accept");
                }
            }else{
                System.out.println("Wrong");
            }
        }
    }
}
