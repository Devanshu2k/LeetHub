class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // initialize with first 3 elements

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // Update closest if this sum is better
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum; // exact match → best possible
                } else if (sum < target) {
                    j++; // need a larger sum
                } else {
                    k--; // need a smaller sum
                }
            }
        }
        return closestSum;
    }
}