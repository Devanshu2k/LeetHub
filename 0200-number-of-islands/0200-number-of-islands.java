class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(grid,new int[]{i,j},visited);
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
}