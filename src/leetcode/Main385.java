//package leetcode;
//
//import java.util.List;
//import java.util.Stack;
//
///**
// * @author Junho
// * @date 2022/4/15 15:03
// */
//public class Main385 {
//
//    public NestedInteger deserialize(String s) {
//        Stack<NestedInteger> stack = new Stack<>();
//        Stack<String> stackStr = new Stack<>();
//        for(int i = 0 ;i < s.length(); ){
//            if(s.charAt(i) == '['){
//                stackStr.push("[");
//                i++;
//            }
//            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//                int k = i;
//                while (k + 1 < s.length() && s.charAt(k + 1) >= '0' && s.charAt(k + 1) <= '9')
//                    k++;
//                stackStr.push(s.substring(i , k+1));
//                stack.push( new NestedInteger(Integer.parseInt(s.substring(i  ,k + 1))));
//                i = k+1;
//            }else if(s.charAt(i) == ']'){
//                while (!stack.peek().equals("[")){
//
//                }
//                i++;
//            }
//        }
//
//        for(String ss : stackStr){
//            System.out.println(ss);
//        }
//        return null;
//    }
//
//}
//class NestedInteger extends NInteger {
//
//    public NestedInteger(int val){
//
//    }
//
//    @Override
//    public boolean isInteger() {
//        return false;
//    }
//
//    @Override
//    public Integer getInteger() {
//        return null;
//    }
//
//    @Override
//    public void setInteger(int value) {
//
//    }
//
//    @Override
//    public void add(NestedInteger ni) {
//
//    }
//
//    @Override
//    public List<NestedInteger> getList() {
//        return null;
//    }
//}
//
//abstract class NInteger {
//    // Constructor initializes an empty nested list.
//    public NInteger(){
//
//    }
//
//    // Constructor initializes a single integer.
//    public NInteger(int value){
//
//    }
//
//    // @return true if this NestedInteger holds a single integer, rather than a nested list.
//    public abstract boolean isInteger();
//
//    // @return the single integer that this NestedInteger holds, if it holds a single integer
//    // Return null if this NestedInteger holds a nested list
//    public abstract Integer getInteger();
//
//    // Set this NestedInteger to hold a single integer.
//    public abstract void setInteger(int value);
//
//    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//    public abstract void add(NestedInteger ni);
//
//    // @return the nested list that this NestedInteger holds, if it holds a nested list
//    // Return empty list if this NestedInteger holds a single integer
//    public abstract List<NestedInteger> getList();
//}
//class Solution {
////    static NestedInteger ph = new NestedInteger(0);
////    public NestedInteger deserialize(String s) {
////        Deque<NestedInteger> d = new ArrayDeque<>();
////        char[] cs = s.toCharArray();
////        int n = cs.length, i = 0;
////        while (i < n) {
////            if (cs[i] == ',' && ++i >= 0) continue;
////            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
////                int j = cs[i] == '-' ? i + 1 : i, num = 0;
////                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) num = num * 10 + (cs[j++] - '0');
////                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
////                i = j;
////            } else if (cs[i] == '[') {
////                d.addLast(new NestedInteger());
////                d.addLast(ph);
////                i++;
////            } else {
////                List<NestedInteger> list = new ArrayList<>();
////                while (!d.isEmpty()) {
////                    NestedInteger poll = d.pollLast();
////                    if (poll == ph) break;
////                    list.add(poll);
////                }
////                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
////                i++;
////            }
////        }
////        return d.peekLast();
////    }
////}