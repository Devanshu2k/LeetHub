class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int n = nums.length -1;
        int i=0;
        for(;i<n;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            nums[count++]=nums[i];
        }
        nums[count++]=nums[i];

        return count;
    }
}