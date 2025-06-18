class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int countFresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    continue;
                }
                if(grid[i][j]==1)
                    countFresh++;
            }
        }

        if(q.isEmpty()) 
            return countFresh!=0?-1:0;
        
        int[] dx = {-1,0,+1,0};
        int[] dy = {0,-1,0,+1};
        int count=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                int[] temp = q.poll();
                int tempRow = temp[0];
                int tempCol = temp[1];
                for(int i=0;i<4;i++){
                    int newRow = tempRow+dx[i];
                    int newCol = tempCol+dy[i];

                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        countFresh--;
                        q.offer(new int[]{newRow,newCol});
                    }
                }
            }
            count++;
        }

        return  countFresh==0?count-1:-1;
    }
}