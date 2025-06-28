class NumArray {
    int[] PSA;
    public NumArray(int[] nums) {
        int n = nums.length;
        PSA = new int[n];
        PSA[0] = nums[0];
        for(int i=1;i<n;i++){
            PSA[i] = PSA[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0)
            return PSA[right];
        
        return PSA[right]  - PSA[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */