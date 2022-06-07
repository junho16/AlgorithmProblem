package interview.huawei.L5_18;

import java.util.*;

/**
 * @author Junho
 * @date 2022/5/18 19:03
 */
class Node{
    int huase;
    int val;
    public Node(int huase , int val){
        this.huase = huase;
        this.val = val;
    }
}

public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer , List<Node>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int h = sc.nextInt();
            int v = sc.nextInt();
            if(map.containsKey(v)){
                List<Node> list = map.get(v);
                list.add(new Node(h , v));
                map.put(v , list);
            }else{
                //如果没有 则new put
                List<Node> list = new ArrayList<>();
                list.add(new Node(h , v));
                map.put(v , list);
            }
        }
        List<Map.Entry<Integer , List<Node>>> reSortList = new ArrayList<Map.Entry<Integer , List<Node>>>(map.entrySet());
        Collections.sort(reSortList, new Comparator<Map.Entry<Integer, List<Node>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<Node>> o1, Map.Entry<Integer, List<Node>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        List<List<Node>> zhadan = new ArrayList<>();
        List<List<Node>> duizi = new ArrayList<>();
        List<List<Node>> dan = new ArrayList<>();

        for(int i = 0; i < reSortList.size() ; i++){
            Map.Entry entry = reSortList.get(i);
            List<Node> list = (List<Node>) entry.getValue();
            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.huase - o2.huase;
                }
            });
//            if(i == 0)
//                for(Node node : list){
//                    System.out.print(node.huase+" ");
//                }
            if(list.size() == 4){
                zhadan.add(new ArrayList<>(list));
            }
            if(list.size() == 3){
                List<Node> tmp = new ArrayList<>();
                tmp.add(list.get(0));
                tmp.add(list.get(1));
                List<Node> tmp2 = new ArrayList<>();
                tmp.add(list.get(2));
                duizi.add(new ArrayList<>(tmp));
                dan.add(new ArrayList<>(tmp2));
            }
            if(list.size() == 2){
                duizi.add(new ArrayList<>(list));
            }
            if(list.size() == 1){
                dan.add(new ArrayList<>(list));
            }
        }
        if(zhadan.size() != 0){
            Collections.sort(zhadan, new Comparator<List<Node>>() {
                @Override
                public int compare(List<Node> o1, List<Node> o2) {
                    return o1.get(0).val - o2.get(0).val;
                }
            });
            for(int i = 0; i < zhadan.size() ;i++){
                List<Node> out = zhadan.get(i);
                for(Node outNode : out){
                    System.out.println(outNode.huase+" "+outNode.val);
                }
            }
        }
        if(duizi.size() != 0){
            Collections.sort(duizi, new Comparator<List<Node>>() {
                @Override
                public int compare(List<Node> o1, List<Node> o2) {
                    return o1.get(0).val - o2.get(0).val;
                }
            });
            for(int i = 0; i < duizi.size() ;i++){
                List<Node> out = duizi.get(i);
                for(Node outNode : out){
                    System.out.println(outNode.huase+" "+outNode.val);
                }
            }
        }
        if(dan.size() != 0){
            Collections.sort(dan, new Comparator<List<Node>>() {
                @Override
                public int compare(List<Node> o1, List<Node> o2) {
                    return o1.get(0).val - o2.get(0).val;
                }
            });
            for(int i = 0; i < dan.size() ;i++){
                List<Node> out = dan.get(i);
                for(Node outNode : out){
                    System.out.println(outNode.huase+" "+outNode.val);
                }
            }
        }
//        for(Map.Entry entry: reSortList){
//            List<Node> list = (List<Node>) entry.getValue();
//            for(Node node : list){
//                System.out.print(node.val+" ");
//            }
//            System.out.println();
//        }
    }
}
