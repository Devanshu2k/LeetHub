class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] degree = new int[n];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // start with all initial leaves
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            result = new ArrayList<>(); // store only last layer

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                result.add(node);

                for (int nei : adj.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        return result;
    }
}
