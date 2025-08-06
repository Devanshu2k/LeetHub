class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int i = 0, j = n - 1;
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();
        long total = 0;

        // Fill both heaps initially
        for (int c = 0; c < candidates && i <= j; c++) front.offer(costs[i++]);
        for (int c = 0; c < candidates && i <= j; c++) back.offer(costs[j--]);

        while (k-- > 0) {
            if (back.isEmpty() || (!front.isEmpty() && front.peek() <= back.peek())) {
                total += front.poll();
                if (i <= j) front.offer(costs[i++]);
            } else {
                total += back.poll();
                if (i <= j) back.offer(costs[j--]);
            }
        }

        return total;
    }
}
