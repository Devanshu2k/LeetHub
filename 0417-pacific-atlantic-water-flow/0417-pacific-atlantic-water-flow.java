class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0) && !pacific[i][j]){
                    dfs(i,j,heights,pacific);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==m-1 || j==n-1) && !atlantic[i][j]){
                    dfs(i,j,heights,atlantic);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }

        return res;

    }

    void dfs(int i,int j,int[][] heights,boolean[][] visited){
        visited[i][j] = true;

        for(int k=0;k<4;k++){
            int newi = i+dx[k];
            int newj = j+dy[k];

            if(newi>=0 && newj>=0 && newi<m && newj<n && !visited[newi][newj] && heights[newi][newj]>=heights[i][j])
                dfs(newi,newj,heights,visited);
        }
    }


}