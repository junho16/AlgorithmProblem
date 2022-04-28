package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Junho
 * @date 2022/4/23 14:48
 */
public class Main937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> listDig  = new ArrayList<>();
        List<String> listStr  = new ArrayList<>();
        for(int i = 0 ; i < logs.length ; i++){
            String[] strings = logs[i].split(" ");
            for(int j = 0 ; j < strings[1].length() ; j++){
                if(strings[1].charAt(0) >= '0' && strings[1].charAt(0) <= '9'){
                    listDig.add(logs[i]);
                }else{
                    listStr.add(logs[i]);
                }
                break;
            }
        }
        Collections.sort(listStr , new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0 , j = 0;
                while(i < o1.length() && o1.charAt(i) != ' ')
                    i++;
                while(j < o2.length() && o2.charAt(j) != ' ')
                    j++;
                String s1_1 = o1.substring(0 , i);
                String s1_2 = o1.substring(i , o1.length());
                String s2_1 = o2.substring(0 , j);
                String s2_2 = o2.substring(j , o2.length());
                if(s1_2.compareTo(s2_2) == 0){
                    return s1_1.compareTo(s2_1);
                }
                return s1_2.compareTo(s2_2);
            }
        });
        listStr.addAll(listDig);
        int idx = 0 ;
        String[] res = new String[listStr.size()];
        for(String s : listStr){
            res[idx++] = s;
        }

        return res;
    }
}