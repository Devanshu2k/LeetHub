class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        // Min-heap storing: {value, rowIndex, indexInRow}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int currentMax = Integer.MIN_VALUE;
        int k = nums.size();

        // Step 1: Push first element from each list into the heap
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }

        int bestStart = 0;
        int bestEnd = Integer.MAX_VALUE;

        // Step 2: Repeatedly pop smallest & push next element from that list
        while (true) {
            int[] curr = pq.poll();
            int val = curr[0];
            int row = curr[1];
            int idx = curr[2];

            // Update the smallest range
            if (currentMax - val < bestEnd - bestStart) {
                bestStart = val;
                bestEnd = currentMax;
            }

            // If this list is exhausted, stop — cannot cover all lists anymore
            if (idx + 1 == nums.get(row).size())
                break;

            // Push next element from same row
            int nextVal = nums.get(row).get(idx + 1);
            pq.offer(new int[]{nextVal, row, idx + 1});

            // Update current max
            currentMax = Math.max(currentMax, nextVal);
        }

        return new int[]{bestStart, bestEnd};
    }
}
