class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int idx = n - 1;
        int[] ret = new int[n];
        while (left <= right) {
            int lSqr = nums[left] * nums[left];
            int rSqr = nums[right] * nums[right];
            if (lSqr > rSqr) {
                ret[idx] = lSqr;
                idx--;
                left++;
            } else {
                ret[idx] = rSqr;
                idx--;
                right--;
            }
        }
        return ret;
    }
}