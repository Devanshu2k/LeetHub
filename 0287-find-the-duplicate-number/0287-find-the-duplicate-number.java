class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = (hi+lo)/2;

            if(nums[mid] <= mid){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }

        return nums[lo];
    }
}