class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n-1;

        int[] ans = new int[n];
        int curr = n-1;

        while(l<=r){
            if(Math.abs(nums[l])>Math.abs(nums[r])){
                ans[curr--] = nums[l]*nums[l];
                l++;
            } else{
                ans[curr--] = nums[r]*nums[r];
                r--;
            }
        }

        return ans;
    }
}