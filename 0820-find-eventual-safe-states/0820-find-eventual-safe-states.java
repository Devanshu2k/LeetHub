class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0)
                check(i,graph,visited,pathVisited);
        }

        for(int i=0;i<n;i++){
            if(visited[i]==2)
                li.add(i);
        }

        return li;
    }

    boolean check(int curr,int[][] graph,int[] visited,int[] pathVisited){
        visited[curr]=1;
        pathVisited[curr]=1;
        for(int i:graph[curr]){
            if(visited[i]==0){
                if(check(i,graph,visited,pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[i]==1)
                return true;
        }
        
        visited[curr]=2;
        pathVisited[curr]=0;
        return false;
    }
}