class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i:rooms.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }

        for(boolean b:visited){
            if(b==false)
                return false;
        }
        return true;
    }
}