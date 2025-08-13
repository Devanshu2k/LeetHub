class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    void bfs(char[][] grid,int[] pos,boolean[][] visited){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(pos);
        visited[pos[0]][pos[1]] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0;i<4;i++){
                int newX = temp[0]+dx[i];
                int newY = temp[1]+dy[i];

                if(newX>=0 && newX<m && newY>=0 && newY<n && !visited[newX][newY] && grid[newX][newY]=='1'){
                    visited[newX][newY]=true;
                    q.offer(new int[]{newX,newY});
                }
            }
        }
    }

    void dfs(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0')  
            return;
        
        grid[i][j] = '0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);        
    }
}