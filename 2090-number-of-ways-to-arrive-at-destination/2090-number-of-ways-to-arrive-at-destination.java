class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        ArrayList<int[]>[] adjList = new ArrayList[n];
        long[] dist = new long[n];
        long[] ways = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1]));

        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            adjList[road[0]].add(new int[]{road[1], road[2]});
            adjList[road[1]].add(new int[]{road[0], road[2]});
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] currPair = pq.remove();
            int currNode = (int)currPair[0];
            long currDist = currPair[1];

            for(int[] neighbor : adjList[currNode]){

                if(dist[neighbor[0]] > currDist + neighbor[1]){
                    dist[neighbor[0]] = dist[currNode] + neighbor[1];
                    ways[neighbor[0]] = ways[currNode];
                    pq.add(new long[]{neighbor[0],dist[neighbor[0]]});
                }
                else if(dist[neighbor[0]] == currDist + neighbor[1]){
                    ways[neighbor[0]] = (ways[neighbor[0]] + ways[currNode]) % MOD;
                }
            }
        }


        return (int)ways[n-1];

    }
}