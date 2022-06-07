package interview.huawei.L5_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/5/18 20:18
 */
public class Main03 {

    /**
zhang san,zhang han san,wei zhan san
zhs

zhang guo,zhai an guo,zhai guo,zhai hai guo
zhag
     *
     */
    static List<List<String>> targetList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = sc.nextLine();
        String[] strings = s.split(",");

        String res = "";

//        for(List<String> list: targetList){
//            for(String ss : list){
//                System.out.print(ss+" ");
//            }
//            System.out.println();
//        }
        for(int i = 0 ; i < strings.length ;i++){
            String[] itemStringArr = strings[i].split(" ");
            targetList = new ArrayList<>();
            dfs(0 , itemStringArr.length,  target , new ArrayList<>());

            for(List<String> taritem : targetList){
                boolean flag = true;
                for(int k = 0;k < taritem.size() ; k++ ){
                    if(itemStringArr[k].indexOf(taritem.get(k)) != 0 ){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res += strings[i]+",";
                    break;
                }
            }
        }
        System.out.println(res.substring(0 , s.length()));
    }
    static void dfs(int index , int n , String target  ,List<String> list){
        if(list.size() == n){
            if(index == target.length()){
                targetList.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = index; i < target.length() ;i++){
            String s = target.substring(index , i+1);
            List<String> tmp = new ArrayList<>(list);
            tmp.add(s);
            dfs(i+1 , n ,  target , tmp);
        }
    }
}
