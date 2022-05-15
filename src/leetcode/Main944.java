package leetcode;

/**
 * 944. 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * 返回你需要删除的列数。
 *
 * @author Junho
 * @date 2022/5/12 21:21
 */
public class Main944 {

    /**
     *  用go写了一份
     *  package main
     *
     * import "math"
     *
     * func oneEditAway(first string, second string) bool {
     * 	dis := len(first) - len(second)
     * 	if math.Abs(float64(dis)) >= 2 {
     * 		return false
     *        }
     * 	if math.Abs(float64(dis)) == 1 {
     * 		//保证first是较长的一个
     * 		if len(first) < len(second) {
     * 			tmp := first
     * 			first = second
     * 			second = tmp
     *        }
     * 		for i := 0; i < len(second); i++ {
     * 			if first[i] != second[i] {
     * 				s1 := first[0:i] + first[i+1:len(first)]
     * 				if s1 == second {
     * 					return true
     *                } else {
     * 					return false
     *                }
     *            }
     *        }
     * 		return true
     *    }
     * 	if len(first) == len(second) {
     * 		num := 0
     * 		for i := 0; i < len(first); i++ {
     * 			if first[i] != second[i] {
     * 				num++
     * 				if num > 1 {
     * 					return false
     *                }
     *            }
     *        }
     * 		return true
     *    }
     * 	return true
     * }
     */
}
