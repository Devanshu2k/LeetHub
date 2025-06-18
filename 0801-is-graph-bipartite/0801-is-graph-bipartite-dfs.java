class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
                if(!visited[i] && !check(i,visited,graph,1,dp))
                    return false;
        }

        return true;
    }

    boolean check(int node,boolean[] visited,int[][] graph,int col,int[] dp){       
        visited[node]=true;
        dp[node] = col;
        for(int i:graph[node]){
            if(!visited[i]){
                if(!check(i,visited,graph,-1*col,dp))
                    return false;
            }
            else if(dp[i]==col)
                return false;
        }

        return true;
    }

}
