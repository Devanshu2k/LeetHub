class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each value in its correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correct = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        // Step 2: Find first mismatch
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
}
