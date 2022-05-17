package smallestFromLeaf

/**
我只能说一句 go刷题是真的不行

988. 从叶结点开始的最小字符串
给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。

返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。

注：字符串中任何较短的前缀在 字典序上 都是 较小 的：

例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
节点的叶节点是没有子节点的节点。
*/

func smallestFromLeaf(root *TreeNode) string {
	var min string
	var path []byte
	traverse(root, &min, path)
	return min
}
func traverse(root *TreeNode, min *string, path []byte) {
	if root == nil {
		return
	}
	path = append(path, byte(root.Val+'a'))
	// 如果是叶子节点
	if root.Left == nil && root.Right == nil {
		rev := reverse(string(path))
		if *min == "" || rev < *min {
			*min = rev
		}
		return
	}
	traverse(root.Left, min, path)
	traverse(root.Right, min, path)
}
func reverse(str string) (result string) {
	for _, v := range str {
		result = string(v) + result
	}
	return
}
