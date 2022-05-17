package main

/**
463. 岛屿的周长
给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。

网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
*/
var (
	fx_x = []int{0, 1, -1, 0}
	fx_y = []int{1, 0, 0, -1}
	flag [][]bool
	res  int = 0
	//m行 n列
	m       int
	n       int
	gridTmp [][]int
)

func islandPerimeter(grid [][]int) int {
	res = 0
	gridTmp = grid
	m = len(grid)
	n = len(grid[0])
	flag = make([][]bool, m)
	for i := range flag {
		flag[i] = make([]bool, n)
	}

	for i, item_i := range grid {
		for j, item_j := range item_i {
			if item_j == 1 && !flag[i][j] {
				flag[i][j] = true
				dfs(i, j)
			}
		}
	}
	return res
}

func dfs(x int, y int) {
	for i := 0; i < 4; i++ {
		a := x + fx_x[i]
		b := y + fx_y[i]
		if a >= 0 && a < m && b >= 0 && b < n && gridTmp[a][b] == 0 {
			res++
		} else if a < 0 || b < 0 || a >= m || b >= n {
			res++
		}
	}
	for i := 0; i < 4; i++ {
		a := x + fx_x[i]
		b := y + fx_y[i]
		if a >= 0 && a < m && b >= 0 && b < n && !flag[a][b] && gridTmp[a][b] == 1 {
			flag[a][b] = true
			dfs(a, b)
		}
	}
}
