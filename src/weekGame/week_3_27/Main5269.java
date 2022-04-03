package weekGame.week_3_27;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.List;

/**
 * 没有考虑某一个栈里一个都不取的情况
 *
 * @author Junho
 * @date 2022/3/27 11:23
 */
public class Main5269 {
    int k;

    LinkedList<LinkedList<Integer>> pilesLink;
    int res = 0;
    public int maxValueOfCoins(List<List<Integer>> piles, int kk) {
        pilesLink = new LinkedList<>();
        for(List<Integer> l : piles){
            LinkedList t = new LinkedList();
            for(Integer i : l){
                t.add(i);
            }
            pilesLink.add(t);
        }
        k = kk;
        dfs(pilesLink , k , 0);
        return res;
    }
    void dfs(LinkedList<LinkedList<Integer>> piles , int k ,int sum){
        if(k <= 0){
            res = Math.max(res , sum);
            return;
        }
        for(int i = 0; i < pilesLink.size() ;i++){
            if(! (pilesLink.get(i).size() == 0)){
                for(int j = 0; j < pilesLink.get(i).size() ; j++){
//                    LinkedList<LinkedList<Integer>> tmp = new LinkedList<>(piles);
                    int tmp = pilesLink.get(i).getFirst();
                    int nextSum = sum + tmp;
                    pilesLink.get(i).removeFirst();
                    dfs(null , k - 1 ,  nextSum);
                    pilesLink.get(i).addFirst(tmp);
                }
            }
        }
//        for(int i = 0; i < piles.size() ;i++){
//            if(! (piles.get(i).size() == 0)){
//                for(int j = 0; j < piles.get(i).size() ; j++){
//                    LinkedList<LinkedList<Integer>> tmp = new LinkedList<>(piles);
//                    int nextSum = sum + tmp.get(i).getFirst();
//                    tmp.get(i).removeFirst();
//                    dfs(tmp , k - 1 ,  nextSum);
//                }
//            }
//        }
    }
}
