class Solution {
    public long maximumMedianSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int j =n-2;

        long sum = 0;

        while(i<j){
            sum+=nums[j];
            i++;
            j-=2;
        }

        return sum;
    }
}
