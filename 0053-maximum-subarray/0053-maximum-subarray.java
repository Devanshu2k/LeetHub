class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currSum = 0;

        for(int right=0;right<nums.length;right++){
            currSum+=nums[right];

            maxSum = maxSum>currSum?maxSum:currSum;

            if(currSum<0){
                currSum = 0;
            }
        }

        return maxSum;
    }
}