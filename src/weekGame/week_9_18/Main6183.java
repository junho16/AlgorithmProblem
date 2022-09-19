package weekGame.week_9_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 想走捷径超时的
 * 6183. 字符串的前缀分数和
 * 给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。
 * 定义字符串 word 的 分数 等于以 word 作为 前缀 的 words[i] 的数目。
 * 例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 "abc" 的一个前缀。
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。
 *
 * 注意：字符串视作它自身的一个前缀。
 * @author Junho
 * @date 2022/9/18 11:02
 */
class Node {
    int idx;//str编号
    int count;
    public Node(int a , int b ){
        this.idx =a;
        this.count = b;
    }
}
public class Main6183 {
    public int[] sumPrefixScores(String[] words) {
        Map<String , Node> map = new HashMap<>();
        Map<Integer , List<Node>> preMap = new HashMap<>();
        int idx = 0;
        for(int i = 0 ; i < words.length ; i++){
            String s = "";
            for(int j = 0 ; j < words[i].length() ; j++){
                s += words[i].charAt(j);
                if(!map.containsKey(s)){
                    Node node = new Node(idx , 1);

                    List<Node> list = preMap.getOrDefault(i , new ArrayList<>());
                    list.add(node);
                    preMap.put(i , list);

                    map.put(s , node);
                    idx++;
                }else{
                    Node node = map.get(s);
                    node.count += 1; //, map.getOrDefault(s , new Node) + 1
                    map.put(s , node);

                    List<Node> list = preMap.getOrDefault(i , new ArrayList<>());
                    list.add(node);
                    preMap.put(i , list);
                }
//                map.put(s , map.getOrDefault(s , new Node) + 1);



            }
        }
        int[] res = new int[words.length];
        for(int i = 0 ; i < words.length ; i++){
            int sum = 0;

            List<Node> list = preMap.get(i);
            for(int j = 0 ; j < list.size() ; j++){
//                s += words[i].charAt(j);
//                String s = words[i].substring(0 , j);
                sum += map.get(list.get(j)).count;
            }
//            String s = "";
//            for(int j = 0 ; j <= words[i].length() ; j++){
//                s += words[i].charAt(j);
////                String s = words[i].substring(0 , j);
//                sum += map.get(s);
//            }
            res[i] = sum;
        }
        return res;
    }
//    public int[] sumPrefixScores(String[] words) {
//        Map<String , Integer> map = new HashMap<>();
//        Map<Integer , List<String>> preMap = new HashMap<>();
//        for(int i = 0 ; i < words.length ; i++){
//            String s = "";
//            for(int j = 0 ; j < words[i].length() ; j++){
////                String s = words[i].substring(0 , j);
//                s += words[i].charAt(j);
//                map.put(s , map.getOrDefault(s , 0) + 1);
//
//                List<String> list = preMap.getOrDefault(i , new ArrayList<>());
//                list.add(s);
//                preMap.put(i , list);
//
//            }
//        }
//        int[] res = new int[words.length];
//        for(int i = 0 ; i < words.length ; i++){
//            int sum = 0;
//
//            List<String> list = preMap.get(i);
//            for(int j = 0 ; j < list.size() ; j++){
////                s += words[i].charAt(j);
////                String s = words[i].substring(0 , j);
//                sum += map.get(list.get(j));
//            }
////            String s = "";
////            for(int j = 0 ; j <= words[i].length() ; j++){
////                s += words[i].charAt(j);
//////                String s = words[i].substring(0 , j);
////                sum += map.get(s);
////            }
//            res[i] = sum;
//        }
//        return res;
//    }
}
