class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i,prerequisites,visited,pathVisited))
                return false;
        }

        return true;
    }

    boolean dfs(int curr,int[][] prerequisites,boolean[] visited,boolean[] pathVisited){
        visited[curr] = true;
        pathVisited[curr] = true;

        for(int[] dep : prerequisites){
            if(dep[0]==curr){
                if(!visited[dep[1]]){
                    if(dfs(dep[1],prerequisites,visited,pathVisited))
                        return true;
                }
                else if(pathVisited[dep[1]])
                    return true;
            }
        }

        pathVisited[curr]=false;
        return false;
    }
}