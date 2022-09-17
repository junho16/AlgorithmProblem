package leetcode;

/**
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Junho
 * @date 2022/8/17 16:21
 */
class Person{
    public static Person person = new Person();
    public static int a ;
    public static int b = 0;
    private Person(){
        a=5;
        b=5;
    }
    public static Person getInstance(){
        return person;
    }
}
public class Main641 {

    public static void main(String[] args) {
        Person myClass = Person.getInstance();
        System.out.println(myClass.a);
        System.out.println(myClass.b);
    }

//    public Main641(int k) {
//
//    }
//
//    public boolean insertFront(int value) {
//
//    }
//
//    public boolean insertLast(int value) {
//
//    }
//
//    public boolean deleteFront() {
//
//    }
//
//    public boolean deleteLast() {
//
//    }
//
//    public int getFront() {
//
//    }
//
//    public int getRear() {
//
//    }
//
//    public boolean isEmpty() {
//
//    }
//
//    public boolean isFull() {
//
//    }
}
