class NumArray {
    int[] psa;

    public NumArray(int[] nums) {
        int n = nums.length;
        psa = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            psa[i + 1] = psa[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return psa[right + 1] - psa[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */