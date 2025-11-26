class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 1;
        int hi = 0;

        // Set lo to the max weight and hi to the sum of all weights
        for (int weight : weights) {
            lo = lo>weight?lo:weight;
            hi += weight;
        }

        // Binary search to find the minimum capacity
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (time(weights, mid) <= days) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo; // Return lo as it represents the minimum capacity needed
    }

    // Method to calculate total days needed for a given capacity
    int time(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            currentLoad += weight;

            if (currentLoad > capacity) {
                days++;
                currentLoad = weight; // Start new day with current weight
            }
        }

        return days;
    }
}
