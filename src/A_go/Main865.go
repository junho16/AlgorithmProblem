package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func subtreeWithAllDeepest(root *TreeNode) *TreeNode {
	res, _ := getSubtreeWithAllDeepest(root)
	return res
}

func getSubtreeWithAllDeepest(node *TreeNode) (*TreeNode, int) {
	if node == nil {
		return nil, 0
	} else {
		nodeLeft, depthLeft := getSubtreeWithAllDeepest(node.Left)
		nodeRight, depthRight := getSubtreeWithAllDeepest(node.Right)
		if depthLeft == depthRight {
			return node, depthLeft + 1
		} else if depthLeft > depthRight {
			return nodeLeft, depthLeft + 1
		} else {
			return nodeRight, depthRight + 1
		}
	}
}
