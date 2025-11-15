class NumArray {
    int[] psa;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        psa = new int[n];
        psa[0] = nums[0];
        for(int i=1;i<n;i++){
            psa[i] = nums[i]+psa[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return psa[right]-psa[left]+nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */