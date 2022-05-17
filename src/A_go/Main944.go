package main

/**
944. 删列造序
给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
*/
func minDeletionSize(strs []string) int {
	var res int = 0
	for i := 0; i < len(strs[0]); i++ {
		for j := 0; j < len(strs); j++ {
			if j != 0 && strs[j-1][i] > strs[j][i] {
				res++
				break
			}
		}
	}
	return res
}
