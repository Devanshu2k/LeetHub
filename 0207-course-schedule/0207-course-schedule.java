class Solution {

    List<Integer>[] convertToAdjList(int[][] prerequisites,int n){
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] dep:prerequisites){
            adjList[dep[0]].add(dep[1]);
        }

        return adjList;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList =  convertToAdjList(prerequisites,numCourses);
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && dfs(i,adjList,visited,pathVisited))
                return false;
        }

        return true;
    }

    boolean dfs(int curr,List<Integer>[] adjList,boolean[] visited,boolean[] pathVisited){
        visited[curr] = true;
        pathVisited[curr] = true;

        for(int dep : adjList[curr]){
                if(!visited[dep]){
                    if(dfs(dep,adjList,visited,pathVisited))
                        return true;
                }
                else if(pathVisited[dep])
                    return true;
        }

        pathVisited[curr]=false;
        return false;
    }
}