package lc_2_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Junho
 * @date 2022/5/23 17:27
 */
public class Main17 {
    public List<String> letterCombinations(String digits) {
        String[] digitsMap = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
        List<String> strings = new ArrayList<>();
        for(int i = 0 ; i < digits.length() ; i++){
            String chars = digitsMap[digits.charAt(i) - '0'];
            if(strings.size() == 0){
                for(int k = 0 ; k < chars.length() ;k++ ){
                    strings.add(chars.charAt(k)+"");
                }
            }else{
                List<String> tmp = new ArrayList<>();
                for(String s : strings){
                    for(int k = 0 ; k < chars.length() ;k++ ){
                        tmp.add(s + chars.charAt(k));
                    }
                }
                strings = new ArrayList<>(tmp);
            }
        }
        return strings;
    }

/**
 *  dfs回溯做法
    List<String> res = new ArrayList<>();
    String[] strs = { "", "", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return new ArrayList();
        dfs(digits, 0 , "");
        return res;
    }
    public void dfs(String digits , int index , String path){
        if(index == digits.length()){
            res.add(path);
            return;
        }
        for(int i = 0 ; i < strs[Integer.parseInt(""+digits.charAt(index))].length() ; i++){
            dfs(digits, index+1 , path +  strs[Integer.parseInt(""+digits.charAt(index))].charAt(i) );
        }
    }
 */
}
