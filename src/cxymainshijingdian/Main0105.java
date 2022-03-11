package cxymainshijingdian;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class Main0105 {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second))
            return true;

        if(Math.abs(first.length() - second.length()) > 1)
            return false;


        if(first.length() == second.length()){
            int errNum = 0 ;
            for(int i = 0 ; i < first.length() ; i++){
                if(first.charAt(i) != second.charAt(i)){
                    errNum++;
                    if(errNum > 1)
                        return false;
                }
            }
            return true;
        }

        if(first.length() > second.length() ){
            String tmp = second;
            second = first;
            first = tmp;
        }
        int cnt = 0 , i =0 ;
        while (i < first.length()){
            if(first.charAt(i) != second.charAt(i+cnt)){
                cnt++;
                if(cnt > 1)
                    return false;
            }else{
                i++;
            }
        }
        return true;
    }
}
