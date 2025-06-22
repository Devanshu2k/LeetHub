class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public static final int MOD = 1000000007;
    public List<int[]>[] convert(int[][]roads,int n){
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]= new ArrayList<>();
        
        for(int[] road:roads){
            adj[road[0]].add(new int[]{road[1],road[2]});
            adj[road[1]].add(new int[]{road[0],road[2]});
        }

        return adj;
    }    
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adj = convert(roads,n);

        int[] distArray = new int[n];
        Arrays.fill(distArray,Integer.MAX_VALUE);
        distArray[0]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new Pair(0,0));

        int[] ways=new int[n];
        ways[0]=1;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.dist;
            
            for(int[] neighbor:adj[node]){
                int nbor = neighbor[0];
                int cost = neighbor[1];
                if(distArray[nbor]>dist+cost){
                    distArray[nbor] = (dist+cost)%MOD;
                    ways[nbor]=ways[node];
                    pq.offer(new Pair(nbor,distArray[nbor]));
                }
                else if(distArray[nbor]==dist+cost){
                   ways[nbor] = (ways[nbor] + ways[node])%MOD;
                }
            }
        }

      
        return ways[n-1]%MOD;
    }
}