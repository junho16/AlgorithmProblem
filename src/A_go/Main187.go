package main

/**
187. 重复的DNA序列
DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。

例如，"ACGAATTCCG" 是一个 DNA序列 。
在研究 DNA 时，识别 DNA 中的重复序列非常有用。

给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。

==》有一说一 go没有集合可以使用真的有点难受的
*/
func findRepeatedDnaSequences(s string) []string {
	res := make([]string, 0)
	dna := make(map[string]int)
	set := make(map[string]bool)
	for i := 0; i <= len(s)-10; i++ {
		dna[s[i:i+10]]++
		if dna[s[i:i+10]] >= 2 {
			if !set[s[i:i+10]] {
				set[s[i:i+10]] = true
				res = append(res, s[i:i+10])
			}
		}
	}
	return res
}
