class Solution {
    List<Integer>[] convert(int[][] edges,int n){
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        return adjList;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        List<Integer>[] adjList = convert(edges,n);
        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        Set<Integer> cycle = new HashSet<>();
        dfs(adjList,visited,1,-1,path,cycle);

        for(int i=n-2;i>=0;i--){
            int[] edge = edges[i];
            if(cycle.contains(edge[0]) && cycle.contains(edge[1]))
                return edge;
        }

        return new int[]{};

    }

    boolean dfs(List<Integer>[] adjList, boolean[] visited, int curr, int parent, List<Integer> path, Set<Integer> cycle) {
        visited[curr] = true;
        path.add(curr);

        for (int neighbor : adjList[curr]) {
            if (neighbor == parent) continue; // Skip the parent node
            if (!visited[neighbor]) {
                if (dfs(adjList, visited, neighbor, curr, path, cycle))
                    return true;
            } else {
                // Cycle detected, collect cycle nodes
                int idx = path.lastIndexOf(neighbor);
                for (int i = idx; i < path.size(); i++) {
                    cycle.add(path.get(i));
                }
                return true; // Stop after finding the first cycle
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}