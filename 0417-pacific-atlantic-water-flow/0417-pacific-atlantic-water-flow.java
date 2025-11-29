class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row & left column
        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);     // left
        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);     // top

        // Atlantic: bottom row & right column
        for (int i = 0; i < m; i++) dfs(i, n-1, heights, atlantic);  // right
        for (int j = 0; j < n; j++) dfs(m-1, j, heights, atlantic);  // bottom

        // Collect results
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < m && y >= 0 && y < n &&
                !visited[x][y] &&
                heights[x][y] >= heights[i][j]) {

                dfs(x, y, heights, visited);
            }
        }
    }
}
