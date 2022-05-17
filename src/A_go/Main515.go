package main

import (
	"math"
)

/**
515. 在每个树行中找最大值
给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
*/
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var (
	minValue = ^int(^uint(0) >> 1)
)

func largestValues(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) > 0 {
		size := len(queue)
		max := minValue
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			max = int(math.Max((float64(max)), (float64(node.Val))))
		}
		res = append(res, max)
	}
	return res
}
