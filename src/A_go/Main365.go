package main

import (
	"math"
)

/**
有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。

如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
你可以：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
*/
func canMeasureWater(jug1Capacity int, jug2Capacity int, targetCapacity int) bool {
	queue := make([][]int, 0)
	nodeMap := make(map[int64]bool, 0)
	queue = append(queue, []int{0, 0})
	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]
		x := node[0]
		y := node[1]

		_, ok := nodeMap[hash(x, y)]
		if ok {
			continue
		}
		nodeMap[hash(x, y)] = true

		if x == targetCapacity || y == targetCapacity || x+y == targetCapacity {
			return true
		}

		queue = append(queue, []int{jug1Capacity, y})
		queue = append(queue, []int{x, jug2Capacity})
		queue = append(queue, []int{0, y})
		queue = append(queue, []int{x, 0})
		queue = append(queue, []int{x - int(math.Min(float64(x), float64(jug2Capacity-y))), y + int(math.Min(float64(x), float64(jug2Capacity-y)))})
		queue = append(queue, []int{x + int(math.Min(float64(y), float64(jug1Capacity-x))), y - int(math.Min(float64(y), float64(jug1Capacity-x)))})

	}
	return false
}
func hash(x int, y int) int64 {
	return int64(x)*1000001 + int64(y)
}

/**
hash太多不行 超时
hash用字符串不行 超时
需要自定义个int64的hash
*/
//func canMeasureWater(jug1Capacity int, jug2Capacity int, targetCapacity int) bool {
//	queue := make([][]int, 0)
//	nodeMap := make(map[string]bool, 0)
//	queue = append(queue, []int{0, 0})
//	for len(queue) > 0 {
//		node := queue[0]
//		queue = queue[1:]
//		x := node[0]
//		y := node[1]
//
//		if x+y == targetCapacity {
//			return true
//		}
//		_, ok := nodeMap[strconv.Itoa(jug1Capacity)+" "+strconv.Itoa(y)]
//		if !ok {
//			queue = append(queue, []int{jug1Capacity, y})
//			nodeMap[strconv.Itoa(jug1Capacity)+" "+strconv.Itoa(y)] = true
//		}
//
//		_, ok = nodeMap[strconv.Itoa(x)+" "+strconv.Itoa(jug2Capacity)]
//		if !ok {
//			queue = append(queue, []int{x, jug2Capacity})
//			nodeMap[strconv.Itoa(x)+" "+strconv.Itoa(jug2Capacity)] = true
//		}
//
//		_, ok = nodeMap[strconv.Itoa(0)+" "+strconv.Itoa(y)]
//		if !ok {
//			queue = append(queue, []int{0, y})
//			nodeMap[strconv.Itoa(0)+" "+strconv.Itoa(y)] = true
//		}
//
//		_, ok = nodeMap[strconv.Itoa(x)+" "+strconv.Itoa(0)]
//		if !ok {
//			queue = append(queue, []int{x, 0})
//			nodeMap[strconv.Itoa(x)+" "+strconv.Itoa(0)] = true
//		}
//
//		_, ok = nodeMap[strconv.Itoa(x-int(math.Min(float64(x), float64(jug2Capacity-y))))+" "+strconv.Itoa(y+int(math.Min(float64(x), float64(jug2Capacity-y))))]
//		if !ok {
//			queue = append(queue, []int{x - int(math.Min(float64(x), float64(jug2Capacity-y))), y + int(math.Min(float64(x), float64(jug2Capacity-y)))})
//			nodeMap[strconv.Itoa(x-int(math.Min(float64(x), float64(jug2Capacity-y))))+" "+strconv.Itoa(y+int(math.Min(float64(x), float64(jug2Capacity-y))))] = true
//		}
//
//		_, ok = nodeMap[strconv.Itoa(x+int(math.Min(float64(y), float64(jug1Capacity-x))))+" "+strconv.Itoa(y-int(math.Min(float64(y), float64(jug1Capacity-x))))]
//		if !ok {
//			queue = append(queue, []int{x + int(math.Min(float64(y), float64(jug1Capacity-x))), y - int(math.Min(float64(y), float64(jug1Capacity-x)))})
//			nodeMap[strconv.Itoa(x+int(math.Min(float64(y), float64(jug1Capacity-x))))+" "+strconv.Itoa(y-int(math.Min(float64(y), float64(jug1Capacity-x))))] = true
//		}
//		//queue = append(queue, []int{x - int(math.Min(float64(x), float64(jug2Capacity-y))), y + int(math.Min(float64(x), float64(jug2Capacity-y)))})
//		//queue = append(queue, []int{x + int(math.Min(float64(y), float64(jug1Capacity-x))), y - int(math.Min(float64(y), float64(jug1Capacity-x)))})
//
//	}
//	return false
//}
