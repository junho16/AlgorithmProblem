package main

/**
207. 课程表
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false
*/
func canFinish(numCourses int, prerequisites [][]int) bool {
	var (
		edge = make([][]int, numCourses)
		idx  = make([]int, numCourses)
	)
	for _, info := range prerequisites {
		edge[info[1]] = append(edge[info[1]], info[0])
		idx[info[0]]++
	}
	queue := []int{}
	count := numCourses
	for i := 0; i < numCourses; i++ {
		if idx[i] == 0 {
			count--
			queue = append(queue, i)
		}
	}
	for len(queue) > 0 {
		u := queue[0]
		queue = queue[1:len(queue)]
		for _, v := range edge[u] {
			idx[v]--
			if idx[v] == 0 {
				count--
				queue = append(queue, v)
			}
		}
	}
	return count == 0
}
