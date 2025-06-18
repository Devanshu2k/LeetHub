class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
                if(color[i]==0 && check(i,graph,color) == false)
                    return false;
        }
        return true;
    }

    boolean check(int node,int[][] graph,int[] color){       
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node]=1;

        while(!q.isEmpty()){
            int i = q.poll();
            for(int adj:graph[i]){
                if(color[adj]==0){
                    q.offer(adj);
                    color[adj]=color[i]*-1;
                }
                else if(color[adj]==color[i]){
                        return false;
                }
            }
        }

        return true;
    }

}
