package huawei.test;

import javax.management.QueryEval;
import java.util.*;

/**
 * @author Junho
 * @date 2022/5/11 15:48
 */
public class Main_02 {
    /**
2
12*12=444
123*123=1
     */
    public static void main(String[] args) {
//        System.out.println(IsRight("12*12=144"));
//        System.out.println(IsRight("123*123=1"));
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        for(int i = 0; i < Integer.parseInt(n) ; i++){
//        for(int i = 0; i < 0 ; i++){
            String s = sc.nextLine();
//            String[] sp = s.split("*");
//            String[] sp2 = sp[1].split("=");
//            String n1 = sp[0];
//            String n2 = sp2[0];
//            String n3 = sp2[1];
            Set<String> set = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(s);
            set.add(s);
            int step = 0;
            boolean isend = false;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int k = 0 ; k < size; k++){
                    String node = queue.poll();
//                    System.out.println(node +" " +IsRight(node));
                    if(IsRight(node)){
//                        System.out.println(node +" " +IsRight(node) +" " + step);
                        System.out.println(step);
                        isend = true;
                        break;
                    }
                    for(int kk = 0 ; kk < node.length() ; kk++){
                        if((node.charAt(kk) >= '0' && node.charAt(kk) <= '9'))
                            for(int c = 0 ; c < 10 ; c++){
                                String tmp =
                                    node.substring(0 , kk) +
                                    c+"" +
                                    node.substring(kk+1 , node.length());
                                if(!set.contains(tmp)){
                                    set.add(tmp);
                                    queue.add(tmp);
                                }
                            }
                    }
                }
                step++;
                if(isend)
                    break;
            }
            System.out.println(-1);
        }

    }

    static boolean IsRight(String s){
//        System.out.println(s);
        String[] sp = s.split("\\*");
//        System.out.println(sp[0] + " " + sp[1]);
        String[] sp2 = sp[1].split("=");
        String n1 = sp[0];
        String n2 = sp2[0];
        String n3 = sp2[1];
        return Integer.parseInt(n1) * Integer.parseInt(n2) == Integer.parseInt(n3);
    }
}
