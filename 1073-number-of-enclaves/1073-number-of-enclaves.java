class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(!visited[i][0] && grid[i][0]==1){
                q.offer(new int[]{i,0});
                visited[i][0]=true;
            }
            if(!visited[i][n-1] && grid[i][n-1]==1){
                q.offer(new int[]{i,n-1});
                visited[i][n-1]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[0][i] && grid[0][i]==1){
                q.offer(new int[]{0,i});
                visited[0][i]=true;
            }
            if(!visited[m-1][i] && grid[m-1][i]==1){
                q.offer(new int[]{m-1,i});
                visited[m-1][i]=true;
            }
        }

        int[] dx = {-1,0,+1,0};
        int[] dy = {0,-1,0,+1};

        while(!q.isEmpty()){
            
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();

            for(int k=0;k<4;k++){
                int newI = i+dx[k];
                int newJ = j+dy[k];

                if(newI>=0  && newI<m && newJ>=0 && newJ<n && !visited[newI][newJ] && grid[newI][newJ]==1){
                    visited[newI][newJ]=true;
                    q.offer(new int[]{newI,newJ});
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1)
                    count++;
            }
        }

        return count;
    }
}