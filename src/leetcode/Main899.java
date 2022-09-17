package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 *
 * @author Junho
 * @date 2022/8/9 19:50
 */
public class Main899 {
    public String orderlyQueue(String s, int k) {
        List<String> strings = new ArrayList<>();
        if( k == 1 ){
            for(int i = 0 ; i < s.length() ; i++ ){
                String pre = s.substring(0 , 1);
                String pos = s.substring(1 , s.length());
                strings.add(pos + pre);
                s = pos + pre;
            }
            Collections.sort(strings);
            return strings.get(0);
        }else{
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String res = "";
            for(char c : characters){
                res += c;
            }
            return res;
        }
    }


    public static void main(String[] args) {


//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(date);


//        String str  = "Alpha.Beta.Gamma.";
////        String regex ="\\.\\s+";
//        String regex ="\\.\\s*";
////        String regex ="\.\s+";
////        String regex = ".\s*";
//        String[] result =  str.split(regex);
//        System.out.println(result.length);

//        ArrayList<Integer>list1 = new ArrayList<>();
//        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();
//        list1.add(1);list2.add(1);
//        Class cl1= ArrayList.class;
//        Class c12 = CopyOnWriteArrayList.class;
//        Field field1  = null;
//        try {
//            field1 = cl1.getDeclaredField("elementData");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        Field field2 = null;
//        try {
//            field2 = c12.getDeclaredField("array");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        field1.setAccessible(true);
//        field2.setAccessible(true);
//        Object obj1 = null;
//        try {
//            obj1 = field1.get(list1);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Object obj2 = null;
//        try {
//            obj2 = field2.get(list2);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        list1.add(2);list2.add(2);
//        Object obj3 = null;
//        try {
//            obj3 = field1.get(list1);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Object obj4 = null;
//        try {
//            obj4 = field2.get(list2);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.print((obj1 ==obj3)+",");
//        System.out.println(obj2 ==obj4);
    }

//        public static void main(String[] args) {
//            Teacher t1 = new Teacher("张三", 25);
//            Teacher t2 = new Teacher("张四", 19);
//            Teacher t3 = new Teacher("王五", 23);
//            Teacher t4 = new Teacher("赵子", 20);
//            List<Teacher> list = new ArrayList<>();
//            list.add(t1);
//            list.add(t2);
//            list.add(t3);
//            list.add(t4);
//            System.out.println(list.stream().filter(e -> e.getAge() > 20).map(Teacher::getName).limit(2).collect(Collectors.toList()));
//        }
}

class Teacher{
    private String name;
    private Integer age;
    public Teacher(String name,Integer age) {
        this.name=name;
        this.age =age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
class Dish{


    private final String name;
    private final int calories;
    public Dish(String name,int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}