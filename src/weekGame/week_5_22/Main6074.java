package weekGame.week_5_22;

import java.text.DecimalFormat;

/**
 * 6074. 字母在字符串中的百分比
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * @author Junho
 * @date 2022/5/22 10:45
 */
public class Main6074 {
    public static void main(String[] args) {
/**
 "foobar"
 "o"
 "jjjj"
 "k"
 "sgawtb"
 "s"
 */
        System.out.println(percentageLetter("sgawtb" , 's'));
        System.out.println(percentageLetter("foobar" , 'o'));
        System.out.println(percentageLetter("jjjj" , 'k'));
    }
    public static int percentageLetter(String s, char letter) {
        int num = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == letter)
                num++;
        }
        return num * 100 / s.length();
//        DecimalFormat df=new DecimalFormat("0.000");
//        String restmp = df.format((float)num / s.length());
//        int tmp = (int) ( (Double.parseDouble(restmp)) * 1000);
//        String str = "";
//        if(tmp == 0)
//            str = "000";
//        else
//            str = tmp+"";
//        return Integer.parseInt(str.substring(0 , str.length() - 1));
    }
}
