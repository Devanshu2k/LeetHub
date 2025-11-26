class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0) return new int[0];
    int n = nums.length;
    int[] result = new int[n - k + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max heap on element value

    for (int i = 0; i < n; i++) {
        pq.offer(new int[]{nums[i], i});
        if (i >= k - 1) {
            while (pq.peek()[1] <= i - k) {
                pq.poll(); // remove elements out of the current window
            }
            result[i - k + 1] = pq.peek()[0]; // max in the current window
        }
    }
    return result;
}
}