package main

/**
面试题 04.06. 后继者
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回null。
*/
func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val <= p.Val {
		return inorderSuccessor(root.Right, p)
	} else {
		//注意 就算有左子树 答案也可能是其自己本身 如第一个样例所示 左子树只有一个目标节点
		//则目标节点后继就是其本身
		if root.Left == nil {
			return root
		} else {
			var ans *TreeNode = inorderSuccessor(root.Left, p)
			if ans == nil {
				return root
			} else {
				return ans
			}
		}
		//var ans *TreeNode = inorderSuccessor(root.Left, p)
		//if ans == nil {
		//	return root
		//} else {
		//	return ans
		//}

		//if root.Left == nil {
		//	return root
		//} else if root.Right == nil {
		//	return nil
		//} else {
		//	return inorderSuccessor(root.Right)
		//}
	}
}
