package leetcode;

import java.util.*;

/**
 * 433. 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * @author Junho
 * @date 2022/5/10 14:21
 */
public class Main433 {
    public static void main(String[] args) {
        System.out.println(new Main433().minMutation(
                "AACCGGTT" ,
                "AAACGGTA" ,
                new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}
        ));

    }
//    "AACCGGTT"
//    "AAACGGTA"
//    ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]
//            "AACCGGTT"
//            "AACCGGTA"
//            []
//            "AACCGGTT"
//            "AACCGGTA"
//            ["AACCGGTA"]
//            "AACCGGTT"
//            "AAACGGTA"
//            ["AACCGGTA","AACCGCTA","AAACGGTA"]
//            "AAAAACCC"
//            "AACCCCCC"
//            ["AAAACCCC","AAACCCCC","AACCCCCC"]


    public int minMutation(String start, String end, String[] b) {
        List<String > bank = new ArrayList<>();
        int res = 0;
        for(String ss : b){
            bank.add(ss);
        }
        String change = "ACGT";
        Queue<String> queue = new LinkedList();
        queue.add(start);
        Set<String> set = new HashSet<>();
        while (! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                String node = queue.poll();
                if(node.equals(end)){
                    return res;
                }
                for(int j = 0 ; j < node.length() ; j++){
                    for(int k = 0 ; k < 4 ; k++){
                        String tmp =
                                node.substring(0 , j) +
                                        change.charAt(k) +
                                        node.substring(j + 1 ,node.length());
                        if(bank.contains(tmp) && !set.contains(tmp)){
                            set.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

//    List<String > bank = new ArrayList<>();
//    String start;
//    String end;
//    int res = Integer.MAX_VALUE;
//    public int minMutation(String s, String e, String[] b) {
//        start = s;
//        end = e;
//        for(String ss : b){
//            bank.add(ss);
//        }
//        dfs(s , 0, 0 );
//
//        String sb_s = new StringBuilder(s).reverse().toString();
//        String sb_e = new StringBuilder(e).reverse().toString();
//        bank = new ArrayList<>();
//        for(String ss : b){
//            bank.add( new StringBuilder(ss).reverse().toString() );
//        }
//        start = sb_s;
//        end = sb_e;
//        dfs(start  ,0 , 0 );
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }
//    void dfs(String s , int idx , int count){
//        if(idx == s.length()){
//            if(s.equals(end) && bank.contains(s) )
//                res = Math.min(res , count);
//            return;
//        }
//        String change = "ACGT";
//        if(bank.contains(s) || start.equals(s)){
//            if(s.equals(end))
//                res = Math.min(res , count);
//
//
//            for(int i = 0 ; i < 4 ; i++){
//                if(change.charAt(i) != s.charAt(idx)){
//                    String tmp =
//                            s.substring( 0 , idx) +  change.charAt(i) + s.substring(idx+1 ,s.length());
//                    dfs(tmp , idx + 1 , count + 1);
//                }else{
//                    String tmp = s;
//                    dfs(tmp ,idx + 1 , count );
//                }
//            }
//
//        }
//    }
}
