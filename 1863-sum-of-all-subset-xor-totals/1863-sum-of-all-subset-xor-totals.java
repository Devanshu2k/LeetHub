class Solution {
    int total = 0;
    public int subsetXORSum(int[] nums) {
        sum(nums,0,0);
        return total;
    }

    void sum(int[]nums,int curr,int sum){
        if(curr==nums.length){
            total+=sum;
            return;
        }

        sum(nums,curr+1,sum^nums[curr]);
        sum(nums,curr+1,sum);
    }
}