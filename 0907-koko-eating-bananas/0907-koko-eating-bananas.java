class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int max = 0;

        // Find the maximum pile to set the upper bound of k
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int lo = 1;
        int hi = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long hrs = check(nums, mid);

            if (hrs <= h) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Method to calculate total hours needed to eat all bananas at speed k
    private long check(int[] nums, int k) {
        long hours = 0;
        for (int i : nums) {
            hours = hours + (long)Math.ceil((double)i/k) ; // This gives the ceiling of i/k
        }
        return hours;
    }
}